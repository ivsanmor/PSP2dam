package ejercicio6;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CuentaVocales [] hilos;
		char [] vocales = {'a','e','i','o','u'};
		hilos = new CuentaVocales[vocales.length];
		for (int i = 0; i < vocales.length; i++) {
			hilos[i] = new CuentaVocales(vocales[i]);
			hilos[i].run();
		}
		for (int i = 0; i < hilos.length; i++) {
			hilos[i].join();
		}
		
		System.out.println(ContadorGlobal.totalVocales);
	}

}
