package net.sandfur.anr.card.util;

import net.sandfur.anr.card.Card;
import net.sandfur.anr.card.Card.Type;
import net.sandfur.anr.parser.implementation.AgendaCardImpl;
import net.sandfur.anr.parser.implementation.AssetCardImpl;
import net.sandfur.anr.parser.implementation.EventCardImpl;
import net.sandfur.anr.parser.implementation.HardwareCardImpl;
import net.sandfur.anr.parser.implementation.IceCardImpl;
import net.sandfur.anr.parser.implementation.IdentityImpl;
import net.sandfur.anr.parser.implementation.OperationCardImpl;
import net.sandfur.anr.parser.implementation.ProgramCardImpl;
import net.sandfur.anr.parser.implementation.ResourceCardImpl;
import net.sandfur.anr.parser.implementation.UpgradeCardImpl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CardFactory {
	
	enum CardMember {
		type_code,
		side_code
	}

	public static Card create(JsonObject jsonCard) {
		Type type = getType(jsonCard);
		if(type != null) {
			switch(type) {
			case identity:
				return createCardFromJson(jsonCard, IdentityImpl.class);
			case operation:
				return createCardFromJson(jsonCard, OperationCardImpl.class);
			case ice:
				return createCardFromJson(jsonCard, IceCardImpl.class);
			case asset:
				return createCardFromJson(jsonCard, AssetCardImpl.class);
			case agenda:
				return createCardFromJson(jsonCard, AgendaCardImpl.class);
			case upgrade:
				return createCardFromJson(jsonCard, UpgradeCardImpl.class);
			case event:
				return createCardFromJson(jsonCard, EventCardImpl.class);
			case program:
				return createCardFromJson(jsonCard, ProgramCardImpl.class);
			case resource:
				return createCardFromJson(jsonCard, ResourceCardImpl.class);
			case hardware:
				return createCardFromJson(jsonCard, HardwareCardImpl.class);
			default:

			}
		}
		throw new IllegalArgumentException("JSON not in NetrunnerDB format");
	}

	private static Card createCardFromJson(JsonObject jsonCard, Class<? extends Card> class1) {
		return new Gson().fromJson(jsonCard, class1);
	}
 
	private static Type getType(JsonObject jsonCard) {
		String name = CardMember.type_code.name();
		if(jsonCard.has(name)) {
			return Type.fromString(jsonCard.get(name).getAsString());
		}
		throw new IllegalArgumentException("JSON not in NetrunnerDB format");
	}
	private static String getJsonMember(JsonObject object, CardMember member) {
		String name = member.name();
		if(object.has(name)) {
			return object.get(name).getAsString();
		}
		return "";
	}
}
