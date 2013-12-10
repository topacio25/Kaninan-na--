package com.example.kainanna;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	private String day[];
	private baby_DAO bd = new baby_DAO(this);
	private Baby b = new Baby();
	private String gender = "";
	
	EditText nameText, ageText;
	Button Male, Female;
	Spinner s;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		day = new String[7];
		day[0] = "Monday";
		day[1] = "Tuesday";
		day[2] = "Wednesday";
		day[3] = "Thursday";
		day[4] = "Friday";
		day[5] = "Saturday";
		day[6] = "Sunday";
		
		s = (Spinner) findViewById(R.id.spinner1);
		
		nameText = (EditText) findViewById(R.id.foodname);
		ageText = (EditText) findViewById(R.id.editText2);
		
		Male = (Button) findViewById(R.id.MaleGen);
		Female = (Button) findViewById(R.id.FemaleGen);
		
		Male.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				gender = Male.getText().toString();
				Log.v("Gender", gender);
				Female.setVisibility(0);
				
			}
		});
		
		Female.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				gender = Female.getText().toString();
				Log.v("Gender", gender);
				Male.setVisibility(0);
				
			}
		});

		ArrayAdapter adapter = new ArrayAdapter(this,
        android.R.layout.simple_spinner_item, day);
        s.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}
	
	public void sendMessage(View view) {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		String name = "";
		Intent intent = new Intent(this, MainMenu.class);
		if(checker()){
		b.setName(nameText.getText().toString());
		b.setAge(Integer.parseInt(ageText.getText().toString()));
		b.setGender(gender);
		b.setGday(s.getSelectedItem().toString());
		bd.createTable();
		bd.addBaby(b);
		name = bd.getName();
		alert.setTitle("Hello");
		alert.setMessage("Nice to meet baby "+name+"!");
		alert.show();
		startActivity(intent);
		}
	   
	}
	
	public boolean checker(){
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		
		if(nameText.getText().toString().isEmpty()){
			 alert.setTitle("Warning");
			 alert.setMessage("Please Enter your Baby's name.");
			 alert.show();
			 return false;
		}
		
		if(ageText.getText().toString().isEmpty()){
			 alert.setTitle("Warning");
			 alert.setMessage("Please Enter your Baby's age.");
			 alert.show();
			 return false;
		}
		if(gender.isEmpty()){
			 alert.setTitle("Warning");
			 alert.setMessage("Please Choose your Baby's gender.");
			 alert.show();
			 return false;
		}
		else
		return true;
	}

}
