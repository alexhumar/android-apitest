package videotutoriales.apitest.activities;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/*La idea es instanciar algo similar a SingleTouchTest pero en fullscreen*/
public class FullScreenTest extends SingleTouchTest {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Para que no muestre el tìtulo en la parte superior de la pantalla
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		int flagFullscreen = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		//Para que se ejecuta en full screen
		this.getWindow().setFlags(flagFullscreen, flagFullscreen);
		
		//Los métodos anteriores deben ivocarse antes de setear el content view a la activity
		super.onCreate(savedInstanceState);
	}
	
}
