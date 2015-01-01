package videotutoriales.apitest.activities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

public class AssetsTest extends Activity {
	
	private String cargarArchivoTexto(InputStream inputStream) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int len = 0;
		while ((len = inputStream.read(buffer)) > 0)
			/*Parametros: buffer a escribir, offset del buffer desde donde
			 * comienza a leer, cantidad de bytes a escribir*/
			byteStream.write(buffer, 0, len);
		return new String(byteStream.toByteArray(),"UTF8");
	}
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		AssetManager assetManager = getAssets(); /*Viene de Context.getAssets()*/
		InputStream inputStream = null;
		String textForTextView = "";
		
		try {
			/*Ruta relativa al directorio assets*/
			String filename = "canciones/newyearsday.txt";
			inputStream = assetManager.open(filename);
			textForTextView = cargarArchivoTexto(inputStream);
		}
		catch (IOException e) {
			textForTextView = "No se puede cargar el archivo";
		}
		finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				}
				catch (IOException e) {
					textForTextView = "No se puede cerrar el archivo";
				} 
			}
		}
		textView.setText(textForTextView);
		setContentView(textView);
	}
}
