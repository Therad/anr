package net.sandfur.anr.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.util.CardPool;
import net.sandfur.anrlib.deck.DeckParser;
import net.sandfur.util.Patternize;

public class TextDeckParser implements DeckParser {
	CardPool cardpool;
	
	Pattern identityPattern;
	Pattern cardPattern;
	
	final String COUNT = "count";
	final String CARDNAME = "cardname";
	final String EXTRA = "extra";
	
	public TextDeckParser() {
		
		Patternize pattern = new Patternize()
			.addNamedGroup("\\d+?", COUNT)
			.closeGroup()
			.add("x?")
			.add("\\s*")
			.addNamedGroup(".*?", CARDNAME)
			.closeGroup()
			.add("\\s*")
			.addNamedGroup("(\\(.*\\).*?)?", EXTRA);
		
		cardPattern = Pattern.compile(pattern.toString());
		
		
		pattern = new Patternize()
			.addNamedGroup(".+?", CARDNAME)
			.closeGroup()
			.add("\\s*") // TODO add a NOT MATCH (\d cards)
			.addNamedGroup("(\\(.*\\))?", EXTRA);
		
		identityPattern = Pattern.compile(pattern.toString());
	}

	@Override
	public void setPool(CardPool pool) {
		cardpool = pool;
	}

	@Override
	public List<Card> parse(Reader reader) throws IOException {
		LinkedList<Card> returnValue = new LinkedList<Card>();
		BufferedReader breader = new BufferedReader(reader);
		
		String line;
		while( (line = breader.readLine()) != null)
		{
			returnValue.addAll(extractCards(line));
		}

		return returnValue;
	}

	private List<Card> extractCards(String line) {
		LinkedList<Card> returnValue = new LinkedList<Card>();
		
		Card card = extractCard(line);
		if( card != null ) {
			int number = extractCount(line);
			for(int i = 0; i < number; i++) {
				returnValue.add(card);
			}
		}
		
		return returnValue;
	}

	private int extractCount(String line) {
		Matcher cardMatcher = cardPattern.matcher(line);

		if(cardMatcher.matches()) {
			return Integer.parseInt(cardMatcher.group(COUNT));
		}
		return 1;
	}

	private Card extractCard(String line) {
		Card card;
		card = extractIdentity(line);
		
		if(card == null) {
			card = extractOtherCard(line);
		}
		
		return card;
	}

	private Card extractOtherCard(String line) {
		Matcher cardMatcher = cardPattern.matcher(line);
		if(cardMatcher.matches()) {
			return cardpool.fetchByTitle(cardMatcher.group(CARDNAME));
		}
		return null;
	}

	private Card extractIdentity(String line) {
		Matcher idMatcher = identityPattern.matcher(line);
		if(idMatcher.matches()) {
			return cardpool.fetchByTitle(idMatcher.group(CARDNAME));
		}
		return null;
	}
}
