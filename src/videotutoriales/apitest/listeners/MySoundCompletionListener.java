package videotutoriales.apitest.listeners;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class MySoundCompletionListener implements OnCompletionListener {

	@Override
	public void onCompletion(MediaPlayer mp) {
		//Creo que va a generar un loop de reproduccion mientras la activity este activa
		mp.start();
	}

}
