package net.sandfur.anr.enums;

import com.google.gson.annotations.SerializedName;

public enum Faction {
	unknown,
	neutral,
	@SerializedName("haas-bioroid") 
	haasBioroid,
	jinteki,
	@SerializedName("weyland-consortium") 
	weyland,
	nbn,
	anarch,
	shaper,
	criminal;
}
