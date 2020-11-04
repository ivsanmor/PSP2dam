package pruebaclase;

public class TwoMutex extends Thread{
	private Object mutex1=new Object();
	private Object mutex2=new Object();
	
	public void inc1() {
		synchronized (mutex1) {
			for (int i = 0; i<1000; i++)
				GlobalVar.c1++;
		}
	}
	
	public void inc2() {
		synchronized (mutex2) {
			for (int i = 0; i<1000; i++)
				GlobalVar.c2++;
		}
	}
	
	@Override
	public void run() {
		inc1();
		inc2();
	}
}
