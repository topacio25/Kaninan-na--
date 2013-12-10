package com.example.kainanna;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AlarmSetter extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alarm);
	}
	
	 public void setAlarm(Context c, Calendar targetCal, int RQS_1) {

		 Intent intent = new Intent(c, AlarmReceiver.class);
	     PendingIntent pendingIntent = PendingIntent.getBroadcast(
	             c, RQS_1, intent, 0);
	     AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	     alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(),
	             pendingIntent);

	 }

}
