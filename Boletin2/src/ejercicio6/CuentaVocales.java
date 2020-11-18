package ejercicio6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuentaVocales extends Thread {

	private char vocal;
	private FileWriter fw;
	private ContadorGlobal var;
	private BufferedReader br;
	private FileReader fr;

	public CuentaVocales(char vocal) {
		this.vocal = vocal;
		File f = new File("./src/archivo.txt");
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(fr);
	}

	@Override
	public void run() {
		leeArchivo();

	}

	private void leeArchivo() {
		String linea;
		try {
			while ((linea = br.readLine()) != null) {
				for (int i = 0; i < linea.length(); i++) {
					if (linea.charAt(i) == this.vocal) {
						sumaVocal();
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private synchronized void sumaVocal() {
		ContadorGlobal.totalVocales++;
	}

}

