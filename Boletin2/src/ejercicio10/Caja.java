package ejercicio10;


public class Caja {
	private int num;
	
	public Caja(int num) {
		this.num=num;
	}
	
	public int getNum() {
		return num;
	}
	
	public synchronized void factura(double cantidad) {
		System.out.println("La caja " + num + " factura " + cantidad + " €");
		Resultado.resultado+=cantidad;
	}
}
