package src.p03.c01;

/**
 * Interfaz que representa las dos funciones principales del objeto pasivo
 * y recurso compartido Parque. 
 * 
 * @author Carlos López Nozal
 * @author José Antonio Barbero Aparicio
 * @author José Redondo Guerra
 * @author Rodrigo Merino Tovar
 * 
 * @version 1.0
 * @since 1.0
 */
public interface IParque {
	
	/**
	 * Método abstracto para indicar que se entra por una puerta. 
	 * 
	 * @param puerta Puerta por la que se entra.
	 */
	public abstract void entrarAlParque(String puerta);

	/**
	 * Método abstracto para indicar que se sale por una puerta. 
	 * 
	 * @param puerta Puerta por la que se sale.
	 */
	public abstract void salirDelParque(String puerta);

}