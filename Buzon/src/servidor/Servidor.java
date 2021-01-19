package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import archivador.Buzon;


/**
 * Clase Servidor.
 */
public class Servidor {

	/**
	 * El metodo main en el que se instancia el servidor de correos
	 *
	 * @param args los argumentos
	 */
	public static void main(String[] args) {
		try {
			Buzon buzon = new Buzon();
			ServerSocket server = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			server.bind(addr);
			while (true) {
				Socket s = null;
				try {

					s = server.accept();
					System.out.println("Cliente conectado: " + s);

					DataInputStream dis = new DataInputStream(s.getInputStream());
					DataOutputStream dos = new DataOutputStream(s.getOutputStream());
					System.out.println("Asignando nuevo hilo para el cliente");

					Thread t = new ClientHandler(s, dis, dos, buzon);
					t.start();
					System.out.println("Hilo creado");
				} finally {
					if (s == null) {
						s.close();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
