package net.sandfur.anr.card.util.filter;

import java.util.List;

import net.sandfur.anr.card.Card;

interface CardFilter {
	List<Card> filter(List<Card> cards);
}
