package ejercicio2;

public class Hilo2 implements Runnable {

	Thread t;
	
	Hilo2 () {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hola,soy el thread número 2");
		
	}
}

