package videotutoriales.apitest.listeners;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class PictureDrawTouchListener implements OnTouchListener {

	float downx = 0;
	float downy = 0;
	float upx = 0;
	float upy = 0;
	Canvas canvas;
	Paint paint;
	
	
	public void setCanvas(Canvas aCanvas) {
		canvas = aCanvas;
	}
	
	public void setPaint(Paint aPaint) {
		paint = aPaint;
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		v.performClick();
		int action = event.getAction();
		switch(action) {
		case MotionEvent.ACTION_DOWN:
			downx = event.getX();
			downy = event.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			upx = event.getX();
			upy = event.getY();
			canvas.drawLine(downx, downy, upx, upy, paint);
			v.invalidate();
			downx = upx;
			downy = upy;
		case MotionEvent.ACTION_UP:
			upx = event.getX();
			upy = event.getY();
			canvas.drawLine(downx, downy, upx, upy, paint);
			v.invalidate();
			break;
		case MotionEvent.ACTION_CANCEL:
			break;
		default:
			break;
		}
		
		return true;
	}

}
