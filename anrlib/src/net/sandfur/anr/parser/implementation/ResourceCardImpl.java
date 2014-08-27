package net.sandfur.anr.parser.implementation;

import net.sandfur.anr.card.ResourceCard;

public class ResourceCardImpl extends BaseCard implements ResourceCard {
	int cost;
	
	@Override
	public int getCost() {
		return cost;
	}

}
