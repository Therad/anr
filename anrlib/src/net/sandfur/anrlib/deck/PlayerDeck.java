package net.sandfur.anrlib.deck;

import java.util.LinkedList;
import java.util.List;

import net.sandfur.anr.card.AgendaCard;
import net.sandfur.anr.card.AssetCard;
import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.Card.Type;
import net.sandfur.anr.card.EventCard;
import net.sandfur.anr.card.HardwareCard;
import net.sandfur.anr.card.IceCard;
import net.sandfur.anr.card.IdentityCard;
import net.sandfur.anr.card.OperationCard;
import net.sandfur.anr.card.ProgramCard;
import net.sandfur.anr.card.ResourceCard;
import net.sandfur.anr.card.UpgradeCard;

public class PlayerDeck implements CorpDeck, RunnerDeck {

	private IdentityCard identity;
	private List<Card> deck;


	@Override
	public boolean isValid() {
		if(identity == null || overInfluenceLimit()) {
			return false;
		}
		
		if(deck.size() < identity.getMinimumdecksize()) {
			return false;
		}

		for(Card card : deck) {
			if(card.isRunner() != identity.isRunner()){
				return false;
			}
		}
		return true;
	}

	private boolean overInfluenceLimit() {
		return getUsedInfluence() > identity.getInfluencelimit();
	}
	
	public int getUsedInfluence() {
		
		// The professor uses a different algorithm to calculate used influence
		if(identity.getId() == 3029) {
			return professorUsedInfluence();
		}
		int currentInfluence = 0;
		
		for(Card card : deck) {
			if(identity.getFaction() != card.getFaction()) {
				currentInfluence += card.getInfluence();
			}
		}
		return currentInfluence;
	}
	
	private int professorUsedInfluence() {
		List<Integer> usedPrograms = new LinkedList<>(); 
		int currentInfluence = 0;
		
		for(Card card : deck) {
			if(identity.getFaction() != card.getFaction()) {
				if(card.getType() == Type.program) {
					if( !usedPrograms.contains(card.getId())) {
						usedPrograms.add(card.getId());
						currentInfluence -= card.getInfluence();						
					}
					
				}
				currentInfluence += card.getInfluence();
			}
		}
		return currentInfluence;
	}

	public void initFrom(List<Card> cards) {
		deck = new LinkedList<>();
		identity = null;
		
		for(Card card : cards) {
			addCard(card);
		}
	}
	
	private void addCard(Card card) {
		
		switch(card.getType()) {
		case identity: 
			identity = (IdentityCard) card;
			break;
		default:
			deck.add(card);
		}
	}


	public int getSize() {
		return deck.size();
	}


	@Override
	public IdentityCard getIdentity() {
		return identity;
	}
	
	@Override
	public List<AgendaCard> getAgendas() {
		return getCardsOfType(Type.agenda);
	}
	
	@Override
	public List<AssetCard> getAssets() {
		return getCardsOfType(Type.asset);
	}
	
	@Override
	public List<IceCard> getIce() {
		return getCardsOfType(Type.ice);
	}

	@Override
	public List<OperationCard> getOperations() {
		return getCardsOfType(Type.operation);
	}
	
	@Override
	public List<UpgradeCard> getUpgrades() {
		return getCardsOfType(Type.upgrade);
	}
	
	@Override
	public List<EventCard> getEvents() {
		return getCardsOfType(Type.event);
	}
	
	@Override
	public List<HardwareCard> getHardwares() {
		return getCardsOfType(Type.hardware);
	}

	@Override
	public List<ProgramCard> getPrograms() {
		return getCardsOfType(Type.program);
	}

	@Override
	public List<ResourceCard> getResources() {
		return getCardsOfType(Type.resource);
	}
	
	

	@SuppressWarnings("unchecked")
	private <T extends Card> List<T> getCardsOfType(Type type) {
		LinkedList<T> cards = new LinkedList<>();
		for(Card card : deck) {
			if(card.getType() == type) {
				cards.add((T) card);
			}
		}
		return cards;
	}
}
