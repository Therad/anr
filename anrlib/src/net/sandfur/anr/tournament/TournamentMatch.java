package net.sandfur.anr.tournament;

public class TournamentMatch {
	private static final int WINPRESTIGE = 2;
	private static final int TIMEPRESTIGE = 1;
	private static final int LOSEPRESTIGE = 0;
	
	TournamentPlayer corpPlayer = null;
	TournamentPlayer runnerPlayer = null;
	
	boolean finished = false;
	
	public TournamentMatch() {
	}

	public TournamentMatch(TournamentPlayer corp, TournamentPlayer runner) {
		addCorpPlayer(corp);
		addRunnerPlayer(runner);
	}

	public void addCorpPlayer(TournamentPlayer player) {
		corpPlayer = player;
	}
	public void addRunnerPlayer(TournamentPlayer player) {
		runnerPlayer = player;
	}
	
	public boolean isFinished() {
		return finished;
	}

	public void addCorpWin() {
		corpPlayer.addPrestige(WINPRESTIGE);
		finished = true;
	}
	
	public void addRunnerWin() {
		runnerPlayer.addPrestige(WINPRESTIGE);
		finished = true;
	}

	public void addWin(TournamentPlayer player) {
		if(corpPlayer == player) {
			addCorpWin();
		}
		else if(runnerPlayer == player) {
			addRunnerWin();
		}
	}
}
