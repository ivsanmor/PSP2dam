package ejercicio10;

import java.util.ArrayList;

public class SuperMarket {
	static ArrayList<Caja> cajas = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Cliente> clientes = new ArrayList<>();
		int numCajas=Integer.parseInt(args[0]);
		int numClientes=Integer.parseInt(args[1]);
		
		for (int i = 0; i < numCajas; i++) {
			Caja c = new Caja (i+1);
			cajas.add(c);
		}
		
		for (int i = 0; i < numClientes; i++) {
			Cliente cl = new Cliente("Cliente "+(i+1));
			clientes.add(cl);
		}
		
		for (Cliente c : clientes) {
			c.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Resultado.resultado + "€ recaudados totales");
	}
	
	public static Caja seleccionaCaja() {
		int rnd = (int)(Math.random()*cajas.size());
		return cajas.get(rnd);
	}

}

