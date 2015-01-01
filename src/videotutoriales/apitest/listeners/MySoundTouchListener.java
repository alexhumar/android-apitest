package videotutoriales.apitest.listeners;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.media.SoundPool;

public class MySoundTouchListener implements OnTouchListener {

	SoundPool soundPool;
	int idSoundToPlay;
	int idSoundPlaying = -1;
	
	public MySoundTouchListener (SoundPool aSoundPool, int anIdSoundToPlay) {
		soundPool = aSoundPool;
		idSoundToPlay = anIdSoundToPlay;
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		v.performClick();
		
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (idSoundToPlay != -1) {
				/*Si se estaba reproduciendo, lo paro*/
				soundPool.stop(idSoundPlaying);
				int leftVolume = 1;
				int rightVolume = 1;
				int priority = 0;
				int loop = 0;
				int rate = 1;
				idSoundPlaying = soundPool.play(idSoundToPlay, leftVolume, rightVolume, priority, loop, rate);
			}
		}		
		return true;
	}

}
