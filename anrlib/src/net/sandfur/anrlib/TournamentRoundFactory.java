package net.sandfur.anrlib;

import java.util.List;

import net.sandfur.anr.tournament.SwissTournament;
import net.sandfur.anr.tournament.TournamentPlayer;
import net.sandfur.anr.tournament.TournamentRound;

public class TournamentRoundFactory {

	public static TournamentRound createSwissRound(SwissTournament tour) {
		List<TournamentPlayer> players = tour.getPlayerRanked();
		
		addByeIfNeeded(players);
		
		if(tour.getRounds().size() == 0) {
			return firstRoundPairing(players);
		}
		
		return createRound(players, tour.getRounds());
	}


	private static TournamentRound createRound(List<TournamentPlayer> players, List<TournamentRound> rounds) {
		TournamentRound round = new TournamentRound();
		return round;
	}

	/**
	 * 
	 * Pairs the first half of contestants with the second half.
	 */
	private static TournamentRound firstRoundPairing(List<TournamentPlayer> players) {
		TournamentRound round = new TournamentRound();
		int halfPoint = players.size()/2;
		
		for(int i = 0; i < halfPoint; i++) {
			TournamentPlayer player1 = players.get(i);
			TournamentPlayer player2 = players.get(halfPoint + i);
			
			round.addMatch(player1, player2);
			round.addMatch(player2, player1);
		}
		
		return round;
	}

	private static void addByeIfNeeded(List<TournamentPlayer> players) {
		if(players.size() % 2 == 1) {
			players.add(TournamentPlayer.bye);
		}
	}
}
