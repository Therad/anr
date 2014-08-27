package net.sandfur.anr.parser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

import net.sandfur.anr.card.Card;

import org.junit.Before;
import org.junit.Test;

public class NetrunnerDbParserTest {
	NetrunnerDbParser parser;
	
	@Before
	public void setup() {
		parser = new NetrunnerDbParser();
	}
	
	@Test(expected=IllegalStateException.class)
	public void unInitilized() {
		assertFalse("Parser should not have any cards", parser.hasNext());
		parser.getNext();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void validJsonButWrong() {
		parser.initFrom(new StringReader("{}"));
	}
	
	@Test(expected=IllegalStateException.class)
	public void emptyJsonRootArray() {
		parser.initFrom(new StringReader("[]"));
		
		assertFalse("Parser should not have any cards", parser.hasNext());
		parser.getNext();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void illegalJsonCard() {
		parser.initFrom(new StringReader("[{}]"));
		
		assertTrue("Json stream should have valid cards.", parser.hasNext());
		parser.getNext();
	}
	
	@Test
	public void legalJson() throws FileNotFoundException {
		parser.initFrom(new FileReader("testdata/core_set.json"));
		
		assertTrue("Parser should have cards...", parser.hasNext());
		Card card = parser.getNext();
		assertNotNull("Should be a legal Card", card);
		assertFalse("Card not initialized: " + card.getType().toString(), card.isNull());
	}
}
