package src.p03.c01;

/**
 * Objeto <code>Runnable</code> que permite simular las salidas de un parque. 
 * 
 * @author Carlos López Nozal
 * @author José Antonio Barbero Aparicio
 * @author José Redondo Guerra
 * @author Rodrigo Merino Tovar
 * 
 * @version 1.0
 * @since 1.0
*/
public class ActividadSalidaPuerta implements Runnable{

	/**
	 * Atributo de clase. Número máximo de salidas = número máximo de entradas. 
	 */
	private static final int NUMSALIDAS = 20;
	/**
	 * Atributo de clase. Nombre de la puerta.
	 */
	private String puerta;
	/**
	 * Atributo de clase. Parque del que se sale. 
	 */
	private IParque parque;

	/**
	 * Constructor.
	 * 
	 * @param puerta Letra representativa de la puerta de salida.
	 * @param parque Objeto Parque del que se sale.
	 */
	public ActividadSalidaPuerta(String puerta, IParque parque) {
		this.puerta = puerta;
		this.parque = parque;
	}

	/**
	 * run() para implementar las características de un hilo. 
	 */
	@Override
	public void run() {
		for (int i = 0; i < NUMSALIDAS; i ++) {
			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(5)*1000);
				parque.salirDelParque(puerta);
			} catch (InterruptedException e) {
				Logger.getGlobal().log(Level.INFO, "Salida interrumpida");
				Logger.getGlobal().log(Level.INFO, e.toString());
				return;
			}
		}
	}
}