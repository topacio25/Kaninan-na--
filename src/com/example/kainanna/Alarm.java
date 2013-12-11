package com.example.kainanna;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.media.SoundPool;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Alarm extends Activity {
	Button SetBfast, SetLunch, SetSnack, SetDinner, DBaby, SBfast, SLunch, SSnack, SDinner;
	TextView bfast, lunch, snack, dinner;
	baby_DAO bd = new baby_DAO(this);
	Meal_DAO md = new Meal_DAO(this);
	SuggestFood sf = new SuggestFood();
	SoundPlayer sp = new SoundPlayer();
	Switch sBfast, sLunch, sSnack, sDinner;
	Calendar cBfast, cLunch, cSnack, cDinner;
	Boolean isBfast = false, isLunch = false, isSnack = false, isDinner = false;
	TimePickerDialog tpd;
	DatePickerDialog dpd;
	int yellow = Color.YELLOW;
	
	final static int RQS_1 = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
	
	 SetBfast = (Button) findViewById(R.id.BfastTime);
     SetLunch = (Button) findViewById(R.id.LunchTime);
     SetSnack = (Button) findViewById(R.id.SnackTime);
     SetDinner = (Button) findViewById(R.id.DinnerTime);
     
     SetBfast.setTextColor(yellow);
     SetLunch.setTextColor(yellow);
     SetSnack.setTextColor(yellow);
     SetDinner.setTextColor(yellow);
     
     DBaby = (Button) findViewById(R.id.Bfast);
     DBaby.setTextColor(yellow);
     
     SBfast = (Button) findViewById(R.id.Sbfast);
     SLunch = (Button) findViewById(R.id.SLunch);
     SSnack = (Button) findViewById(R.id.SSnack);
     SDinner = (Button) findViewById(R.id.SDinner);
     
     sBfast = (Switch) findViewById(R.id.switch1);
     sLunch = (Switch) findViewById(R.id.switch2);
     sSnack = (Switch) findViewById(R.id.switch4);
     sDinner = (Switch) findViewById(R.id.switch3);
     
     sBfast.setTextColor(yellow);
     sLunch.setTextColor(yellow);
     sSnack.setTextColor(yellow);
     sDinner.setTextColor(yellow);
     
     bfast = (TextView) findViewById(R.id.BfastText);
     lunch = (TextView) findViewById(R.id.LunchText);
     snack = (TextView) findViewById(R.id.SnackText);
     dinner = (TextView) findViewById(R.id.DinnerText);
     
     bfast.setTextColor(yellow);
     lunch.setTextColor(yellow);
     snack.setTextColor(yellow);
     dinner.setTextColor(yellow);
     
     sBfast.setEnabled(false);
     sLunch.setEnabled(false);
     sSnack.setEnabled(false);
     sDinner.setEnabled(false);
     
     SBfast.setTextColor(yellow);
     SLunch.setTextColor(yellow);
     SSnack.setTextColor(yellow);
     SDinner.setTextColor(yellow);
    
     SBfast.setText(sf.suggestFood(md.getBfast()));
     SLunch.setText(sf.suggestFood(md.getLunch()));
     SSnack.setText("Sweet Potato");
     SDinner.setText(sf.suggestFood(md.getDinner()));
     
     
     DBaby.setText("Erase records of Baby "+bd.getName()+"?");
     DBaby.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			confirmUser();
			
		}
	});
     

     SetBfast.setOnClickListener(new OnClickListener() {

         public void onClick(View v) {
             openTimePickerDialog(false);

         }
     });
     
     SetLunch.setOnClickListener(new OnClickListener() {

         public void onClick(View v) {
             openTimePickerDialog1(false);

         }
     });
     
     SetSnack.setOnClickListener(new OnClickListener() {

         public void onClick(View v) {
             openTimePickerDialog2(false);

         }
     });
     
     SetDinner.setOnClickListener(new OnClickListener() {

         public void onClick(View v) {
             openTimePickerDialog3(false);

         }
     });
     
     		sBfast.setChecked(false);
     		sLunch.setChecked(false);
     		sSnack.setChecked(false);
     		sDinner.setChecked(false);
     		sBfast.setOnCheckedChangeListener(new OnCheckedChangeListener() {

     			@Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

     				if (isChecked){ 
     				isBfast = true;
     				setAlarmBfast(cBfast);
     				}

     				else 
     				isBfast = false;
     			}
     		});
     		
     		sLunch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

     			@Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

     				if (isChecked){ 
         				isLunch = true;
         				setAlarmLunch(cLunch);
         				
         				}

     				else 
     				isLunch = false;
     			}
     		});
     		
     		sSnack.setOnCheckedChangeListener(new OnCheckedChangeListener() {

     			@Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

     				if (isChecked){ 
         				isSnack = true;
         				setAlarmSnack(cSnack);
         				}

     				else 
     				isSnack = false;
     			}
     		});
     		
     		sDinner.setOnCheckedChangeListener(new OnCheckedChangeListener() {

     			@Override
         public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

     				if (isChecked){ 
         				isDinner = true;
         				setAlarmDinner(cDinner);
         				}

     				else 
     				isDinner = false;
     			}
     		});
	}
	
	private void openTimePickerDialog(boolean is24r) {
     Calendar calendar = Calendar.getInstance();

     tpd = new TimePickerDialog(Alarm.this,
             onTimeSetListener, calendar.get(Calendar.HOUR_OF_DAY),
             calendar.get(Calendar.MINUTE), is24r);
     tpd.setTitle("Set Alarm Time");

     tpd.show();

 }
	
	private void openTimePickerDialog1(boolean is24r) {
     Calendar calendar = Calendar.getInstance();

     tpd = new TimePickerDialog(Alarm.this,
             onTimeSetListener1, calendar.get(Calendar.HOUR_OF_DAY),
             calendar.get(Calendar.MINUTE), is24r);
     tpd.setTitle("Set Alarm Time");

     tpd.show();

 }
	
	private void openTimePickerDialog2(boolean is24r) {
     Calendar calendar = Calendar.getInstance();

     tpd = new TimePickerDialog(Alarm.this,
             onTimeSetListener2, calendar.get(Calendar.HOUR_OF_DAY),
             calendar.get(Calendar.MINUTE), is24r);
     tpd.setTitle("Set Alarm Time");

     tpd.show();

 }
	
	private void openTimePickerDialog3(boolean is24r) {
     Calendar calendar = Calendar.getInstance();

     tpd = new TimePickerDialog(Alarm.this,
             onTimeSetListener3, calendar.get(Calendar.HOUR_OF_DAY),
             calendar.get(Calendar.MINUTE), is24r);
     tpd.setTitle("Set Alarm Time");

     tpd.show();

 }
	
	private String hourFormat(Calendar calSet){
		
		int hour = calSet.get(Calendar.HOUR_OF_DAY);
		int min = calSet.get(Calendar.MINUTE);
		String time;
		String day = "AM";
		if(hour >= 12){
			day = "PM";
			if(hour > 12)
				hour -=12;
		}
		
		time = hour+":"+min+" "+day;
		
		return time;
		
	}
	
	OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
     @Override
     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

         Calendar calNow = Calendar.getInstance();
         Calendar calSet = (Calendar) calNow.clone();
         sBfast.setEnabled(true);
         calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
         calSet.set(Calendar.MINUTE, minute);
         calSet.set(Calendar.SECOND, 0);
         calSet.set(Calendar.MILLISECOND, 0);

         if (calSet.compareTo(calNow) <= 0) {
             // Today Set time passed, count to tomorrow
             calSet.add(Calendar.DATE, 1);
         }

         SetBfast.setText(hourFormat(calSet));
         cBfast = (Calendar) calSet.clone();
         
         if(isBfast == true){
        	 setAlarmBfast(cBfast);
         }
         
         
     }
 };
 
 OnTimeSetListener onTimeSetListener1 = new OnTimeSetListener() {
     @Override
     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

         Calendar calNow = Calendar.getInstance();
         Calendar calSet = (Calendar) calNow.clone();
         sLunch.setEnabled(true);
         calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
         calSet.set(Calendar.MINUTE, minute);
         calSet.set(Calendar.SECOND, 0);
         calSet.set(Calendar.MILLISECOND, 0);

         if (calSet.compareTo(calNow) <= 0) {
             // Today Set time passed, count to tomorrow
             calSet.add(Calendar.DATE, 1);
         }

         SetLunch.setText(hourFormat(calSet));
         cLunch = (Calendar) calSet.clone();
         if(isLunch == true){
        	 setAlarmLunch(cLunch);
        	 
         }
     }
 };
 
 OnTimeSetListener onTimeSetListener2 = new OnTimeSetListener() {
     @Override
     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

         Calendar calNow = Calendar.getInstance();
         Calendar calSet = (Calendar) calNow.clone();
         sSnack.setEnabled(true);
         calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
         calSet.set(Calendar.MINUTE, minute);
         calSet.set(Calendar.SECOND, 0);
         calSet.set(Calendar.MILLISECOND, 0);

         if (calSet.compareTo(calNow) <= 0) {
             // Today Set time passed, count to tomorrow
             calSet.add(Calendar.DATE, 1);
         }

         SetSnack.setText(hourFormat(calSet));
         cSnack = (Calendar) calSet.clone();
         if(isSnack == true){
        	setAlarmSnack(cSnack);
        	 
         }
     }
 };
 
 OnTimeSetListener onTimeSetListener3 = new OnTimeSetListener() {
     @Override
     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

         Calendar calNow = Calendar.getInstance();
         Calendar calSet = (Calendar) calNow.clone();
         sDinner.setEnabled(true);
         calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
         calSet.set(Calendar.MINUTE, minute);
         calSet.set(Calendar.SECOND, 0);
         calSet.set(Calendar.MILLISECOND, 0);

         if (calSet.compareTo(calNow) <= 0) {
             // Today Set time passed, count to tomorrow
             calSet.add(Calendar.DATE, 1);
         }

         SetDinner.setText(hourFormat(calSet));
         cDinner = (Calendar) calSet.clone();
         if(isDinner == true){
        	setAlarmDinner(cDinner);
        	
         }
     }
 };
 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alarm, menu);
		return true;
	}
	
	
	public void setAlarmBfast(Calendar targetCal)
	{
		 Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
	     PendingIntent pendingIntent = PendingIntent.getBroadcast(
	    		 getBaseContext(), RQS_1, intent, 0);
	     AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	     alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
	             pendingIntent);
	}
	
	public void setAlarmLunch(Calendar targetCal)
	{
		 Intent intent = new Intent(getBaseContext(), AlarmReceiver1.class);
	     PendingIntent pendingIntent = PendingIntent.getBroadcast(
	    		 getBaseContext(), RQS_1, intent, 0);
	     AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	     alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
	             pendingIntent);
	
	}
	
	
	public void setAlarmSnack(Calendar targetCal)
	{
		 Intent intent = new Intent(getBaseContext(), AlarmReceiver2.class);
	     PendingIntent pendingIntent = PendingIntent.getBroadcast(
	    		 getBaseContext(), RQS_1, intent, 0);
	     AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	     alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
	             pendingIntent);
	
	}
	
	public void setAlarmDinner(Calendar targetCal)
	{
		 Intent intent = new Intent(getBaseContext(), AlarmReceiver3.class);
	     PendingIntent pendingIntent = PendingIntent.getBroadcast(
	    		 getBaseContext(), RQS_1, intent, 0);
	     AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	     alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
	             pendingIntent);
	
	}
	public void nextFrame(View view) {
	    // Do something in response to button

	}
	
	public void confirmUser(){
		
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		final AlertDialog.Builder alert1 = new AlertDialog.Builder(this);
		final String name = bd.getName();
				alert.setTitle("Warning");
				alert.setCancelable(true);
				alert.setMessage("Are you sure you want to erase the records of baby "+ name+ " ?");
				alert.setPositiveButton("Yes",
		                    new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int id) {
		                	alert1.setTitle("Alert");
		                	alert1.setMessage("baby "+name+"'s record has been erased.");
		                	alert1.show();
		                    bd.deleteBaby();
		                    goToRegister();
		                }
		            });
				alert.setNegativeButton("No",
	                    new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    dialog.cancel();
	                }
	            });
				alert.show();
			
		

	}
	
	public void goToRegister(){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}

}
