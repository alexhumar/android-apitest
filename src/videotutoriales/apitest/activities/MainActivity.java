package videotutoriales.apitest.activities;

//Actividad que sirve para mostrar una lista de elementos.
import android.app.ListActivity; 
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/*import android.view.Menu;
import android.view.MenuItem;*/
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	String pruebas[] = { "LifeCycleTest", "SingleTouchTest", "MultiTouchTest",
			              "KeyTest", "AccelerometerTest", "AssetsTest", 
			              "ExternalStorageTest", "SoundPoolTest", "MediaPlayerTest", "FullScreenTest",
			              "RenderViewTest", "FontTest", "SurfaceViewTest"
			           };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);                              /*API UI de Android - Cada ítem de la lista se muestra con un objeto View*/
		ArrayAdapter<String> MenuItems = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pruebas);
		setListAdapter(MenuItems);
	}
	
	@Override
	protected void onListItemClick(ListView list, View view, int position, long id)
	{
		super.onListItemClick(list, view, position, id);
		String claseActivity = pruebas[position];
		String packageActivity = "videotutoriales.apitest.activities.";
		/*Cualquier activity definida en el manifest puede ser iniciada programáticamente con la clase Intent*/
        try {
        	Class<?> activityALanzar = Class.forName(packageActivity + claseActivity);
        	/*Recibe como parametros un Context, brindado por la ActivityMain y la clase activity a lanzar.*/
        	Intent intent = new Intent(this, activityALanzar);
        	startActivity(intent);  	
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
}