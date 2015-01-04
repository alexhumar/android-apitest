package videotutoriales.apitest.helper;

import java.util.Random;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;


public class RenderView extends View {

	Random random = new Random();
	
	public RenderView(Context context) {
		super(context);
	}
	
	protected void onDraw(Canvas canvas) {
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		canvas.drawRGB(r, g, b);
		//Se le indica a Android que redibuje siempre que sea posible
		//this.invalidate();
		this.postInvalidate();
	}
}
