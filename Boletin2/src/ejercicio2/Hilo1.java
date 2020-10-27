package ejercicio2;

public class Hilo1 implements Runnable {

	Thread t;
	
	Hilo1 () {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hola soy el thread numero 1");
		
	}
}
