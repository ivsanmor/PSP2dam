package archivador;

import java.util.ArrayList;


/**
 * Clase Buzon.
 */
public class Buzon {

	/** El hashmap de los correos. */
	private DuplicateMap<String, String> correos;

	/**
	 * Constructor.
	 */
	public Buzon() {
		this.correos = new DuplicateMap<>();
	}

	/**
	 * Enviar correo.
	 *
	 * @param usu el usuario
	 * @param mensaje el contenido del mismo
	 */
	public synchronized void enviarCorreo(String usu, String mensaje) {
		correos.put(usu, mensaje);
	}

	/**
	 * Ver mensajes.
	 *
	 * @param usu el usuario
	 * @return el array list de los correos
	 */
	public synchronized ArrayList<String> verCorreos(String usu) {
		return correos.get(usu);
	}

	/**
	 * Borrar correos.
	 *
	 * @param usu el usuario
	 */
	public synchronized void borrarCorreos(String usu) {
		correos.remove(usu);
	}
	
	/**
	 * Devuelve los correos
	 *
	 * @return the los correos
	 */
	public DuplicateMap<String, String> getCorreos() {
		return correos;
	}

	/**
	 * Asigna los correos
	 *
	 * @param correos los correos
	 */
	public void setCorreos(DuplicateMap<String, String> correos) {
		this.correos = correos;
	}

}
