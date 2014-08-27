package net.sandfur.anr.card;

import java.util.Collections;
import java.util.LinkedList;

public class CardCollection extends LinkedList<Card> {

	public void shuffle() {
		Collections.shuffle(this);
	}
}
