package com.example.kainanna;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

	
	baby_DAO bd = new baby_DAO(this);
	Intent intent;
	List<Baby> lb = new ArrayList<Baby>();
	Baby b = new Baby();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		Log.v("DB", ""+bd.checkTableExist());
		
		
	   if(bd.checkTableExist() ==  false){
	    intent = new Intent(this, RegisterActivity.class);
	    startActivity(intent);
	   }
	   
	   else 
	   {
		intent = new Intent(this, MainMenu.class);
		startActivity(intent);
	   }
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

}
