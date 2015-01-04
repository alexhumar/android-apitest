package videotutoriales.apitest.helper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class ShapeRenderView extends View {
	
	Paint paint;

	public ShapeRenderView (Context context) {
		super(context);
		paint = new Paint();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		canvas.drawRGB(255, 255, 255);
		paint.setColor(Color.RED);
		//Como parametros se le pasa las coordenadas de los dos puntos que forman la recta, y el paint para el estilo
		canvas.drawLine(0, 0, width - 1, height - 1, paint);
		
		paint.setStyle(Style.STROKE);
		paint.setColor(Color.BLUE);
		canvas.drawCircle(width / 2, height / 2, 40, paint);
		
		paint.setStyle(Style.FILL);
		paint.setColor(Color.GREEN);
		canvas.drawRect(0, height - 60, width - 60, height - 1, paint);
		
		this.postInvalidate();
	}
	
}
