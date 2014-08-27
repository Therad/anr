package net.sandfur.anr.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.util.CardPool;
import net.sandfur.anrlib.deck.DeckParseException;
import net.sandfur.anrlib.deck.DeckParser;

public class OctgnDeckParser implements DeckParser {
	CardPool cardPool;
	
	@Override
	public void setPool(CardPool pool) {
		cardPool = pool;
	}

	@Override
	public List<Card> parse(Reader reader) throws IOException, DeckParseException {
		LinkedList<Card> list = new LinkedList<>();
	    Document doc = getDocument(reader);
	    
	    NodeList nodes = parseXPath(doc, "//card[@id]");

		for(int i=0; i < nodes.getLength(); i++) {
			Card card = convertNodeToCard(nodes.item(i));
			if(card != null) {
				int count = Integer.parseInt(getAttributeValue(nodes.item(i), "qty"));
				for(int j = 0; j < count; j++) {
					list.add(card);
				}
			}
		}
    
		
		return list;
	}

	private Card convertNodeToCard(Node item) {
		String id = getAttributeValue(item, "id");
		id = id.replace("bc0f047c-01b1-427f-a439-d451eda", ""); 
		
		return cardPool.fetchById(Integer.parseInt(id));
	}

	private String getAttributeValue(Node item, String name) {
		String value = "";
		if(item.hasAttributes()) {
			NamedNodeMap attr = item.getAttributes();
			value = attr.getNamedItem(name).getNodeValue().toString();		
		}
		return value;
		
	}

	private NodeList parseXPath(Document doc, String xpathString) throws DeckParseException {
	    // create an XPathFactory
	    XPathFactory xFactory = XPathFactory.newInstance();
	    XPath xpath = xFactory.newXPath();

	    NodeList nodes = null;
	    try {
	    	XPathExpression expr = xpath.compile(xpathString);
			nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			throw new DeckParseException(e);
		}

	    return nodes;
	}

	private Document getDocument(Reader reader) throws IOException, DeckParseException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setNamespaceAware(true);
	    DocumentBuilder builder;
	    Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
		    doc = builder.parse(new InputSource(reader));
		} catch (ParserConfigurationException | SAXException e) {
			throw new DeckParseException(e);
		}
	    return doc;
	}

}
