package com.example.kainanna;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DAtaInput extends Activity {
	
	EditText foodname, isB, isL, isD, isGO, isGR, isGL, is2Age;
	Button submit;
	TextView DataNum;
	Meals m = new Meals();
	Meal_DAO md = new Meal_DAO(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data_input);
		foodname = (EditText) findViewById(R.id.foodname);
		isB = (EditText) findViewById(R.id.isB);
		isL = (EditText) findViewById(R.id.isL);
		isD = (EditText) findViewById(R.id.isD);
		isGO = (EditText) findViewById(R.id.isGo);
		isGR = (EditText) findViewById(R.id.isGR);
		isGL = (EditText) findViewById(R.id.isGL);
		is2Age = (EditText) findViewById(R.id.is2Age);
		submit = (Button) findViewById(R.id.Bfast);
		DataNum = (TextView) findViewById(R.id.dataNum); 
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				m.setFoodName(foodname.getText().toString());
				m.setIsB(Integer.parseInt(isB.getText().toString()));
				m.setIsL(Integer.parseInt(isL.getText().toString()));
				m.setIsD(Integer.parseInt(isD.getText().toString()));
				m.setIsGO(Integer.parseInt(isGO.getText().toString()));
				m.setIsGR(Integer.parseInt(isGR.getText().toString()));
				m.setIsGL(Integer.parseInt(isGL.getText().toString()));
				m.setIs2age(Integer.parseInt(is2Age.getText().toString()));
				md.addBaby();
				md.getDATA();
				foodname.setText(null);
				isB.setText(null);
				isL.setText(null);
				isD.setText(null);
				isGO.setText(null);
				isGR.setText(null);
				isGL.setText(null);
				is2Age.setText(null);
				
				DataNum.setText(md.Count()+".");
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data_input, menu);
		return true;
	}

}
