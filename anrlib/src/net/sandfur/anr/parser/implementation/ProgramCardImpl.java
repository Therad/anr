package net.sandfur.anr.parser.implementation;

import net.sandfur.anr.card.ProgramCard;

public class ProgramCardImpl extends BaseCard implements ProgramCard {
	int cost;
	int memoryunits;
	int strength;
	
	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public int getMemoryUnits() {
		// TODO Auto-generated method stub
		return memoryunits;
	}

	@Override
	public int getStrength() {
		// TODO Auto-generated method stub
		return strength;
	}

}
