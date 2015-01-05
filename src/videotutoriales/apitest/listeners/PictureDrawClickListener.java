package videotutoriales.apitest.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class PictureDrawClickListener implements OnClickListener {

	Activity activity;
	
	public PictureDrawClickListener(Activity anActivity) {
		activity = anActivity;
	}
	
	@Override
	public void onClick(View v) {
		Intent eligeFotoIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		//Relacionado al método onActivityResult (en ChoosePictureDrawTest)
		activity.startActivityForResult(eligeFotoIntent, 0);
	}

}
