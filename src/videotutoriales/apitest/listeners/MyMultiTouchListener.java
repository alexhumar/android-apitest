package videotutoriales.apitest.listeners;

import android.view.View;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.widget.TextView;

public class MyMultiTouchListener implements OnTouchListener {
	
	StringBuilder builder = new StringBuilder();
	float[] x = new float[10];
	float[] y = new float[10];
	boolean[] tocado = new boolean[10];
	
	private String getTextForTextView() {
		builder.setLength(0);
		for(int i = 0; i < 10; i++) {
			builder.append(tocado[i]);
			builder.append(", ");
			builder.append(x[i]);
			builder.append(y[i]);
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	/*Por cada movimiento que se haga con cada dedo se dispara esto.
	 * Pero cada vez que se ejecuta se cuenta con la info de un solo dedo,
	 * y de una action en particular.*/
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		TextView localTextView;
		/*Obtenemos el valor binario del action del evento*/
		//int action = event.getAction() & MotionEvent.ACTION_MASK;
		/*El resultado de la operacion AND se lo asigna a dicha constante, que almacena los cambios (UP o DOWN) que se llevaron a cabo sobre la pantalla*/
		//int pointerIndex = (event.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
		/*IMPORTANTE!! Para mas info, ir al video 06, minuto 44:10*/
		v.performClick();
		
		int action = event.getActionMasked();
		int pointerIndex = event.getActionIndex();
		int pointerId = event.getPointerId(pointerIndex);
		switch (action) {
		/*Se produce cuando el primer dedo toca la pantalla (sería como un SingleTouch)*/
		case MotionEvent.ACTION_DOWN:	
		/*Se produce cuando se presiona con un dedo y ya hay un dedo o varios en la pantalla*/
		case MotionEvent.ACTION_POINTER_DOWN:
			/*Se aplica la misma logica para ambas actions*/
			tocado[pointerId] = true;
			x[pointerId] = (int)event.getX(pointerIndex);
			y[pointerId] = (int)event.getY(pointerIndex);
			break;
		/*Se produce cuando un dedo en la pantalla se levanta, si es el único que la está presionando*/
		case MotionEvent.ACTION_UP:
		/*Se produce cuando un dedo se levanta, si se está tocando la pantalla con más de un dedo*/
		case MotionEvent.ACTION_POINTER_UP:
		case MotionEvent.ACTION_CANCEL:
			/*Se aplica la misma logica para las tres actions*/
			tocado[pointerId] = false;
			x[pointerId] = (int)event.getX(pointerIndex);
			y[pointerId] = (int)event.getY(pointerIndex);
			break;
		/*Este caso es especial. Puede darse que un MotionEvent posea datos de distintos MOVE*/
		case MotionEvent.ACTION_MOVE:
			/*Se comprueba la cantidad de eventos contenidos en el MotionEvent*/
			int pointerCount = event.getPointerCount();
			for (int i = 0; i < pointerCount; i++) {
				pointerIndex = i;
				pointerId = event.getPointerId(pointerIndex);
				x[pointerId] = (int)event.getX(pointerIndex);
				y[pointerId] = (int)event.getY(pointerIndex);
			}
			break;
		}
		
		if(v instanceof TextView) {
			localTextView = (TextView)v;
			localTextView.setText(getTextForTextView());
		}
		
		return true;
	}
}