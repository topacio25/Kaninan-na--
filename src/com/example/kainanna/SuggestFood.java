package com.example.kainanna;

import java.util.List;
import java.util.Random;

import android.util.Log;

public class SuggestFood {
	String food = null;
	Random r = new Random();
	int ran = 0;
	
	public String suggestFood(List<Meals> meals){
		
		ran = r.nextInt(meals.toArray().length);
		food = meals.toArray()[ran].toString();
		Log.v("FOOD", food);
		
		return food;
	}
	

	
	
	

}
