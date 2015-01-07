package videotutoriales.apitest.helper;

import java.io.File;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class TtfRenderView extends View {
	
	Paint paint;
	Typeface font;
	Rect bounds = new Rect();

	public TtfRenderView(Context context) {
		super(context);
		paint = new Paint();
		String ttfPath = "fonts" + File.separator + "stocky.ttf";
		font = Typeface.createFromAsset(context.getAssets(), ttfPath);
	}

	protected void onDraw(Canvas canvas) {
		paint.setColor(Color.GREEN);
		paint.setTypeface(font);
		//Tamaño de texto en pixeles
		paint.setTextSize(28);
		paint.setTextAlign(Paint.Align.CENTER);
		String text = "Esto es una prueba!";
		/*El pixel origen (cuyas coordenadas se establecen en el segundo y tercer parámetro)
		 * depende de la alineación del texto. Si es left se toma el píxel de la esquina superior 
		 * del rectángulo que contiene el texto; si es center se toma el píxel central del rectángulo 
		 * y si es right se toma el píxel de la esquina superior derecha*/
		canvas.drawText(text, canvas.getWidth() / 2, 100, paint);
		text = "Esto es otra prueba!! :)";
		paint.setColor(Color.BLUE);
		paint.setTextSize(18);
		paint.setTextAlign(Paint.Align.LEFT);
		/*Retorna el rectángulo más chico que puede contener 
		 * todos los caracteres entre aquellos especificados (0 y text.length()*/
		paint.getTextBounds(text, 0, text.length(), bounds);
		canvas.drawText(text, canvas.getWidth() - bounds.width(), 140, paint);
		this.invalidate();
	}
	
}
