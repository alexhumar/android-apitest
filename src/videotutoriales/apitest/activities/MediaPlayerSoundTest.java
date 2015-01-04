package videotutoriales.apitest.activities;

import videotutoriales.apitest.listeners.MySoundCompletionListener;
import com.videotutoriales.apitest.R;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;

public class MediaPlayerSoundTest extends Activity {

	MediaPlayer mediaPlayer;
	MySoundCompletionListener listener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mediaplayer);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		mediaPlayer = MediaPlayer.create(this, R.raw.electro_ogg);
		listener = new MySoundCompletionListener();
		mediaPlayer.setOnCompletionListener(listener);
		mediaPlayer.start();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		mediaPlayer.stop();
		mediaPlayer.release();
	}
	
}
