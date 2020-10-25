package sistemavideoclub;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * La Clase SistemaVideoClub.
 */
public class SistemaVideoClub {
	
	/** El ArrayList en el que se guardan todas las peliculas del videoclub */
	private static ArrayList<String> peliculas;
	
	/**
	 * El metodo principal en el que se desarrolla la aplicacion, se interactua con el cliente pidiendole los datos para acabar
	 * seleccionando su pelicula.
	 *
	 * @param args los argumentos
	 */
	public static void main(String[] args) {

		String entrada = "";
		boolean fin = false;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		peliculas = implementaPeliculas();

		try {
			do {
				System.out.println("Bienvenido al video club de bajo presupuesto, pulse una tecla para continuar");
				entrada = br.readLine();
				System.out.println("Elija un género de película de los siguientes: Acción, Comedia, Terror y Drama");
				entrada = br.readLine();
				while (!generoPelicula(entrada)) {
					System.out.println("Lo siento, no tenemos películas de ese género");
					entrada = br.readLine();
				}
				String entradaMin = entrada.toLowerCase();
				switch (entradaMin) {
				case "acción":
					System.out.println("Ha elegido acción, ahora le toca elegir la película entre las siguientes: \n Los mercenarios \n Rambo \n Terminator \n Transporter");
					break;
				case "comedia":
					System.out.println("Ha elegido comedia, ahora le toca elegir la película entre las siguientes: \n Los padres de ella \n American Pie \n Zombieland \n El dictador");
					break;
				case "terror":
					System.out.println("Ha elegido terror, ahora le toca elegir la película entre las siguientes: \n Saw \n La matanza de Texas \n La autopsia de Jane Doe \n Pesadilla en Elm Street");
					break;
				case "drama":
					System.out.println("Ha elegido drama, ahora le toca elegir la película entre las siguientes: \n Lo imposible \n La ola \n Joker \n El diario de Noa");
					break;
				default:
					System.out.println("No ha elegido una de las disponibles.");
					break;
				}
				entrada = br.readLine();
				while (!encuentraPelicula(entrada)) {
					System.out.println("Elija una película que tengamos en el almacén de la lista de arriba.");
					entrada = br.readLine();
				}
				
				System.out.println("Elija el día para recoger la película en el siguiente formato: dd/mm/aaaa");
				entrada = br.readLine();
				while (!validaFecha(entrada)) {
					System.out.println("Fecha no válida, bien sea por formato o porque ya ha pasado.");
					entrada = br.readLine();
				}
				System.out.println("¿Durante cuántos días lo alguilara?");
				entrada = br.readLine();
				while (!esNumero(entrada)) {
					System.out.println("Por favor, introduzca un número de días válido");
					entrada = br.readLine();
				}
				System.out.println("Su película ha sido alquilada correctamente, ¿desea hacer algun otro alquiler?");
				entrada = br.readLine();
				while (!entrada.equalsIgnoreCase("si") && !entrada.equalsIgnoreCase("no")) {
					System.out.println("Por favor, ¿sí o no?");
					entrada = br.readLine();
				}
				if (entrada.equalsIgnoreCase("si")) {
					fin = false;
				} else {
					fin = true;
				}

			} while (!fin);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Valida fecha.
	 * Es el metodo en el que se valida el formato de la fecha y que sea posterior a la de hoy, para hacer las reservas practicas
	 *
	 * @param fecha el string de la fecha a alquilar
	 * @return true, si la fecha es valida
	 */
	public static boolean validaFecha(String fecha) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			sdf.parse(fecha);
			Date fechaHoy = new Date();
			if (fechaHoy.after(sdf.parse(fecha))) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * Es numero.
	 * Es el metodo en el que se valida que sea un numero la cadena.
	 *
	 * @param cadena la cadena String que escribe el cliente
	 * @return true, si es numero
	 */
	private static boolean esNumero(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Genero pelicula.
	 * Es el metodo en el que se valida si el genero de peliculas esta en la base de datos del videoclub
	 *
	 * @param gen el genero escrito por el cliente
	 * @return true, si tenemos el genero correspondiente
	 */
	private static boolean generoPelicula(String gen) {
		return gen.equalsIgnoreCase("acción") || gen.equalsIgnoreCase("comedia") || gen.equalsIgnoreCase("terror") || gen.equalsIgnoreCase("drama");
	}
	
	/**
	 * Implementa peliculas.
	 * Es el metodo en el que se cargan todas las peliculas que tenemos a un arraylist simulando una base de datos
	 *
	 * @return el arraylist con todas las peliculas
	 */
	private static ArrayList<String> implementaPeliculas() {
	ArrayList<String> peliculas = new ArrayList<>();
	peliculas.add("los mercenarios");
	peliculas.add("rambo");
	peliculas.add("terminator");
	peliculas.add("transporter");
	peliculas.add("los padres de ella");
	peliculas.add("american pie");
	peliculas.add("zombieland");
	peliculas.add("el dictador");
	peliculas.add("saw");
	peliculas.add("la matanza de texas");
	peliculas.add("la autopsia de jane doe");
	peliculas.add("pesadilla en elm street");
	peliculas.add("lo imposible");
	peliculas.add("la ola");
	peliculas.add("joker");
	peliculas.add("el diario de noa");
		return peliculas;
	}
	
	/**
	 * Encuentra pelicula.
	 * Es el metodo en el que se valida si tenemos la pelicula que escribe el cliente
	 *
	 * @param pel la pelicula
	 * @return true, si tenemos la pelicula escrita por el cliente
	 */
	private static boolean encuentraPelicula(String pel) {
		String pelMin = pel.toLowerCase();
		return peliculas.contains(pelMin);
	}

}
