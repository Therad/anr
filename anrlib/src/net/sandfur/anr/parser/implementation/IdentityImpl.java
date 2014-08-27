package net.sandfur.anr.parser.implementation;

import net.sandfur.anr.card.IdentityCard;

public class IdentityImpl extends BaseCard implements IdentityCard {
	int baselink; 
	int influencelimit; 
	int minimumdecksize;
	
	@Override
	public int getMinimumdecksize() {
		return minimumdecksize;
	}

	@Override
	public int getInfluencelimit() {
		return influencelimit;
	}

	@Override
	public int getBaselink() {
		return baselink;
	}
}
