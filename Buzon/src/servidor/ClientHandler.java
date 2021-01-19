package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import archivador.Buzon;


/**
 * Clase ClientHandler.
 */
public class ClientHandler extends Thread {
	
	/** El DataInputStream */
	private final DataInputStream dis;
	
	/** El DataOutputStream */
	private final DataOutputStream dos;
	
	/** El socket */
	private final Socket s;
	
	/** El usuario */
	private String usu;
	
	/** El buzon */
	private Buzon buzon;

	
	/**
	 * Constructor
	 *
	 * @param s the s
	 * @param dis el DataInputStream
	 * @param dos el DataOutputStream
	 * @param buzon el Buzon
	 */
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, Buzon buzon) {
		this.s = s;
		this.dis = dis;
		this.dos = dos;
		this.buzon = buzon;
	}

	/**
	 * El metodo run 
	 */
	@Override
	public void run() {
		boolean exit = false;
		String received;
		String toReturn = null;
		try {
			dos.writeUTF("Introduzca nombre de usuario");
			this.usu = this.dis.readUTF();
			dos.writeUTF("Bienvenido " + this.usu + "\n");
			dos.flush();
			while (!exit) {
				mostrarMenu();
				received = dis.readUTF();
				opciones(received, toReturn, exit);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			
			this.dis.close();
			this.dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mostrar menu.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void mostrarMenu() throws IOException {
		dos.writeUTF("Selecciona una opcion");
		dos.writeUTF("-------------------");
		dos.writeUTF("(1) Leer correos");
		dos.writeUTF("(2) Escribir correo");
		dos.writeUTF("(3) Salir");
		dos.flush();
	}
	
	/**
	 * Opciones. Metodo hecho para claridad del codigo en el que se eligen
	 * las opciones mostradas por pantalla por el mostrarMenu
	 *
	 *
	 * @param received el string recibido
	 * @param toReturn el string que devuelve
	 * @param exit el booleano para saber cuando salir
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void opciones(String received, String toReturn, boolean exit) throws IOException {
		switch (received) {
		case "1":
			ArrayList<String> msg = buzon.verCorreos(usu);
			if (msg == null) {
				toReturn = "No hay ningún mensaje\n";
				dos.writeUTF(toReturn);
			} else {
				for (int i = 0; i < msg.size(); i++) {
					dos.writeUTF(msg.get(i));
					dos.flush();
				}
				buzon.borrarCorreos(usu);
			}
			break;
		case "2":
			toReturn = "Elija destinatario";
			dos.writeUTF(toReturn);
			String destin = dis.readUTF();
			toReturn = "Escriba el correo a continuacion";
			dos.writeUTF(toReturn);
			String mensaje = dis.readUTF();
			if (destin.equals(usu)) {
				mensaje += " --- De: ti mismo";
			} else {
				mensaje += " --- De: " + usu;
			}
			buzon.enviarCorreo(destin, mensaje);
			toReturn = "Correo enviado\n";
			dos.writeUTF(toReturn);
			break;
		case "3":
			System.out.println("El cliente " + this.s + " se dispone a salir...");
			this.s.close();
			System.out.println("Conexion cerrada");
			exit = true;
			break;
		default:
			toReturn = "Escoja una opcion valida";
			dos.writeUTF(toReturn);
			break;
		}
	}
}
