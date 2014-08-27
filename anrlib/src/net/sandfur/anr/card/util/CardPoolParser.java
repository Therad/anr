package net.sandfur.anr.card.util;

import net.sandfur.anr.card.Card;


public interface CardPoolParser  {
	public Card getNext()  throws IllegalStateException;
	public boolean hasNext();
}
