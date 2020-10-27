package ejercicio2;

public class Orden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilo1 h1 = new Hilo1();
		Hilo2 h2 = new Hilo2();
		h1.t.setPriority(1);
		h2.t.setPriority(10);
		
		h1.t.start();
		h2.t.start();
		
	}

}
