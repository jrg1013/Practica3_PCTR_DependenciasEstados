package src.p03.c01;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Objeto pasivo que será el recurso compartido por las diferentes
 * actividades. 
 * 
 * @author Carlos López Nozal
 * @author José Antonio Barbero Aparicio
 * @author José Redondo Guerra
 * @author Rodrigo Merino Tovar
 * 
 * @version 1.0
 * @since 1.0
*/
public class Parque implements IParque{


	// TODO 
	private int contadorPersonasTotales;
	private Hashtable<String, Integer> contadoresPersonasPuerta;
	
	
	public Parque() {	// TODO
		contadorPersonasTotales = 0;
		contadoresPersonasPuerta = new Hashtable<String, Integer>();
		// TODO
	}


	@Override
	public void entrarAlParque(String puerta){		// TODO
		
		// Si no hay entradas por esa puerta, inicializamos
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO
				
		
		// Aumentamos el contador total y el individual
		contadorPersonasTotales++;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)+1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Entrada");
		
		// TODO
		
		
		// TODO
		
	}
	
	
	@Override
	public synchronized void salirDelParque(String puerta) {
		if (contadoresPersonasPuerta.get(puerta) == null){
			contadoresPersonasPuerta.put(puerta, 0);
		}
		
		// TODO
				
		
		// Decrementamos el contador total y el individual
		contadorPersonasTotales--;		
		contadoresPersonasPuerta.put(puerta, contadoresPersonasPuerta.get(puerta)-1);
		
		// Imprimimos el estado del parque
		imprimirInfo(puerta, "Salida");
		
	}
	
	
	/**
	 * Mostrar por pantalla los estados del parque y las diferentes puertas.
	 * 
	 * @param puerta Nombre de la puerta por la que se entra o se sale.
	 * @param movimiento Nombre del movimiento que se realiza (entrar o salir)
	 */
	private void imprimirInfo (String puerta, String movimiento){
		System.out.println(movimiento + " por puerta " + puerta);
		System.out.println("--> Personas en el parque " + contadorPersonasTotales); //+ " tiempo medio de estancia: "  + tmedio);
		
		// Iteramos por todas las puertas e imprimimos sus entradas
		for(String p: contadoresPersonasPuerta.keySet()){
			System.out.println("----> Por puerta " + p + " " + contadoresPersonasPuerta.get(p));
		}
		System.out.println(" ");
	}
	
	
	/**
	 * Sumar los contadores de todas las puertas. 
	 * 
	 * @return sumaContadoresPuerta Suma de los contadores de todas las puertas.
	 */
	private int sumarContadoresPuerta() {
		int sumaContadoresPuerta = 0;
			Enumeration<Integer> iterPuertas = contadoresPersonasPuerta.elements();
			while (iterPuertas.hasMoreElements()) {
				sumaContadoresPuerta += iterPuertas.nextElement();
			}
		return sumaContadoresPuerta;
	}
	
	
	/**
	 * Comprobación de invariantes.
	 */
	protected void checkInvariante() {
		assert sumarContadoresPuerta() == contadorPersonasTotales : "INV: La suma de contadores de las puertas debe ser igual al valor del contador del parque";
		
		assert sumarContadoresPuerta() >= 0: "INV: La suma de personas en el parque no puede ser negativa.";
		
		for(Entry<String, Integer> e: contadoresPersonasPuerta.entrySet()) {
			assert e.getValue() >= 0 : "INV: No pueden haber salido más personas de las que han entrado por una puerta."; 
		}
		
		// PODRÍAMOS LIMITAR EL AFORO DEL PARQUE Y TENERLO EN CUENTA COMO UN INVARIANTE ADICIONAL.
	}
	

	protected void comprobarAntesDeEntrar(){	// TODO
		//
		// TODO
		//
	}


	protected void comprobarAntesDeSalir(){		// TODO
		//
		// TODO
		//
	}


}
