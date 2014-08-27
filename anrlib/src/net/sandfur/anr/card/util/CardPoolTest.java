package net.sandfur.anr.card.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;

import net.sandfur.anr.card.AgendaCard;
import net.sandfur.anr.card.AssetCard;
import net.sandfur.anr.card.EventCard;
import net.sandfur.anr.card.HardwareCard;
import net.sandfur.anr.card.IceCard;
import net.sandfur.anr.card.IdentityCard;
import net.sandfur.anr.card.OperationCard;
import net.sandfur.anr.card.ProgramCard;
import net.sandfur.anr.card.ResourceCard;
import net.sandfur.anr.card.UpgradeCard;
import net.sandfur.anr.parser.NetrunnerDbParser;

import org.junit.Before;
import org.junit.Test;

public class CardPoolTest {
	CardPool pool;
	
	@Before
	public void setup() throws FileNotFoundException {
		NetrunnerDbParser parser = new NetrunnerDbParser();
		parser.initFromFile("testdata/core_set.json");
		pool = CardPoolFactory.create(parser); 
	}

	@Test
	public void testFetchPlayerId() {
		IdentityCard card = (IdentityCard) pool.fetchById(1033); 
		
		assertNotNull(card);
		assertEquals(1, card.getBaselink());
		assertEquals(45, card.getMinimumdecksize());
		assertEquals(15, card.getInfluencelimit());
	}
	
	@Test
	public void testFetchCorpId() {
		IdentityCard card = (IdentityCard) pool.fetchById(1067); 
		
		assertNotNull(card);
		assertEquals("Wrong decksize", 45, card.getMinimumdecksize());
		assertEquals("Wrong influenceLimit", 15, card.getInfluencelimit());
	}
	
	@Test
	public void testFetchAgendaCard() {
		AgendaCard card = (AgendaCard) pool.fetchById(1055); 
		
		assertNotNull(card);
		
		assertEquals("Wrong advancement cost", 3, card.getAdvancementCost());
		assertEquals("Wrong agenda points", 2, card.getAgendaPoints());
	}
	
	@Test
	public void testFetchAssetCard() {
		AssetCard card = (AssetCard) pool.fetchById(1056); 
		
		assertNotNull(card);

		assertEquals("Wrong cost", 4, card.getCost());
		assertEquals("Wrong trash cost", 3, card.getTrashCost());
	}

	@Test
	public void testFetchEventCard() {
		EventCard card = (EventCard) pool.fetchById(1002); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 2, card.getCost());
	}
	@Test
	public void testFetchHardwareCard() {
		HardwareCard card = (HardwareCard) pool.fetchById(1005); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 2, card.getCost());
	}
	@Test
	public void testFetchIceCard() {
		IceCard card = (IceCard) pool.fetchById(1077); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 4, card.getCost());
		assertEquals("Wrong cost", 3, card.getStrength());
	}
	@Test
	public void testFetchOperationCard() {
		OperationCard card = (OperationCard) pool.fetchById(1099); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 3, card.getCost());
	}
	@Test
	public void testFetchProgramCard() {
		ProgramCard card = (ProgramCard) pool.fetchById(1008); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 1, card.getCost());
		assertEquals("Memory unit count is wrong", 1, card.getMemoryUnits());
		assertEquals("Wrong strength", 0, card.getStrength());
	}
	@Test
	public void testFetchIcebreakerProgramCard() {
		ProgramCard card = (ProgramCard) pool.fetchById(1042); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 5, card.getCost());
		assertEquals("Memory unit count is wrong", 2, card.getMemoryUnits());
		assertEquals("Wrong strength", 3, card.getStrength());
	}
	@Test
	public void testFetchResourceCard() {
		ResourceCard card = (ResourceCard) pool.fetchById(1015); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 3, card.getCost());
	}
	@Test
	public void testFetchUpgradeCard() {
		UpgradeCard card = (UpgradeCard) pool.fetchById(1066); 
		
		assertNotNull(card);
		assertEquals("Wrong cost", 2, card.getCost());
	}

}
