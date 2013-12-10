package com.example.kainanna;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class baby_DAO extends SQLiteOpenHelper{
	
	final static String DATABASE_NAME = "baby.db";
	final static int DATABASE_VERSION = 1;
	
	public static final String TABLE_NAME ="babies";
	public static final String COLUMN_ID ="_id";
	public static final String COLUMN_NAME ="name";
	public static final String COLUMN_AGE ="age";
	public static final String COLUMN_GENDER ="gender";
	public static final String COLUMN_GROCERY ="grocery_day";
	
	public static final String synthax ="CREATE TABLE " 
			+ TABLE_NAME + "(" + COLUMN_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME 
			+ " TEXT NOT NULL, " + COLUMN_AGE + " INTEGER, " + COLUMN_GENDER
			+ " TEXT NOT NULL, " + COLUMN_GROCERY + " TEXT NOT NULL );";
	
	
	public baby_DAO(Context c){
		
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
	
	public long addBaby(Baby b){
		
		SQLiteDatabase db =  this.getWritableDatabase();
		
		ContentValues cv = new ContentValues();
		cv.put(COLUMN_NAME, b.name);
		cv.put(COLUMN_AGE, b.age);
		cv.put(COLUMN_GENDER, b.gender);
		cv.put(COLUMN_GROCERY, b.gday);
		
		long success = db.insert(TABLE_NAME, null, cv);
		
		db.close();
		
		return success;
		
	}
	
	public List<Baby> getBaby()
	{
		List<Baby> sl = new ArrayList<Baby>();
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			sl.add(cursorToStudent(c));
			c.moveToNext();
		}
		
		
		db.close();
		
		return sl;
		
	}
	
	public String getName(){
		String name = "";
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.rawQuery("SELECT " +COLUMN_NAME+ " FROM "+ TABLE_NAME, null);
		
		c.moveToFirst();
		while(!c.isAfterLast()){
			name = c.getString(0);
			c.moveToNext();
		}
		
		
		db.close();
		return name;
	}
	
	public void deleteBaby(){
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
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

	private Baby cursorToStudent(Cursor c) {
		// TODO Auto-generated method stub
		Baby s = new Baby();
		
		s.setName(c.getString(1));
		s.setAge(c.getInt(2));
		s.setGender(c.getString(3));
		s.setGday(c.getString(4));
		
		return s;
	}
	
	public void createTable(){
		SQLiteDatabase db =  this.getWritableDatabase();
		db.execSQL(synthax);
	}
	
	

}
