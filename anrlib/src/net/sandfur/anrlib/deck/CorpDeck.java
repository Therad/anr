package net.sandfur.anrlib.deck;

import java.util.List;

import net.sandfur.anr.card.AgendaCard;
import net.sandfur.anr.card.AssetCard;
import net.sandfur.anr.card.Deck;
import net.sandfur.anr.card.IceCard;
import net.sandfur.anr.card.OperationCard;
import net.sandfur.anr.card.UpgradeCard;


public interface CorpDeck extends Deck {

	public abstract List<UpgradeCard> getUpgrades();

	public abstract List<OperationCard> getOperations();

	public abstract List<IceCard> getIce();

	public abstract List<AssetCard> getAssets();

	public abstract List<AgendaCard> getAgendas();

}
