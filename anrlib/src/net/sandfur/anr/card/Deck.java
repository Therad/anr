package net.sandfur.anr.card;

import java.util.List;

public interface Deck {
	public abstract boolean isValid();
	public abstract IdentityCard getIdentity();
}
