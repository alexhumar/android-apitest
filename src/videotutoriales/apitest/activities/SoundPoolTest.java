package videotutoriales.apitest.activities;

import java.io.IOException;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import videotutoriales.apitest.listeners.MySoundTouchListener;
import android.widget.TextView;

public class SoundPoolTest extends Activity {

	SoundPool soundPool;
	int miSonidoId = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		String textForTextView = "Toca para reproducir el sonido!!";
		/*Para que el volumen del stream de musica, que es por donde se reproducirán los sonidos,
		 * pueda controlarse mediante los botones del teléfono para subir y bajar el volumen*/
		this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		/*Se le indica la maxima cantidad de sonidos que puede reproducir a la vez, y el tipo de stream*/
		soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC,0);
		try {
			AssetManager assetManager = this.getAssets();
			AssetFileDescriptor assetDescriptor = assetManager.openFd("sounds/electro.ogg");
			miSonidoId = soundPool.load(assetDescriptor, 1);	
		}
		catch (IOException e) {
			textForTextView = "No se ha podido cargar el efecto de sonido desde asset" + e.getMessage();
		}
		MySoundTouchListener listener = new MySoundTouchListener(soundPool, miSonidoId);
		textView.setOnTouchListener(listener);
		textView.setText(textForTextView);
		this.setContentView(textView);
	}
	
}
