package net.sandfur.anrlib.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.Card.Type;
import net.sandfur.anr.testhelper.CardData;

import org.junit.Before;
import org.junit.Test;

public class PlayerDeckTest {
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIfValidCorp_true() throws IOException {
		PlayerDeck deck = getHbDeck();
		assertTrue("Deck should be valid.", deck.isValid());
		assertEquals("Should be 49 cards in testdata.", 49, deck.getSize());
	}
	
	@Test
	public void isValid_invalidDeckSize() throws IOException {
		PlayerDeck deck = new PlayerDeck();
		
		deck.initFrom(CardData.deck_hb().subList(0, 45));
		assertFalse("Deck is not valid.", deck.isValid());
		assertEquals("Should be 44 cards in testdata (excluding identity).", 44, deck.getSize());
	}
	
	@Test
	public void isValid_noIdentity() throws IOException {
		PlayerDeck deck = new PlayerDeck();
		List<Card> cards = CardData.deck_hb();
		cards.remove(0);
		deck.initFrom(cards);
		assertFalse("Deck should miss identity.", deck.isValid());
	}

	@Test
	public void testCorpCardTypes() throws IOException {
		PlayerDeck deck = getHbDeck();
		assertCardType(10, Type.agenda, deck.getAgendas());
		assertCardType(6, Type.asset, deck.getAssets());
		assertCardType(18, Type.ice, deck.getIce());
		assertCardType(13, Type.operation, deck.getOperations());
		assertCardType(2, Type.upgrade, deck.getUpgrades());
		assertCardType(0, Type.event, deck.getEvents());
		assertCardType(0, Type.hardware, deck.getHardwares());
		assertCardType(0, Type.program, deck.getPrograms());
		assertCardType(0, Type.resource, deck.getResources());
	}

	
	@Test
	public void getEvents() throws IOException {
		PlayerDeck deck = getReinaDeck();
		assertCardType(0, Type.agenda, deck.getAgendas());
		assertCardType(0, Type.asset, deck.getAssets());
		assertCardType(0, Type.ice, deck.getIce());
		assertCardType(0, Type.operation, deck.getOperations());
		assertCardType(0, Type.upgrade, deck.getUpgrades());
		assertCardType(16, Type.event, deck.getEvents());
		assertCardType(4, Type.hardware, deck.getHardwares());
		assertCardType(20, Type.program, deck.getPrograms());
		assertCardType(5, Type.resource, deck.getResources());
	}
	

	private void assertCardType(int size, Type type, List<? extends Card> cards) {
		assertEquals(String.format("Should have gotten %d cards", size), size, cards.size());
		for(Card card : cards) {
			if(card.getType() != type) {
				fail(String.format("At least one of the cards is not of type %s", type.toString()));
			}
		}	
	}

	private PlayerDeck getHbDeck() throws IOException {
		PlayerDeck deck = new PlayerDeck();
		deck.initFrom(CardData.deck_hb());
		return deck;
	}
	private PlayerDeck getReinaDeck() throws IOException {
		PlayerDeck deck = new PlayerDeck();
		deck.initFrom(CardData.deck_reina());
		return deck;
	}	
	@Test
	public void testIfValidRunner_true() throws IOException {
		PlayerDeck deck = new PlayerDeck();
		deck.initFrom(CardData.deck_reina());
		assertTrue(deck.isValid());
	}
	
	@Test
	public void testIfValidProfessor_true() throws IOException {
		PlayerDeck deck = new PlayerDeck();
		deck.initFrom(CardData.deck_professor());
		assertTrue(deck.isValid());
	}
}
