package videotutoriales.apitest.listeners;

import android.util.Log;
import android.view.View;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.widget.TextView;

public class MyKeyListener implements OnKeyListener {

	StringBuilder builder = new StringBuilder();
	
	
	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		builder.setLength(0);
		switch (event.getAction()) {
		case KeyEvent.ACTION_DOWN:
			builder.append("down, ");
			break;
		case KeyEvent.ACTION_UP:
			builder.append("up, ");
			break;
		}
		/*Se obtiene el código único de la tecla presionada*/
		builder.append(event.getKeyCode());
		builder.append(", ");
		/*Se obtiene el caracter de la tecla pulsada*/
		builder.append((char)event.getUnicodeChar());
		String text = builder.toString();
		Log.d("KeyTest", text);
		if(v instanceof TextView) {
			TextView localTextView = (TextView) v;
			localTextView.setText(text);
		}
		/*Para no cortar el procesamiento del evento en caso de que se 
		 * aprete la tecla de back, para poder volver a la activity main, 
		 * es decir, poder volver al menu*/
		if(event.getKeyCode() == KeyEvent.KEYCODE_BACK) 
			return false;
		else
			return true;
	}
	
}
