package ejercicio2;

public class Hilo2 implements Runnable {

	Thread t;

	Hilo2() {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
	}

	@Override
	public void run() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

		System.out.println("Hola soy el thread numero 2");

	}
}
