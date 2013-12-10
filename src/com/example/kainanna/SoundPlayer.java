package com.example.kainanna;

import java.util.HashMap;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundPlayer {
	
	public static final int S1 = R.raw.abc;
	private static SoundPool sp;
	private static HashMap spMap;
	
	
	@SuppressWarnings("unchecked")
	public static void initSounds(Context context) {

		sp = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);

		spMap = new HashMap(1);    

		spMap.put(S1, sp.load(context, R.raw.abc, 1) );
		}
	
	public static void playSound(Context context, int soundID) {

		
		MediaPlayer mp = MediaPlayer.create(context, soundID); 
		mp.start();
		
		if(sp == null || spMap == null){

		initSounds(context);

		}

		float volume = (float) 0.7;// whatever in the range = 0.0 to 1.0

		 

		// play sound with same right and left volume, with a priority of 1,

		// zero repeats (i.e play once), and a playback rate of 1f

		sp.play((Integer) spMap.get(soundID), volume, volume, 1, 0, 1f);

		}

}
