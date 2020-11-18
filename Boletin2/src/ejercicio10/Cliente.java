package ejercicio10;


public class Cliente extends Thread{
	String nombre;

	public Cliente(String nombre) {
		this.nombre=nombre;
	}
	
	public void run() {
		System.out.println("Entra en el supermercado el cliente " + nombre);
		int rnd=(int)(Math.random()*1000);
		try {
			System.out.println(nombre+ " pasa " + rnd + " milisegundos comprando");
			Thread.sleep(rnd);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		escogeCaja(SuperMarket.seleccionaCaja());
			
	}
	
	private synchronized void escogeCaja(Caja c) {
		
		int pago = (int)(Math.random()*100);
		
		System.out.println("El cliente "+nombre+ " escoge la caja " + (c.getNum()));
		
		c.factura(pago);
	}

}
