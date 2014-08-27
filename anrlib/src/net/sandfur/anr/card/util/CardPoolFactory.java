package net.sandfur.anr.card.util;

public class CardPoolFactory {

	public static CardPool create(CardPoolParser parser) {
		CardPool ret = new CardPool();
		while(parser.hasNext()) {
			ret.addCard(parser.getNext());
		}
		return ret;
	}
}
