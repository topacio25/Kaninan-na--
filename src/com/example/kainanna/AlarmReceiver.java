package com.example.kainanna;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
	SoundPlayer sp = new SoundPlayer();
    @Override
    public void onReceive(Context k1, Intent k2) {
        // TODO Auto-generated method stub
         Toast.makeText(k1, "It is time for Breakfast!", Toast.LENGTH_LONG).show();
         sp.playSound(k1, R.raw.abc);
    }

}