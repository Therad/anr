package net.sandfur.anr.card.util;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;

import net.sandfur.anr.card.AgendaCard;
import net.sandfur.anr.card.AssetCard;
import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.EventCard;
import net.sandfur.anr.card.HardwareCard;
import net.sandfur.anr.card.IceCard;
import net.sandfur.anr.card.IdentityCard;
import net.sandfur.anr.card.OperationCard;
import net.sandfur.anr.card.ProgramCard;
import net.sandfur.anr.card.ResourceCard;
import net.sandfur.anr.card.UpgradeCard;

import org.junit.Test;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class CardFactoryTest {

	@Test
	public void fetchingRunnerIdCard() {
		Card card = fetchCard("testdata/runner_id.json");
		assertTrue(card instanceof IdentityCard);
	}

	@Test
	public void fetchingCorpIdCard() {
		Card card = fetchCard("testdata/corp_id.json");
		assertTrue(card instanceof IdentityCard);
	}

	@Test
	public void fetchingOperationCard() {
		Card card = fetchCard("testdata/operation.json");
		assertTrue(card instanceof OperationCard);
	}

	@Test
	public void fetchingIceCard() {
		Card card = fetchCard("testdata/ice.json");
		assertTrue(card instanceof IceCard);
	}

	@Test
	public void fetchingAssetCard() {
		Card card = fetchCard("testdata/asset.json");
		assertTrue(card instanceof AssetCard);
	}

	@Test
	public void fetchingAgendaCard() {
		Card card = fetchCard("testdata/agenda.json");
		assertTrue(card instanceof AgendaCard);
	}

	@Test
	public void fetchingUpgradeCard() {
		Card card = fetchCard("testdata/upgrade.json");
		assertTrue(card instanceof UpgradeCard);
	}

	@Test
	public void fetchingEventCard() {
		Card card = fetchCard("testdata/event.json");
		assertTrue(card instanceof EventCard);
	}

	@Test
	public void fetchingProgramCard() {
		Card card = fetchCard("testdata/program.json");
		assertTrue(card instanceof ProgramCard);
	}

	@Test
	public void fetchingResourceCard() {
		Card card = fetchCard("testdata/resource.json");
		assertTrue(card instanceof ResourceCard);
	}

	@Test
	public void fetchingHardwareCard() {
		Card card = fetchCard("testdata/hardware.json");
		assertTrue(card instanceof HardwareCard);
	}

	private Card fetchCard(String file) {
		JsonObject jsonCard = data(file);
		
		Card card = CardFactory.create(jsonCard);
		return card;
	}

	private JsonObject data(String file) {
		JsonParser parser = new JsonParser();
		try {
			return parser.parse(new FileReader(file)).getAsJsonArray().get(0).getAsJsonObject();
		} 
		catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
