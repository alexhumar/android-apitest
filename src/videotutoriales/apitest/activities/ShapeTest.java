package videotutoriales.apitest.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import videotutoriales.apitest.helper.ShapeRenderView;

public class ShapeTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Pantalla completa
		int flagFullScreen = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(flagFullScreen, flagFullScreen);
		
		ShapeRenderView renderView = new ShapeRenderView(this);
		this.setContentView(renderView);
	}
	
}
