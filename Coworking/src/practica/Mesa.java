package practica;


/**
 * Clase mesa 
 */
public class Mesa {

	/**
	 * Metodo Main
	 *
	 * @param args los argumentos
	 */
	public static void main(String[] args) {
		
		Tarjeta [] tarjetas = new Tarjeta[5];
		Persona [] personas = new Persona[5];
		Ordenador pc = new Ordenador();
		
		for (int i = 0; i < tarjetas.length; i++) {
			tarjetas[i] = new Tarjeta(i);
		}
		
		for (int i = 0; i < personas.length-1; i++) {
			personas[i] = new Persona(i, tarjetas[i], tarjetas[i+1], pc);
		}
		personas[4] = new Persona (4, tarjetas[4], tarjetas[0], pc);
		
		
		
	}
	
	/**
	 * Metodo para sincronizar los system.out
	 *
	 * @param s el texto 
	 */
	public static synchronized void showMessage(String s) {
		System.out.println(s);
	}

}
