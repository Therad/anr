package net.sandfur.anr.card;

import net.sandfur.anr.enums.Faction;

public interface Card {
	public abstract int getId();
	public abstract int getCardNumber();
	public abstract String getNetrunnerDbLargeImageSource();
	public abstract String getNetrunnerDbImageSource();
	public abstract String getNetrunnerDbUrl();
	public abstract int getCyclenumber();
	public abstract boolean isUniqueness();
	public abstract int getQuantity();
	public abstract int getNumber();
	public abstract String getIllustrator();
	public abstract String getFlavor();
	public abstract String getSubtype_code();
	public abstract Type getType();
	public abstract Faction getFaction();
	public abstract String getText();
	public abstract String getTitle();
	public abstract String getCode();
	public abstract boolean isNull();

	public static enum Type {
		unknown,
		identity,
		operation,
		ice,
		asset,
		agenda,
		upgrade,
		event,
		program,
		resource,
		hardware;

		public static Type fromString(String cardTypeName) {
			Type type = Type.unknown;
			try {
				type = Type.valueOf(cardTypeName);
			}
			catch(Exception e) {
				
			}
			
			return type;
		}
	}

	public abstract boolean isRunner();
	public abstract int getInfluence();
}