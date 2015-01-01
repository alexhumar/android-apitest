package videotutoriales.apitest.activities;

import videotutoriales.apitest.listeners.MySensorEventListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class AccelerometerTest extends Activity {
	
	TextView textView;
	MySensorEventListener listener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		textView = new TextView(this);
		
		/*Se crea un SensorManager, para poder consultar si el dispositivo cuenta con acelerómetro y en ese caso
		 * obtener un objeto que lo represente.
		 * El método getSystemService permite acceder a los diversos servicios provistos por Android*/
		SensorManager manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		/*Se verifica que haya un sensor acelerómetro disponible en el dispositivo*/
		if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() == 0) {
			textView.setText("No hay un acelerómetro instalado en el dispositivo");
		}
		else {
			/*Obtengo el objeto que me representa el sensor acelerómetro*/
			Sensor accelerometer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			/*Creo y registro el listener para eventos del sensor acelerómetro*/
			listener = new MySensorEventListener(textView);
			if (!manager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_GAME)) {
				textView.setText("Ha ocurrido un problema al registrar el sensor listener");
			}
		}
		setContentView(textView);
	}

}
