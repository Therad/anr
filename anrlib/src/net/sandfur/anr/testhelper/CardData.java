package net.sandfur.anr.testhelper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.util.CardPool;
import net.sandfur.anr.card.util.CardPoolFactory;
import net.sandfur.anr.parser.NetrunnerDbParser;
import net.sandfur.anr.parser.TextDeckParser;

public class CardData {

	public static CardPool cardPool_CoreSet() throws FileNotFoundException {
		NetrunnerDbParser parser = new NetrunnerDbParser();
		parser.initFromFile("testdata/core_set.json");
		return CardPoolFactory.create(parser); 		
	}
	
	public static CardPool cardPool_Latest() throws FileNotFoundException {
		NetrunnerDbParser parser = new NetrunnerDbParser();
		parser.initFromFile("testdata/cards.json");
		return CardPoolFactory.create(parser); 		
	}
	
	public static List<Card> deck_hb() throws IOException {
		TextDeckParser parser = new TextDeckParser();
		parser.setPool(cardPool_Latest());
		return parser.parse(new FileReader("testdata/deck/hb_etf--meteor.txt"));
	}

	public static List<Card> deck_reina() throws IOException {
		TextDeckParser parser = new TextDeckParser();
		parser.setPool(cardPool_Latest());
		return parser.parse(new FileReader("testdata/deck/anarch_reina--meteor.txt"));
	}
	
	public static List<Card> deck_professor() throws IOException {
		TextDeckParser parser = new TextDeckParser();
		parser.setPool(cardPool_Latest());
		return parser.parse(new FileReader("testdata/deck/shaper_professor--netrunnerdb.txt"));
	}
}
