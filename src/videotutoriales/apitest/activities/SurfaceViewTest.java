package videotutoriales.apitest.activities;

import videotutoriales.apitest.helper.FastRenderView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SurfaceViewTest extends Activity {
	
	FastRenderView renderView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		int flagFullScreen = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		this.getWindow().setFlags(flagFullScreen, flagFullScreen);
		renderView = new FastRenderView(this);
		this.setContentView(renderView);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		renderView.resume();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		renderView.pause();
	}
}
