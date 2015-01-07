package videotutoriales.apitest.activities;

import videotutoriales.apitest.helper.TtfRenderView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class FontTest extends Activity {

	TtfRenderView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		Integer flagFullScreen = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		this.getWindow().setFlags(flagFullScreen, flagFullScreen);
		view = new TtfRenderView(this);
		this.setContentView(view);
	}
	
}
