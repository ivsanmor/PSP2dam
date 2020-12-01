package practica;

import java.util.Random;


/**
 * Clase Persona
 */
public class Persona implements Runnable {

	/** El hilo */
	Thread t;

	/** El id de la persona */
	private int idPersona;

	/** La tarjeta a la derecha de la persona. */
	private Tarjeta tDer;

	/** La tarjeta a la izquierda de la persona */
	private Tarjeta tIzq;

	/** El ordenador que va a usar */
	private Ordenador ordena;

	/** Numero aleatorio para el sleep */
	private Random rnd;

	/**
	 * Metodo constructor
	 *
	 * @param idPersona El id de la persona
	 * @param tIzq      La tarjeta a la izquierda
	 * @param tDer      La tarjeta a la derecha
	 * @param ordena    El ordenador
	 */
	public Persona(int idPersona, Tarjeta tIzq, Tarjeta tDer, Ordenador ordena) {
		this.idPersona = idPersona;
		this.tIzq = tIzq;
		this.tDer = tDer;
		this.ordena = ordena;
		this.rnd = new Random();
		t = new Thread(this);
		t.start();
	}

	/**
	 * Metodo run del hilo
	 */
	@Override
	public void run() {

		Mesa.showMessage("Persona " + idPersona + " sentandose a la mesa");

		try {
			Mesa.showMessage("Persona " + idPersona + " se pone a pensar");
			Thread.sleep(rnd.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		try {
			cogerTarjetas();
			ordena.entrarOrdenador(idPersona);
			Thread.sleep(rnd.nextInt(500));

			ordena.dejarOrdenador(idPersona);
			dejarTarjetas();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

	}

	/**
	 * Metodo en el que la persona coge las tarjetas, ocupando cada un
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	private void cogerTarjetas() throws InterruptedException {
		boolean tarIzqCog = false;
		boolean tarDerCog = false;
		while (!(tarIzqCog && tarDerCog)) {

			tarIzqCog = tIzq.cogerTarjeta();
			tarDerCog = tDer.cogerTarjeta();

			if (tarIzqCog && !tarDerCog) {
				tarDerCog = tDer.cogerTarjeta();
				if (!tarDerCog) {
					tIzq.dejarTarjeta();
					tarIzqCog = false;
				}
			} else if (tarDerCog && !tarIzqCog) {
				tarIzqCog = tIzq.cogerTarjeta();
				if (!tarIzqCog) {
					tDer.dejarTarjeta();
					tarDerCog = false;
				}
			}
		}
		Mesa.showMessage("La persona " + idPersona + " ha conseguido las dos Tarjetas");
	}

	/**
	 * Dejar tarjetas.
	 */
	private void dejarTarjetas() {
		Mesa.showMessage("La persona " + idPersona + " deja las dos tarjetas");
		tIzq.dejarTarjeta();
		tDer.dejarTarjeta();
	}

	/**
	 * Gets the id persona.
	 *
	 * @return the id persona
	 */
	public int getIdPersona() {
		return idPersona;
	}

	/**
	 * Sets the id persona.
	 *
	 * @param idPersona the new id persona
	 */
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * Gets the t der.
	 *
	 * @return the t der
	 */
	public Tarjeta gettDer() {
		return tDer;
	}

	/**
	 * Sets the t der.
	 *
	 * @param tDer the new t der
	 */
	public void settDer(Tarjeta tDer) {
		this.tDer = tDer;
	}

	/**
	 * Gets the t izq.
	 *
	 * @return the t izq
	 */
	public Tarjeta gettIzq() {
		return tIzq;
	}

	/**
	 * Sets the t izq.
	 *
	 * @param tIzq the new t izq
	 */
	public void settIzq(Tarjeta tIzq) {
		this.tIzq = tIzq;
	}

}
