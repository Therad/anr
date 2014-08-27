package net.sandfur.anr;

import net.sandfur.anr.card.Card;

public class AnrPrint {

	static void print(Card card) {
		switch(card.getType()) {
			default:
				System.out.println(card.getTitle() + " - " + card.getType() +" ("+card.getFaction()+")" );
		}
	}


}
