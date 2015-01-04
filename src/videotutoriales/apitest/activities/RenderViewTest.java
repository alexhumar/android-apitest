package videotutoriales.apitest.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import videotutoriales.apitest.helper.RenderView;

public class RenderViewTest extends Activity {

	RenderView renderView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		renderView = new RenderView(this);
		//Pantalla completa
		int flagFullScreen = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(flagFullScreen, flagFullScreen);
		
		this.setContentView(renderView);
	}
	
}
