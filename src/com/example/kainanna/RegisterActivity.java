package com.example.kainanna;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
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
	TextView title, genders, gday;
	Button Male, Female, submit;
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
		
		title = (TextView) findViewById(R.id.BfastText);
		genders = (TextView) findViewById(R.id.textView4);
		gday = (TextView) findViewById(R.id.textView7);
		title.setTextColor(Color.YELLOW);
		genders.setTextColor(Color.YELLOW);
		gday.setTextColor(Color.YELLOW);
		
		nameText = (EditText) findViewById(R.id.foodname);
		ageText = (EditText) findViewById(R.id.editText2);
		
		Male = (Button) findViewById(R.id.MaleGen);
		Male.setCompoundDrawablesWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.male));
		Female = (Button) findViewById(R.id.FemaleGen);
		Female.setCompoundDrawablesWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.female));
		submit = (Button) findViewById(R.id.Bfast);
		submit.setText("Tell Me!");
		submit.setTextColor(Color.YELLOW);
		
		nameText.setTextColor(Color.YELLOW);
		ageText.setTextColor(Color.YELLOW);
		
		Male.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Male.setCompoundDrawablesWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.ismale));
				Female.setCompoundDrawablesWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.female));
				gender = "B";
				Log.v("Gender", gender);
	
				
			}
		});
		
		Female.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Female.setCompoundDrawablesWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.isfemale));
				Male.setCompoundDrawablesWithIntrinsicBounds(null, null, null, getResources().getDrawable(R.drawable.male));
				gender = "G";
				Log.v("Gender", gender);

				
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
		
		if(Integer.parseInt(ageText.getText().toString()) > 7){
			 alert.setTitle("Warning");
			 alert.setMessage("Please select an acceptable age for a baby or toddler it can be from age 0 up to 7");
			 alert.show();
			 return false;
		}
		else
		return true;
	}

}
