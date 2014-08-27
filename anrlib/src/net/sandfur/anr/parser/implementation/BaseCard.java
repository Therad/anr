package net.sandfur.anr.parser.implementation;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.enums.Faction;
import net.sandfur.anr.enums.Side;

import com.google.gson.annotations.SerializedName;


class BaseCard implements Card {
//	@SerializedName("last-modified")
//	Date lastModified;
	String code; 
	String title; 
	String text; 
	@SerializedName("faction_code")
	Faction faction;
	@SerializedName("type_code")
	Type type; 
	String subtype_code;
	String flavor; 
	String illustrator; 
	int number; 
	int quantity; 

	@SerializedName("side_code")
	Side side; 
	boolean uniqueness; 
	int cyclenumber; 

	@SerializedName("factioncost")
	int influence;
	
	@SerializedName("url")
	String netrunnerDbUrl;  
	@SerializedName("imagesrc")
	String netrunnerDbImageSource;  
	@SerializedName("largeimagesrc")
	String netrunnerDbLargeImageSource;  
	int cardNumber;

	
	
	@Override
	public boolean isNull() {
		return getType() == Type.unknown;
	} 
	@Override
	public String getCode() {
		return code;
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public String getText() {
		return text;
	}
	@Override
	public Faction getFaction() {
		return faction;
	}
	@Override
	public Type getType() {
		return type;
	}
	@Override
	public String getSubtype_code() {
		return subtype_code;
	}
	@Override
	public String getFlavor() {
		return flavor;
	}
	@Override
	public String getIllustrator() {
		return illustrator;
	}
	@Override
	public int getNumber() {
		return number;
	}
	@Override
	public int getQuantity() {
		return quantity;
	}
	@Override
	public boolean isUniqueness() {
		return uniqueness;
	}
	@Override
	public int getCyclenumber() {
		return cyclenumber;
	}
	@Override
	public String getNetrunnerDbUrl() {
		return netrunnerDbUrl;
	}
	@Override
	public String getNetrunnerDbImageSource() {
		return netrunnerDbImageSource;
	}
	@Override
	public String getNetrunnerDbLargeImageSource() {
		return netrunnerDbLargeImageSource;
	}

	@Override
	public int getCardNumber() {
		return cardNumber;
	}

	@Override
	public boolean isRunner() {
		return side == Side.runner;
	}
	
	@Override
	public int getId() {
		return getCyclenumber()*1000 + getNumber();
	}
	@Override
	public int getInfluence() {
		return influence;
	}
}
