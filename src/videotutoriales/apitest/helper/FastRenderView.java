package videotutoriales.apitest.helper;

import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/*SurfaceView es eso, una View que contiene un objeto Surface. 
 * Surface es un buffer utilizado por el "compositor de pantalla", 
 * este último se encarga del renderizado en Android. Envía los 
 * píxeles a mostrar a la GPU del dispositivo. Para trabajar con 
 * el Surface utilizamos un SurfaceHolder.
 * 
 * La Surface no se crea inmediatamente cuando se instancia la
 * SurfaceView; además, la Surface se destruye cada vez que se
 * pausa la activity, y se reconstruye cuando se reanuda. Ahorra 
 * recursos cuando la Activity está en segundo plano. */
public class FastRenderView extends SurfaceView implements Runnable {

	//Con esto el renderizado no se realizará en el thread de la UI.
	
	Thread renderThread = null;
	SurfaceHolder holder;
	/*Que sea volátil implica que los threads que la acceden tengan que 
	 * leer la variable para refrescar a su último valor cada vez que 
	 * trabajan con ella. Se utiliza cuando se accede concurrentemente
	 * (desde varios threads). 
	 * No por lo que dice el video, porque no lo entiendo, pero según 
	 * me imagino, es porque running se pone en false desde el thread 
	 * de la activity (el pause() se invoca desde ella). Entonces, que 
	 * sea volátil hace que el thread
	 * de la view (o sea este) refresque el valor de running antes de leerla, en el run(),
	 * evitando que pueda entrarse al while cuando running se puso en false desde
	 * la activity (por temas de caché de variables de este thread). */
	volatile boolean running = false;
	int r,g,b;
	Random random;
	
	public FastRenderView(Context context) {
		super(context);
		holder = this.getHolder();
		random = new Random();
	}
	
	public void resume() {
		running = true;
		renderThread = new Thread(this);
		/*En el start() el método run() es invocado desde el thread
		 * donde se ejecuta, y no del thread que le indica que se ejecute.*/
		renderThread.start();
	}
	
	public void pause() {
		running = false;
		try {
			renderThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(running) {
			/*Si la surface fue creada y es válida... */
			if(!holder.getSurface().isValid()) {
				continue;
			}
			/*Bloquea la Surface para el renderizado, devolviendo una instancia de canvas,
			sobre la que podemos trabajar*/
			Canvas canvas = holder.lockCanvas();
			r = random.nextInt(256);
			g = random.nextInt(256);
			b = random.nextInt(256);
			canvas.drawRGB(r, g, b);
			/*Desbloquea la Surface y se asegura que lo que hayamos dibujado en el canvas se
			 * muestre en la pantalla. */
			holder.unlockCanvasAndPost(canvas);
		}

	}

}
