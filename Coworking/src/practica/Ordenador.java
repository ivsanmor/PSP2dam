package practica;

public class Ordenador {

	private boolean ocupado;

	public Ordenador() {
		this.ocupado = false;
	}

	public void entrarOrdenador(int idPersona) throws InterruptedException {
		synchronized (this) {
			while (this.ocupado) {
				this.wait();
			}
			Mesa.showMessage("La persona "+idPersona+" entra al ordenador");
			setOcupado(true);
		}
	}
	
	public void dejarOrdenador(int idPersona) {
		synchronized(this) {
			Mesa.showMessage("La persona "+idPersona+" sale del ordenador");
			setOcupado(false);
			this.notifyAll();
		}
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}
