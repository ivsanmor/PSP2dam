package ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] command) {
		// TODO Auto-generated method stub
		String line;
		ProcessBuilder pb = new ProcessBuilder(command);
		Scanner tec = new Scanner(System.in);
		String txt = null;
		pb.redirectErrorStream(true);
		try {
			txt = tec.nextLine();
			while (!txt.equalsIgnoreCase("fin")) {
				Process shell = pb.start();
				InputStream is = shell.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "Cp850"));
				System.out.println("La salida del proceso hijo :");

				
				while ((line = br.readLine()) != null) {
					System.out.println(line);

				}
				txt = tec.nextLine();
				is.close();
			}

		} catch (IOException e) {
			System.out.println("Error ocurrió ejecutando el comando. Descripción: " + e.getMessage());
		}
	}

}
