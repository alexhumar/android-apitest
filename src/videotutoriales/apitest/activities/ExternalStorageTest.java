package videotutoriales.apitest.activities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.app.Activity;

public class ExternalStorageTest extends Activity {
	
	private void writeTextFile(File aFile, String someText) throws IOException {
		/*FileWriter posee funcionalidad para escribir streams a un archivo, mientras que
		 * BufferedWriter envuelve al FileWriter, además de proveer funcionalidad de buffer.*/
		BufferedWriter writer = new BufferedWriter(new FileWriter(aFile));
		writer.write(someText);
		writer.close();
	}
	
	private String readTextFile(File aFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(aFile));
		StringBuilder builder = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			builder.append(line);
			builder.append("\n");
		}
		reader.close();
		return builder.toString();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		String textViewText = "";
		/*Se obtiene el estado de la SDCard*/
		String estado = Environment.getExternalStorageState();
		if(!estado.equals(Environment.MEDIA_MOUNTED)) {
			textViewText = "No hay almacenamiento externo montado";
		}
		else {
			/*Obtenemos el directorio raíz de la SDCard*/
			File externalDir = Environment.getExternalStorageDirectory();
			File textFile = new File(externalDir.getAbsolutePath() + File.separator + "texto.txt");
			try {
				String someText = "Esto es una prueba de funcionamiento del almacenamiento externo.";
				writeTextFile(textFile, someText);
				textViewText = readTextFile(textFile);
				if(!textFile.delete()) {
					textViewText = "No se ha podido eliminar el archivo temporal";
				}
			}
			catch (IOException e) {
				textViewText = "Se ha producido un error!!" + e.getMessage();
			}
		}
		textView.setText(textViewText);
		setContentView(textView);
	}
}
