package net.sandfur.anr.card.util.filter;

import java.util.LinkedList;
import java.util.List;

import net.sandfur.anr.card.AgendaCard;
import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.Card.Type;

public class AgendaFilter implements CardFilter {
	int min = 0;
	int max = 99;
	
	@Override
	public List<Card> filter(List<Card> cards) {
		LinkedList<Card> returnList = new LinkedList<Card>();
		for(Card card : cards) {
			if( cardIsInFilterRange(card) ) {
				returnList.add(card);
			}
		}
		return returnList;
	}

	private boolean cardIsInFilterRange(Card card) {
		if(card.getType() != Type.agenda ) {
			return false;
		}
		
		AgendaCard agenda = (AgendaCard) card;
		
		if(agenda.getAdvancementCost() < min || agenda.getAdvancementCost() > max ) {
			return false;
		}
		
		return true;
	}

	public AgendaFilter advancementCostRange(int minimum, int maximum) {
		min = minimum;
		max = maximum;
		
		return this;
	}
}
