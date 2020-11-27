package practica;

public class Tarjeta {
	
	private int idTarjeta;
	private boolean ocupada;
	


	public Tarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
		this.ocupada = false;
	}
	
	public boolean cogerTarjeta() throws InterruptedException {
		synchronized(this) {
			while(this.ocupada) {
				this.wait(500);
				if(this.ocupada) {
					return false;
				}
			}
			this.setOcupada(true);
			return true;
		}
	}
	
	public void dejarTarjeta() {
		synchronized(this) {
			this.setOcupada(false);
			this.notifyAll();
		}
	}
	
	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

}
