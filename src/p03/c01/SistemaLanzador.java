package src.p03.c01;

/**
 * Clase que contiene el main() para lanzar los hilos. 
 * 
 * @author Carlos López Nozal
 * @author José Antonio Barbero Aparicio
 * @author José Redondo Guerra
 * @author Rodrigo Merino Tovar
 * 
 * @version 1.0
 * @since 1.0
 */
public class SistemaLanzador {
	
	/**
	 * main().
	 * 
	 * @param args Entrada por línea de comandos (asumiremos que args[0]==2)
	 */
	public static void main(String[] args) {
		
		IParque parque = new Parque(); // TODO
		char letra_puerta = 'A';
		
		System.out.println("¡Parque abierto!");
		
		// Asumiremos que serán 2 puertas, i.e., Integer.parseInt(args[0])==2
		// (se pasa '2' como argumento al main())
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			
			String puerta = ""+((char) (letra_puerta++));
			
			// Creación de hilos de entrada
			ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
			new Thread (entradas).start();
			
			// Creación de hilos de salida
			ActividadSalidaPuerta salidas = new ActividadSalidaPuerta(puerta, parque);
			new Thread (salidas).start();
			
			
		}
	}	
}