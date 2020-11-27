package practica;

import java.util.Random;

public class Persona implements Runnable {

	Thread t;
	private int idPersona;
	private Tarjeta tDer;
	private Tarjeta tIzq;
	private Ordenador ordena;
	private Random rnd;

	public Persona(int idPersona, Tarjeta tIzq, Tarjeta tDer, Ordenador ordena) {
		this.idPersona = idPersona;
		this.tIzq = tIzq;
		this.tDer = tDer;
		this.ordena = ordena;
		this.rnd = new Random();
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {

		Mesa.showMessage("Persona " + idPersona + " sentandose a la mesa");

		try {
			Mesa.showMessage("Persona " + idPersona + " se pone a pensar");
			Thread.sleep(rnd.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			cogerTarjetas();
			ordena.entrarOrdenador(idPersona);
			Thread.sleep(rnd.nextInt(500));

			ordena.dejarOrdenador(idPersona);
			dejarTarjetas();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void cogerTarjetas() throws InterruptedException {
		boolean tarIzqCog = false;
		boolean tarDerCog = false;
		while (!tarIzqCog || !tarDerCog) {
			if (!tIzq.isOcupada()) {
				tarIzqCog = tIzq.cogerTarjeta();
				tarDerCog = tDer.cogerTarjeta();
			} else {
				tarDerCog = tDer.cogerTarjeta();
				tarIzqCog = tIzq.cogerTarjeta();
			}

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
	
	private void dejarTarjetas() {
		Mesa.showMessage("La persona " + idPersona + " deja las dos tarjetas");
		tIzq.dejarTarjeta();
		tDer.dejarTarjeta();
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public Tarjeta gettDer() {
		return tDer;
	}

	public void settDer(Tarjeta tDer) {
		this.tDer = tDer;
	}

	public Tarjeta gettIzq() {
		return tIzq;
	}

	public void settIzq(Tarjeta tIzq) {
		this.tIzq = tIzq;
	}

}
