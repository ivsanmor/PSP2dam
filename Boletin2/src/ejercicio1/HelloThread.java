package ejercicio1;

public class HelloThread implements Runnable {
	
	Thread t;
	private int n;
	
	HelloThread (int n){
		t = new Thread(this, "Nuevo thread");
		this.n=n;
		System.out.println("Creado hilo: " + t);
		t.start(); //arranca el nuevo hilo de ejecuci�n y ejecuta el m�todo run
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hola dede el hilo creado");
		for (int i = 1; i <= this.n; i++) {
			System.out.println(fibonacci(i));
		}
		System.out.println("Hilo finalizando");
		
		
	}
	
	private int fibonacci(int n) {
	    if (n>1){
	       return  fibonacci(n-1) + fibonacci(n-2);  //funci�n recursiva
	    }
	    else if (n==1) {  // caso base
	        return 1;
	    } else if (n==0){  // caso base
	        return 0;
	    }else{ //error
	        System.out.println("Debes ingresar un tama�o mayor o igual a 1");
	        return -1; 
	    }
	}
}
