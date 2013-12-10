package com.example.kainanna;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Meal_DAO extends SQLiteOpenHelper{
	
	final static String DATABASE_NAME = "temp.db";
	final static int DATABASE_VERSION = 1;
	public static final String TABLE_NAME ="meal";
	public static final String COLUMN_ID ="_id";
	public static final String COLUMN_Food ="FoodName";
	public static final String COLUMN_isB ="isB";
	public static final String COLUMN_isL ="isL";
 	public static final String COLUMN_isD ="isD";
	public static final String COLUMN_isGO ="isGO";
	public static final String COLUMN_isGR ="isGR";
	public static final String COLUMN_isGL ="isGL";
	public static final String COLUMN_AGE ="is2Age";
	public static final String synthax ="CREATE TABLE " 
			+ TABLE_NAME + "(" + COLUMN_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_Food 
			+ " TEXT NOT NULL, " + COLUMN_isB + " TEXT NOT NULL, " + COLUMN_isL
			+ " TEXT NOT NULL, " + COLUMN_isD + " TEXT NOT NULL, " +  COLUMN_isGO + " TEXT NOT NULL, " +
			COLUMN_isGR + " TEXT NOT NULL, " + COLUMN_isGL + " TEXT NOT NULL, " + COLUMN_AGE + " INTEGER );";
	
	
	public Meal_DAO(Context c){
		
		super(c, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
	db.execSQL(synthax);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
		
	}
	
	public long addBaby(){
		
		SQLiteDatabase db =  this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		long success;
		
		cv.put(COLUMN_Food, "Adobo" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1 );
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 0);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Afritada");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Asado");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Fried Pork");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Batchoy" );
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 1);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Bicol Express");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);

		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Binakol");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Binagoongang Baboy" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Bistek Tagalog" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Bopis");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Bringhe");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,  "Bulanglang");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,"Callos" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Camaron Rebosado");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Champorado");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 0);
		cv.put(COLUMN_isD, 0);
		cv.put(COLUMN_isGO, 1);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 0);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Chicken Pastel");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Crispy Pata");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Crispy Tadyang ng Baboy");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Daing na Bangus");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Dinuguan");
		cv.put(COLUMN_isB, 0 );
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD,1 );
		cv.put(COLUMN_isGO,0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Embutido");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 1);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 0);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,"Eschabecheng isda" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Ginataang Manok");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Giniling");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Ginisang Moggo");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 1);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 0);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Hamonado");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 0);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Halabos na Hipon" );
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 0);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,"Humba" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Inasal na Manok" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Kaldereta");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Kansi");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Kare-Kare");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,"Kilawin" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Kininlat");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,"Laing" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Lechon");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO,0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Lechon Kawali");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Lechon Manok");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Lengua Estofada" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Longganisa");
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR, 1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,"Lugaw" );
		cv.put(COLUMN_isB, 1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 0);
		cv.put(COLUMN_AGE, 1);
       success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Lumpiang Shanghai");
		cv.put(COLUMN_isB,1);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO,0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Paksiw na Isda");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Lumpiang Ubod");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 1);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Mechado");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO, 1);
		cv.put(COLUMN_isGR,0);
		cv.put(COLUMN_isGL,1 );
		cv.put(COLUMN_AGE, 1);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food,"Menudo" );
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO,0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
	 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Morcon");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO,0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 0);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Nilagang Baka");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO,1);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		cv.put(COLUMN_AGE, 1);
		 success = db.insert(TABLE_NAME, null, cv);
		
		cv.put(COLUMN_Food, "Paksiw na Baka");
		cv.put(COLUMN_isB, 0);
		cv.put(COLUMN_isL, 1);
		cv.put(COLUMN_isD, 1);
		cv.put(COLUMN_isGO,0);
		cv.put(COLUMN_isGR,1);
		cv.put(COLUMN_isGL, 1);
		
		
		
		 success = db.insert(TABLE_NAME, null, cv);
		
		
		db.close();
		
		return success;
		
	}
	
	public int getDATA(){
SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
		int i=1;
		c.moveToFirst();
		while(!c.isAfterLast()){
		Log.v("name", c.getString(1));
		
			c.moveToNext();
			i++;
		}
		
		
		db.close();
		return i;
	}
	public int Count(){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.rawQuery("SELECT" + COLUMN_ID + " FROM " + TABLE_NAME, null);
		c.moveToLast();
		int x = c.getCount();
		Log.v("count", x+".");
		//c.getCount();
		return x;
	}
	public String getName(){
		String name = "";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.rawQuery("SELECT " +COLUMN_Food+ " FROM "+ TABLE_NAME, null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			name = c.getString(0);
			c.moveToNext();
		}
		
		
		db.close();
		return name;
	}
	public List<Meals> getMeals()
	{
		List<Meals> sl = new ArrayList<Meals>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToMeal(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	
	//get breakfast meals
	public List<Meals> getBfast(){
		List<Meals> sl = new ArrayList<Meals>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_isB +"= 1" , null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToMeal(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	//get lunch meals
	public List<Meals> getLunch(){
		List<Meals> sl = new ArrayList<Meals>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_isL +"= 1" , null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToMeal(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	//get dinner meals
	public List<Meals> getDinner(){
		List<Meals> sl = new ArrayList<Meals>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_isD +"= 1" , null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToMeal(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	//get go meals
	public List<Meals> getGo(){
		List<Meals> sl = new ArrayList<Meals>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_isGO +"= 1" , null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToMeal(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	//get grow meals
	public List<Meals> getGro(){
		List<Meals> sl = new ArrayList<Meals>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_isGR +"= 1" , null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToMeal(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	//get glow meals
	public List<Meals> getGlo(){
		List<Meals> sl = new ArrayList<Meals>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME +" WHERE "+ COLUMN_isGL +"= 1" , null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToMeal(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	
	
	
	public boolean checkTableExist(){
		
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor c = null;
		boolean tableExists = false;
		/* get cursor on it */
		try
		{
		    c = db.query(TABLE_NAME, null,
		        null, null, null, null, null);
		        tableExists = true;
		}
		catch (Exception e) {
		    /* fail */
		}

		return tableExists;
	}

	private Meals cursorToMeal(Cursor c) {
		// TODO Auto-generated method stub
		Meals m= new Meals();
		
		
		m.setFoodName(c.getString(1));
		m.setIsB(c.getInt(2));
		m.setIsL(c.getInt(3));
		m.setIsD(c.getInt(4));
		m.setIsGO(c.getInt(5));
		m.setIsGR(c.getInt(6));
		m.setIsGL(c.getInt(7));
		m.setIs2age(c.getInt(8));
		
		return m;
	}
	
	public void createTable(){
		SQLiteDatabase db =  this.getWritableDatabase();
		db.execSQL(synthax);
	}
	
	

}
