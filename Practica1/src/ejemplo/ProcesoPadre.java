package ejemplo;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// TODO: Auto-generated Javadoc
/**
 * The Class TestProcessIO.
 */
public class ProcesoPadre {

	/**
	 * Comprueba si el proceso esta activo
	 *
	 * @param p el proceso
	 * @return true, si esta activo
	 */
	public static boolean isAlive(Process p) {
		//si el proceso hijo ha terminado devuelve falso, si no ha terminado lanza una excepci�n y devuelve true
		try {
			p.exitValue(); 
			return false;
		}
		catch (IllegalThreadStateException e) {
			return true;
		}
	}
	
	/**
	 * Run process.
	 * Es el metodo que compil�a el proceso hijo
	 *
	 * @param command el proceso hijo
	 * @throws InterruptedException the interrupted exception
	 */
	private static void runProcess(String command) throws InterruptedException{
		Process pro;
		try {
			pro = Runtime.getRuntime().exec(command);
			pro.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * El metodo principal en el que se establece la comunicacion con el proceso hijo 
	 *
	 * @param args los argumentos
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		runProcess("javac -cp src src/sistemaVideoclub/SistemaVideoClub.java");
        Process process = Runtime.getRuntime().exec("java -cp src sistemaVideoclub/SistemaVideoClub");
		InputStream out = process.getInputStream(); //configuramos la salida del proceso hijo
		OutputStream in = process.getOutputStream(); //configuramos la entrada del proceso hijo

		byte[] buffer = new byte[4000]; //buffer de comunicaci�n entre procesos
		while (isAlive(process)) {
			//se comprueba el stream de salida del proceso hijo
			int no = out.available();
			if (no > 0) {
				//si el stream de salida del proceso hijo tiene informaci�n se muestra por pantalla
				int n = out.read(buffer, 0, Math.min(no, buffer.length));
				System.out.println(new String(buffer, 0, n));
			}

			//se comprueba si hay informaci�n para enviar al proceso hijo
			int ni = System.in.available();
			if (ni > 0) {
				//si existe informaci�n se env�a al proceso hijo
				int n = System.in.read(buffer, 0, Math.min(ni, buffer.length));
				in.write(buffer, 0, n);
				in.flush();
			}

			try {
				Thread.sleep(10); //se introduce un retardo de 10 milisegundos
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

		System.out.println(process.exitValue());
	}
}