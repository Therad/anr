package net.sandfur.anr.parser.implementation;

import net.sandfur.anr.card.AssetCard;

public class AssetCardImpl extends BaseCard implements AssetCard {

	private int trash;
	private int cost;

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public int getTrashCost() {
		// TODO Auto-generated method stub
		return trash;
	}

}
