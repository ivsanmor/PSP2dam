package practica;


/**
 * Clase Ordenador
 */
public class Ordenador {

	/** Booleano que dicta si esta ocupado o no el ordenador */
	private boolean ocupado;

	/**
	 * Constructor
	 */
	public Ordenador() {
		this.ocupado = false;
	}

	/**
	 * Metodo para entrar en el ordenador, en el que una persona lo ocupa ponieno a verdadero
	 * el booleano ocupado
	 *
	 * @param idPersona el id de la persona que lo ocupa
	 * @throws InterruptedException the interrupted exception
	 */
	public void entrarOrdenador(int idPersona) throws InterruptedException {
		synchronized (this) {
			while (this.ocupado) {
				this.wait();
			}
			Mesa.showMessage("La persona "+idPersona+" entra al ordenador");
			setOcupado(true);
		}
	}
	
	/**
	 * Metodo por el que una persona deja libre el ordenador
	 *
	 * @param idPersona the el id de la persona que lo deja libre
	 */
	public void dejarOrdenador(int idPersona) {
		synchronized(this) {
			Mesa.showMessage("La persona "+idPersona+" sale del ordenador");
			setOcupado(false);
			this.notifyAll();
		}
	}

	/**
	 * Comprueba si esta ocupado
	 *
	 * @return true, si lo esta
	 */
	public boolean isOcupado() {
		return ocupado;
	}

	/**
	 * Da valor al ocupado
	 *
	 * @param ocupado el nuevo valor de ocupado
	 */
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}
