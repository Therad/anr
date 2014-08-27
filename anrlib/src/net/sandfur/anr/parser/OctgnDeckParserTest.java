package net.sandfur.anr.parser;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.util.CardPool;
import net.sandfur.anr.testhelper.CardData;
import net.sandfur.anrlib.deck.DeckParseException;

import org.junit.Before;
import org.junit.Test;

public class OctgnDeckParserTest {

	CardPool pool;
	
	@Before
	public void setUp() throws Exception {
		pool = CardData.cardPool_Latest();
	}

	@Test
	public void testParse_Meteor() throws IOException, DeckParseException {
		OctgnDeckParser parser = new OctgnDeckParser();
		parser.setPool(pool);
		List<Card> deck = parser.parse(new FileReader("testdata/deck/hb_etf--octgn.o8d"));
		assertNotNull(deck);
		assertEquals(50, deck.size()); // identity + 49 cards
	}

}
