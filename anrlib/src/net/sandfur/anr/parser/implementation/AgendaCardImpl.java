package net.sandfur.anr.parser.implementation;

import net.sandfur.anr.card.AgendaCard;

public class AgendaCardImpl extends BaseCard implements AgendaCard {

	int advancementcost; 
	int agendapoints;
	
	@Override
	public int getAgendaPoints() {
		// TODO Auto-generated method stub
		return agendapoints;
	}

	@Override
	public int getAdvancementCost() {
		// TODO Auto-generated method stub
		return advancementcost;
	}

}
