package net.sandfur.anr.tournament;

import net.sandfur.anrlib.deck.CorpDeck;
import net.sandfur.anrlib.deck.RunnerDeck;

public class TournamentPlayer {
	String name;
	CorpDeck corpDeck;
	RunnerDeck runnerDeck;
	private int prestige;
	
	public TournamentPlayer() {
	}
	public TournamentPlayer(String name) {
		setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CorpDeck getCorpDeck() {
		return corpDeck;
	}
	public void setCorpDeck(CorpDeck corpDeck) {
		this.corpDeck = corpDeck;
	}
	public RunnerDeck getRunnerDeck() {
		return runnerDeck;
	}
	public void setRunnerDeck(RunnerDeck runnerDeck) {
		this.runnerDeck = runnerDeck;
	}

	public void addPrestige(int winprestige) {
		prestige += winprestige;
	}
	
	public static final TournamentByePlayer bye = new TournamentByePlayer();
	
	static private class TournamentByePlayer extends TournamentPlayer {
		public TournamentByePlayer() {
			super("BYE");
		}		
	}

}
