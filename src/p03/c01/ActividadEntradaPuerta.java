package src.p03.c01;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto <code>Runnable</code> que permite simular las salidas de un parque. 
 * 
 * @author Carlos López Nozal
 * @author José Antonio Barbero Aparicio
 * 
 * @version 1.0
 * @since 1.0
 */
public class ActividadEntradaPuerta implements Runnable{

		/**
		* Atributo de clase. Número máximo de entradas = número máximo de salidas. 
		*/
		private static final int NUMENTRADAS = 20;
		/**
		* Atributo de clase. Nombre de la puerta.
		*/
		private String puerta;
		/**
		* Atributo de clase. Parque al que se entra. 
		*/
		private IParque parque;

		/**
		 * Constructor.
		 * 
		 * @param puerta Letra representativa de la puerta de entrada.
		 * @param parque Objeto Parque al que se entra.
		 */
		public ActividadEntradaPuerta(String puerta, IParque parque) {
			this.puerta = puerta;
			this.parque = parque;
		}
		
		/**
		 * run() para implementar las características de un hilo. 
		 */
		@Override
		public void run() {
			for (int i = 0; i < NUMENTRADAS; i ++) {
				try {
					parque.entrarAlParque(puerta);
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5)*1000);
				} catch (InterruptedException e) {
					Logger.getGlobal().log(Level.INFO, "Entrada interrumpida");
					Logger.getGlobal().log(Level.INFO, e.toString());
					return;
				}
			}
		}

}
