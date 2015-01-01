package videotutoriales.apitest.listeners;

import java.io.File;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.app.Activity;

public class MySoundClickListener implements OnClickListener {
	
	Activity registeredActivity;
	
	public MySoundClickListener (Activity anActivity) {
		this.registeredActivity = anActivity;
	}
	
	private void triggerIntent(Intent intent) {
		this.registeredActivity.startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		/*ACTION_VIEW es el modo más común de lanzar una activity, generalmente cuando sólo deben mostrarse datos al usuario */
		Intent intent = new Intent(Intent.ACTION_VIEW);
		File sdCard = Environment.getExternalStorageDirectory();
		String audioFilePath = sdCard.getAbsolutePath() + File.separator + "Music" + File.separator 
		                       + "Genesis" + File.separator + "Foxtrot" + File.separator +
		                       "05 - Horizons.By_GR0SS0PUFF0.mp3";
		File audioFile = new File(audioFilePath);
		intent.setDataAndType(Uri.fromFile(audioFile), "audio/mp3");
		this.triggerIntent(intent);
	}

}
