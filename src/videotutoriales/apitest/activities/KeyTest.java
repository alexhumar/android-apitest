package videotutoriales.apitest.activities;

import videotutoriales.apitest.listeners.MyKeyListener;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

public class KeyTest extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		MyKeyListener listener = new MyKeyListener();
		textView.setText("Pulsa las teclas y observa el resultado en la pantalla!!");
		textView.setOnKeyListener(listener);
		/*Para que una View reciba eventos de teclado, debe tener el foco*/
		textView.setFocusableInTouchMode(true);
		textView.requestFocus();
		setContentView(textView);
	}
}