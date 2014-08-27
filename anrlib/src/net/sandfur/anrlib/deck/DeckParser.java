package net.sandfur.anrlib.deck;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.util.CardPool;

public interface DeckParser {

	void setPool(CardPool pool);
	List<Card> parse(Reader reader) throws IOException, DeckParseException;

}
