package net.sandfur.anr.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.util.CardFactory;
import net.sandfur.anr.card.util.CardPoolParser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class NetrunnerDbParser implements CardPoolParser {
	JsonArray jsonCards = null;
	Iterator<JsonElement> current = null;
	
	public void initFromWeb() throws IOException {
		// TODO: fetch from web 
		initFromFile("testdata/cards.json");
	}
	
	public void initFromFile(String file) throws FileNotFoundException {
		initFrom(new FileReader(file));
	}
	
	void initFrom(Reader reader) {
		try {
			JsonParser parser = new JsonParser();
			JsonElement root = parser.parse(reader);
			if(root.isJsonArray()) {
				jsonCards = root.getAsJsonArray();
				current = jsonCards.iterator();
			}
			else {
				throw new IllegalArgumentException("JSON not in NetrunnerDB format.");
			}
		}
		catch(JsonSyntaxException e) {
			throw new IllegalArgumentException("Malformed JSON stream.");
		}
	}
	
	@Override
	public boolean hasNext() {
		return current != null && current.hasNext();
	}

	@Override
	public Card getNext() throws IllegalStateException {
		
		if(jsonCards == null || hasNext() == false) {
			throw new IllegalStateException();
		}
		JsonElement jsonCard = current.next();
		if(jsonCard.isJsonObject()) {
			return CardFactory.create(jsonCard.getAsJsonObject());
		}
		throw new IllegalArgumentException("JSON not in NetrunnerDB format");
	}

}
