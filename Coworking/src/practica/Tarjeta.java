package practica;


/**
 * Clase Tarjeta
 */
public class Tarjeta {
	
	/** El id de la tarjeta */
	private int idTarjeta;
	
	/** El boolean que dicta si esta ocupada o no la tarjeta */
	private boolean ocupada;
	


	/**
	 * Metodo constructor .
	 *
	 * @param idTarjeta el id de la tarjeta
	 */
	public Tarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
		this.ocupada = false;
	}
	
	/**
	 * Metodo en el que se coge la tarjeta
	 *
	 * @return true, si la coge
	 * @throws InterruptedException the interrupted exception
	 */
	public boolean cogerTarjeta() throws InterruptedException {
		synchronized(this) {
			while(this.ocupada) {
				this.wait(500);
				if(this.ocupada) {
					return false;
				}
			}
			this.setOcupada(true);
			return true;
		}
	}
	
	/**
	 * Metodo en el que suelta la tarjeta 
	 */
	public void dejarTarjeta() {
		synchronized(this) {
			this.setOcupada(false);
			this.notifyAll();
		}
	}
	
	/**
	 * Gets the id tarjeta.
	 *
	 * @return the id tarjeta
	 */
	public int getIdTarjeta() {
		return idTarjeta;
	}

	/**
	 * Sets the id tarjeta.
	 *
	 * @param idTarjeta the new id tarjeta
	 */
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	/**
	 * Checks if is ocupada.
	 *
	 * @return true, if is ocupada
	 */
	public boolean isOcupada() {
		return ocupada;
	}

	/**
	 * Sets the ocupada.
	 *
	 * @param ocupada the new ocupada
	 */
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

}
