package videotutoriales.apitest.activities;

import java.io.IOException;
import java.io.InputStream;

import com.videotutoriales.apitest.R;

import videotutoriales.apitest.listeners.PictureDrawClickListener;
import videotutoriales.apitest.listeners.PictureDrawTouchListener;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.ImageView;

public class ChoosePictureDrawTest extends Activity {

	ImageView eligeImageView;
	Button eligeFoto;
	Bitmap bmp, alteredBitmap;
	Canvas canvas;
	Paint paint;
	Matrix matrix;
	PictureDrawClickListener clickListener;
	PictureDrawTouchListener touchListener;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		clickListener = new PictureDrawClickListener(this);
		touchListener = new PictureDrawTouchListener();
		
		this.setContentView(R.layout.activity_image);
		
		eligeImageView = (ImageView) this.findViewById(R.id.EligeImagenView);
		eligeFoto = (Button) this.findViewById(R.id.EligeFotoButton);
		
		//eligeImageView.setOnTouchListener(touchListener);
		eligeFoto.setOnClickListener(clickListener);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		//Se usa cuando queremos que una activity lanzada por esta nos devuelva un resultado al finalizar
		//Debe llamarse al método startActivityForResult (en este caso, en PictureDrawClickListener)
		super.onActivityResult(requestCode, resultCode, intent);
		if(resultCode == RESULT_OK) {
			Uri imageFileUri = intent.getData();
			Display currentDisplay = this.getWindowManager().getDefaultDisplay();
			
			//Se obtiene el ancho y alto del display (lo comentado es para API >= 13)
			/*Point point = new Point();
			currentDisplay.getSize(point);			
			float dwidth = point.x;
			float dheight = point.y;*/
			float dw = currentDisplay.getWidth();
			float dh = currentDisplay.getHeight();
			
			BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
			//Es para poder acceder a los datos de la imagen que trae el intent pero sin que se cargue el original
			//Se hace ya que al principio solo se calcula el heightRatio y widthRatio
			bmpFactoryOptions.inJustDecodeBounds = true;
			
			try {
				//Obtiene el input stream a partir de la URI
				InputStream is = this.getContentResolver().openInputStream(imageFileUri);
				//Convierte el input stream en imagen
				bmp = BitmapFactory.decodeStream(is, null, bmpFactoryOptions);
				
				//Redimensionamos el tamaño de la imagen para adaptarlo al del display
				int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight / dh);
				int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth / dw);
				
				if(heightRatio > 1 && widthRatio > 1) {
					if(heightRatio > widthRatio) {
						bmpFactoryOptions.inSampleSize = heightRatio;
					} else {
						//Si el ancho es mayor, escalar de acuerdo a él
						bmpFactoryOptions.inSampleSize = widthRatio;
					}
				}
				
				//Ahora si, cargamos el bitmap mutable, sobre el cual podremos pintar
				bmpFactoryOptions.inJustDecodeBounds = false;
				is = this.getContentResolver().openInputStream(imageFileUri);
				//Cargamos el bitmap original
				bmp = BitmapFactory.decodeStream(is, null, bmpFactoryOptions);
				//Creamos el bitmap editable
				alteredBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());
				canvas = new Canvas(alteredBitmap);
				paint = new Paint();
				paint.setColor(Color.GREEN);
				paint.setStrokeWidth(5);
				matrix = new Matrix();
				canvas.drawBitmap(bmp, matrix, paint);
				
				eligeImageView.setImageBitmap(alteredBitmap);
				
				touchListener.setCanvas(canvas);
				touchListener.setPaint(paint);
				eligeImageView.setOnTouchListener(touchListener);
			}
			catch (IOException e) {
				Log.v("ChoosePictureTest", e.toString());
			}
			
		}
		
	}
}
