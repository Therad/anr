package net.sandfur.anr.parser.implementation;

import net.sandfur.anr.card.IceCard;

public class IceCardImpl extends BaseCard implements IceCard {

	private int cost;
	private int strength;

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public int getStrength() {
		return strength;
	}

}
