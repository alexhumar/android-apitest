package videotutoriales.apitest.activities;

import com.videotutoriales.apitest.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import videotutoriales.apitest.listeners.MySoundClickListener;

public class MediaPlayerTest extends Activity {

	Button playButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_player);
		playButton = (Button) this.findViewById(R.id.button_reproducir);
		MySoundClickListener listener = new MySoundClickListener(this);
		playButton.setOnClickListener(listener);
	}
	
}
