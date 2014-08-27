package net.sandfur.anr.card.util.filter;

import static org.junit.Assert.*;

import java.util.List;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.Card.Type;
import net.sandfur.anr.card.util.CardPool;
import net.sandfur.anr.card.util.CardPoolFactory;
import net.sandfur.anr.parser.NetrunnerDbParser;

import org.junit.Before;
import org.junit.Test;

public class AgendaFilterTest {
	List<Card> cards;
	
	@Before
	public void setUp() throws Exception {
		NetrunnerDbParser parser = new NetrunnerDbParser();
		parser.initFromFile("testdata/core_set.json");
		CardPool pool = CardPoolFactory.create(parser);
		
		cards = pool.getAllCards();
	}

	@Test
	public void test() {
		List<Card> filteredCards = new AgendaFilter().filter(cards);
		
		assertFilteredSize(filteredCards, 8);
		
		for(Card card : filteredCards) {
			assertEquals(Type.agenda, card.getType());
		}
	}

	@Test
	public void testAgendaAdvancementPoints() {
		List<Card> filteredCards = new AgendaFilter()
			.advancementCostRange(3,3).filter(cards);
		
		assertFilteredSize(filteredCards, 3);
		
		for(Card card : filteredCards) {
			assertEquals(Type.agenda, card.getType());
		}
	}
	
	private void assertFilteredSize(List<Card> filteredCards, int i) {
		assertTrue("Wrong number of cards filtered. Found: " + filteredCards.size(), filteredCards.size() == i);
	}
}

