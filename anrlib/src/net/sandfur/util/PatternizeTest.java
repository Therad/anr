package net.sandfur.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PatternizeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPattern() {
		Patternize pattern = new Patternize()
			.add(".*");
		
		assertEquals(".*", pattern.toString());
	}
	
	@Test
	public void testAddGroup() {
		Patternize pattern = new Patternize()
			.addGroup(".*match.*");
		
		assertEquals("(.*match.*)", pattern.toString());
	}

	@Test
	public void testAddNamedGroup() {
		Patternize pattern = new Patternize()
			.addNamedGroup(".*match.*", "id");
		
		assertEquals("(?<id>.*match.*)", pattern.toString());
	}
}
