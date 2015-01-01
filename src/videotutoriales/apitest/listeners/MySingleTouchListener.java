package videotutoriales.apitest.listeners;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MySingleTouchListener implements OnTouchListener {
	
	StringBuilder builder = new StringBuilder();
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		TextView localTextView;
		Boolean finalizarEvento = true;
		
		/*Para suprimir un warning de eclipse*/
		v.performClick();
		
		/*Se limpia el string del builder*/
		builder.setLength(0);
		/*El getAction de MotionEvent nos dice si se presionó, si se soltó o movió el dedo, o canceló el gesto*/
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			builder.append("presiona, ");
			break;
		case MotionEvent.ACTION_UP:
			builder.append("levanta, ");
			break;
		case MotionEvent.ACTION_MOVE:
			builder.append("mueve, ");
			break;
		case MotionEvent.ACTION_CANCEL:
			builder.append("cancela, ");
			break;
		}
		
		/*Del MotionEvent obtenemos también las coordenadas del toque*/
		builder.append(event.getX());
		builder.append(", ");
		builder.append(event.getY());
		String text = builder.toString();
		Log.d("TouchTest", text);
		
		if(v instanceof TextView) {
			localTextView = (TextView) v;
			localTextView.setText(text);
		}
		
		/*Con esto estamos diciendo que el evento ya se procesó y por lo tanto ha finalizado,
		 * lo que nos va a permitir poder procesar los demás eventos: el MOVE y el UP...
		 * Para más info ver Video 06 - minuto 17:00*/
		return finalizarEvento;
	}
}