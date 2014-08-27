package net.sandfur.anrlib.deck;

import java.util.List;

import net.sandfur.anr.card.Deck;
import net.sandfur.anr.card.EventCard;
import net.sandfur.anr.card.HardwareCard;
import net.sandfur.anr.card.IdentityCard;
import net.sandfur.anr.card.ProgramCard;
import net.sandfur.anr.card.ResourceCard;

public interface RunnerDeck extends Deck {

	public abstract List<ResourceCard> getResources();

	public abstract List<ProgramCard> getPrograms();

	public abstract List<HardwareCard> getHardwares();

	public abstract List<EventCard> getEvents();

	public abstract IdentityCard getIdentity();

	public abstract boolean isValid();

}
