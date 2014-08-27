package net.sandfur.anr.tournament;

import java.util.List;

import net.sandfur.anrlib.TournamentRoundFactory;

import org.junit.Before;
import org.junit.Test;

public class TournamentTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddPlayer() {
		TournamentRound round;

		SwissTournament tour = createTournamentWdata();
		
		round = TournamentRoundFactory.createSwissRound(tour);
		tour.addRound(round);

		round = TournamentRoundFactory.createSwissRound(tour);
		tour.addRound(round);

		round = TournamentRoundFactory.createSwissRound(tour);
		tour.addRound(round);

		round = TournamentRoundFactory.createSwissRound(tour);
		tour.addRound(round);

		List<TournamentPlayer> ranking = tour.getPlayerRanked();
	}
	
	@Test
	public void testRanking() {
		TournamentRound round;
		List<TournamentMatch> matches;
		SwissTournament tour = createTournamentWdata();
		
		round = TournamentRoundFactory.createSwissRound(tour);
		tour.addRound(round);
		matches = round.getUnfinishedMatches();
		addAlternateWin(matches);

		round = TournamentRoundFactory.createSwissRound(tour);
		tour.addRound(round);
		matches = round.getUnfinishedMatches();
		addAlternateWin(matches);

		List<TournamentPlayer> ranking = tour.getPlayerRanked();
	}
	
	
	private void addAlternateWin(List<TournamentMatch> matches) {
		for(int i=0; i < matches.size(); i++) {
			if(i%2 == 0) {
				matches.get(i).addCorpWin();
			}
			else {
				matches.get(i).addRunnerWin();
			}
		}
	}

	SwissTournament createTournamentWdata() {
		SwissTournament tour = new SwissTournament();
		
		tour.addPlayer(new TournamentPlayer("Luffy"));
		tour.addPlayer(new TournamentPlayer("Zoro"));
		tour.addPlayer(new TournamentPlayer("Nami"));
		tour.addPlayer(new TournamentPlayer("Usopp"));
		tour.addPlayer(new TournamentPlayer("Sanji"));
		tour.addPlayer(new TournamentPlayer("Tony Tony Chopper"));
		tour.addPlayer(new TournamentPlayer("Nico Robin"));
		tour.addPlayer(new TournamentPlayer("Franky"));
		tour.addPlayer(new TournamentPlayer("Bones"));

		return tour;
	}

}
