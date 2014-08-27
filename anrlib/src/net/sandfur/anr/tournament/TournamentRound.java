package net.sandfur.anr.tournament;

import java.util.LinkedList;
import java.util.List;

public class TournamentRound {
	List<TournamentMatch> matches = new LinkedList<>();

	public TournamentRound() {
	}

	public void addMatch(TournamentPlayer tournamentPlayer, TournamentPlayer tournamentPlayer2) {
		addMatch(new TournamentMatch(tournamentPlayer, tournamentPlayer2));
		addMatch(new TournamentMatch(tournamentPlayer2, tournamentPlayer));
	}

	public void addMatch(TournamentMatch tournamentMatch) {
		matches.add(tournamentMatch);
	}

	public List<TournamentMatch> getMatches() {
		// TODO Auto-generated method stub
		return matches;
	}
	
	public List<TournamentMatch> getUnfinishedMatches() {
		LinkedList<TournamentMatch> unfinished = new LinkedList<TournamentMatch>();
		for (TournamentMatch match : matches) {
			if(!match.isFinished()) {
				unfinished.add(match);
			}
		}
		return unfinished;
	}
}
