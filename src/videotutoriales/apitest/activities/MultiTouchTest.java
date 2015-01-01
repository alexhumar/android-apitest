package videotutoriales.apitest.activities;

import videotutoriales.apitest.listeners.MyMultiTouchListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MultiTouchTest extends Activity {
	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		textView = new TextView(this);
		MyMultiTouchListener listener = new MyMultiTouchListener();
		
		textView.setText("Toca y arrastra!! (Soporta múltiples dedos)");
		textView.setOnTouchListener(listener);
		
		setContentView(textView);
	}
}
