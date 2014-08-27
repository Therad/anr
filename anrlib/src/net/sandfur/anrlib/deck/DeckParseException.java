package net.sandfur.anrlib.deck;

public class DeckParseException extends Exception {

	public DeckParseException(String message) {
		super(message);
	}
	public DeckParseException(Exception e) {
		super(e);
	}
	public DeckParseException(String message, Throwable e) {
		super(message, e);
	}

}
