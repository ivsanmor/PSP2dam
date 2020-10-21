package sistemaVideoclub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;

import com.sun.source.tree.WhileLoopTree;

public class SistemaVideoClub {

	

	public static void main(String[] args) throws IOException {
	
		String input;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine();

		while((input = br.readLine()) != null && (input = br.readLine()) != "final") {
			System.out.println("Hola");
		}
	}

}
