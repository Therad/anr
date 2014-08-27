package net.sandfur.anr.card.util;

import java.text.Normalizer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import net.sandfur.anr.card.Card;

public class CardPool {
	List<Card> pool = new LinkedList<Card>();
	
	public void addCard(Card card) {
		pool.add(card);
	}
	
	public List<Card> getAllCards() {
		return new LinkedList<Card>(pool);
	}
	
	public Card fetchById(int id) {
		for(Card card : pool) {
			if(id == card.getId()) {
				return card;
			}
		}
		return null;
	}
	
	public Card fetchByTitle(String name) {
		for(Card card : pool) {
			if(isEqualAfterNormalisation(name, card.getTitle())) {
				return card;
			}
		}
		return null;
	}
    private boolean isEqualAfterNormalisation(String name, String title) {
		return stripAccents(name).equalsIgnoreCase(stripAccents(title));
	}

	private static String stripAccents(final String input) {
        if(input == null) {
            return null;
        }
        final Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");//$NON-NLS-1$
        final String decomposed = Normalizer.normalize(input, Normalizer.Form.NFD);
        // Note that this doesn't correctly remove ligatures...
        return pattern.matcher(decomposed).replaceAll("");//$NON-NLS-1$
    }	
	
}
