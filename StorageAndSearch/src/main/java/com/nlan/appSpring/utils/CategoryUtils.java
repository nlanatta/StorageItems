package com.nlan.appSpring.utils;

import java.util.ArrayList;
import java.util.List;

public class CategoryUtils {

	public static final String ELECTRONIC = "ELECTRONIC";	
	public static final String CARS = "CARS";		
	public static final String ACCESORIES = "ACCESORIES";	
	public static final String ART = "ART";		
	public static final String CHILDS = "CHILDS";	
	public static final String SPORTS = "SPORTS";	
	public static final String MUSIC = "MUSIC";	
	public static final String BEAUTY = "BEAUTY";	
	public static final String CLOTHES = "CLOTHES";
	
	public static final List<String> getAll()
	{
		List<String> cats = new ArrayList<String>();
		cats.add(ELECTRONIC);
		cats.add(CARS);
		cats.add(ACCESORIES);
		cats.add(ART);
		cats.add(CHILDS);
		cats.add(SPORTS);
		cats.add(MUSIC);
		cats.add(BEAUTY);
		cats.add(CLOTHES);		
		return cats;
	}
}
