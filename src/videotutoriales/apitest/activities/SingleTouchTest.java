package videotutoriales.apitest.activities;

import videotutoriales.apitest.listeners.MySingleTouchListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
 
public class SingleTouchTest extends Activity {
	
	//StringBuilder builder = new StringBuilder();
	TextView textView;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText("Toca y arrastra (Un dedo solamente!)");
		MySingleTouchListener listener = new MySingleTouchListener();
		
		/*Los eventos - en este caso el OnTouchListener - se registran en las views*/
		textView.setOnTouchListener(listener);
		/*IMPORTANTE!! No me queda claro el alcance del registro del evento. Se registra en la textView pero funciona para toda la pantalla...
		 * No me cierra. Quizás el listener se ejecute para cualquier toque y notifica a los objetos registrados...*/
		
		
		setContentView(textView);
	}	
}