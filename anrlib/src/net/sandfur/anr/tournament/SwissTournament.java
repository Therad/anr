package net.sandfur.anr.tournament;

import java.util.LinkedList;
import java.util.List;

public class SwissTournament implements Tournament {
	List<TournamentPlayer> players = new LinkedList<>();
	LinkedList<TournamentRound> rounds = new LinkedList<>();

	public void addPlayer(TournamentPlayer tournamentPlayer) {
		players.add(tournamentPlayer);
	}
	
	public int countPlayers() {
		return players.size();
	}

	public List<TournamentPlayer> getPlayerRanked() {
		return players;
	}

	public void addRound(TournamentRound round) {
		rounds.add(round);
	}
	
	public List<TournamentRound> getRounds() {
		return new LinkedList<>(rounds);
	}

	public TournamentRound getCurrentRound() {
		return rounds.peekLast();
	}
}
