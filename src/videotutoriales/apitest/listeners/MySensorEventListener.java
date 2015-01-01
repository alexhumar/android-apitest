package videotutoriales.apitest.listeners;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class MySensorEventListener implements SensorEventListener {

	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	public MySensorEventListener (TextView aTextView) {
		textView = aTextView;
	}
	
	private String getAxisData(SensorEvent event){
		builder.setLength(0);
		builder.append("x: ");
		builder.append(event.values[0]); /*Obtengo el valor del eje x*/
		builder.append("\n");
		builder.append("y: ");
		builder.append(event.values[1]); /*Obtengo el valor del eje y*/
		builder.append("\n");
		builder.append("z: ");
		builder.append(event.values[2]); /*Obtengo el valor del eje z*/
		return builder.toString();
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		/*Se invoca cuando un nuevo evento acelerómetro tiene lugar*/
		textView.setText(getAxisData(event));
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		/*Se invoca cuando la precisión del acelerómetro cambia*/
		
		//Para este ejemplo, no hace nada.
	}

}
