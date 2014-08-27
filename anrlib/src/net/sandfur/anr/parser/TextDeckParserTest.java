package net.sandfur.anr.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.util.CardPool;
import net.sandfur.anr.testhelper.CardData;

import org.junit.Before;
import org.junit.Test;

public class TextDeckParserTest {

	CardPool pool;
	
	@Before
	public void setUp() throws Exception {
		pool = CardData.cardPool_Latest();
	}

	@Test
	public void testParse_Meteor() throws IOException {
		TextDeckParser parser = new TextDeckParser();
		parser.setPool(pool);
		List<Card> deck = parser.parse(new FileReader("testdata/deck/hb_etf--meteor.txt"));
		assertNotNull(deck);
		assertEquals(50, deck.size()); // identity + 49 cards
	}

	@Test
	public void testParse_netrunnerDB() throws IOException {
		TextDeckParser parser = new TextDeckParser();
		parser.setPool(pool);
		List<Card> deck = parser.parse(new FileReader("testdata/deck/hb_etf--netrunnerdb.txt"));
		assertNotNull(deck);
		assertEquals(50, deck.size()); // identity + 49 cards
	}
}
