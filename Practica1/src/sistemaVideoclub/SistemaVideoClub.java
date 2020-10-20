package sistemaVideoclub;

import java.util.Scanner;

public class SistemaVideoClub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String respuesta=null;
		boolean fin=false;
		
		System.out.println("Bienvenido a la central de alquiler. ¿Cómo puedo ayudarle?");
		
		while (!fin) {
			if (respuesta.contentEquals("alquilar pelicula")) {
				System.out.println("Elija una de las categorías posibles: Comedia, Drama, Documental, Acción o Terror");
			} else if (respuesta.contentEquals("Comedia") || respuesta.contentEquals("Drama"))  {
				System.out.println("Indique fecha de alquiler");
			} 
			
		}
	}

}
