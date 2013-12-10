package com.example.kainanna;


import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainMenu extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
        TabHost tabHost = getTabHost();        
        
        TabSpec tab1spec = tabHost.newTabSpec("Alarm");
        tab1spec.setIndicator("Alarm");
        Intent tab1Intent = new Intent(this, Alarm.class);
        tab1spec.setContent(tab1Intent);

       TabSpec tab2spec = tabHost.newTabSpec("Grocery");
       tab2spec.setIndicator("Grocery");
       Intent tab2Intent = new Intent(this, Grocery.class);
       tab2spec.setContent(tab2Intent);


       // Adding all TabSpec to TabHost
       tabHost.addTab(tab1spec); 
       tabHost.addTab(tab2spec); 
 
      //Adjusting the tab height as per need.
      tabHost.getTabWidget().getChildAt(0).getLayoutParams().height=40;
      tabHost.getTabWidget().getChildAt(1).getLayoutParams().height=40;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
