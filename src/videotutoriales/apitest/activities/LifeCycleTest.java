package videotutoriales.apitest.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LifeCycleTest extends Activity {
	
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	private void log(String text){
		/*El primer argumento es un tag, y el segundo el mensaje a loguear*/
		Log.d("LifeCycleTest", text);
		/*Se inserta en el StringBuilder para que no se pierda entre el monton de mensajes*/
		builder.append(text);
		builder.append('\n');
		/*Se muestra en pantalla*/
		textView.setText(builder.toString());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText(builder.toString());
		/*A este método se le puede pasar, entre otros, o un objeto View con complejidad indefinida,
		 *  o bien un archivo .xml de layout definido mediante una constante en R.java*/
		setContentView(textView);
		log("Creada!");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		log("Reanudada!");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		log("Pausada!");
		/*Para saber si el sistema me va a destruir la activity*/
		if(isFinishing()) {
			log("Será eliminada!!");
		}
	}
}
