package com.example.kainanna;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.database.SQLException;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Grocery extends Activity {

		ListView l;
		Meal_DAO m = new Meal_DAO(this);
		List<Meals> m1 = new ArrayList<Meals>();
		Button bfast, lunch, dinner, go, glo, gro;
		int yellow = Color.YELLOW;
		//DBHelper d = new DBHelper(this);
		//DAdapter db = new DAdapter(this);
		
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grocery);
		l=(ListView)findViewById(R.id.listView1);
		bfast = (Button) findViewById(R.id.Bfast);
		lunch = (Button) findViewById(R.id.Lunch);
		dinner = (Button) findViewById(R.id.Dinner);
		go = (Button) findViewById(R.id.Go);
		glo = (Button) findViewById(R.id.Glow);
		gro = (Button) findViewById(R.id.Grow);
		m1 = m.getMeals();
		ArrayAdapter<Object> listAdapter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, m1.toArray());
		l.setAdapter(listAdapter);
		
		bfast.setTextColor(yellow);
		lunch.setTextColor(yellow);
		dinner.setTextColor(yellow);
		go.setTextColor(yellow);
		glo.setTextColor(yellow);
		gro.setTextColor(yellow);
		
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long id) {
				// TODO Auto-generated method stub
				
				Log.v("test", arg0.getItemAtPosition(pos).toString());
				
			}
			
		});
		
		//pang display para sa breakfast na button
		bfast.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				m1 = m.getBfast();
				ArrayAdapter<Object> listAdapter = new ArrayAdapter<Object>(Grocery.this, android.R.layout.simple_list_item_1, m1.toArray());
				l.setAdapter(listAdapter);
				//bfast.setBackgroundColor(1);
				
			}
		});
		
		lunch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				m1 = m.getLunch();
				ArrayAdapter<Object> listAdapter = new ArrayAdapter<Object>(Grocery.this, android.R.layout.simple_list_item_1, m1.toArray());
				l.setAdapter(listAdapter);
				//lunch.setBackgroundColor(1);
			
			}
		});
		
		dinner.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				m1 = m.getDinner();
				ArrayAdapter<Object> listAdapter = new ArrayAdapter<Object>(Grocery.this, android.R.layout.simple_list_item_1, m1.toArray());
				l.setAdapter(listAdapter);
				//dinner.setBackgroundColor(1);
			}
		});
		
		
		go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				m1 = m.getGo();
				ArrayAdapter<Object> listAdapter = new ArrayAdapter<Object>(Grocery.this, android.R.layout.simple_list_item_1, m1.toArray());
				l.setAdapter(listAdapter);
				//go.setBackgroundColor(1);
			}
		});
		
		glo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				m1 = m.getGlo();
				ArrayAdapter<Object> listAdapter = new ArrayAdapter<Object>(Grocery.this, android.R.layout.simple_list_item_1, m1.toArray());
				l.setAdapter(listAdapter);
				//glo.setBackgroundColor(1);
			}
		});
		
		gro.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				m1 = m.getGro();
				ArrayAdapter<Object> listAdapter = new ArrayAdapter<Object>(Grocery.this, android.R.layout.simple_list_item_1, m1.toArray());
				l.setAdapter(listAdapter);
				//gro.setBackgroundColor(1);
			}
		});
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grocery, menu);
		return true;
	}
	
	
}
