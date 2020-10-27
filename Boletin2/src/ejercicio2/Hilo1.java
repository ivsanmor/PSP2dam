package ejercicio2;

public class Hilo1 implements Runnable {

	Thread t;

	Hilo1() {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}

		System.out.println("Hola soy el thread numero 1");

	}
}
