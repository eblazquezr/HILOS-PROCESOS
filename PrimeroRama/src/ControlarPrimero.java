
public class ControlarPrimero {
	
	private boolean controlar;
	
	public synchronized void par(int numero) {
		
		while(!controlar) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Hola, soy el thread "+numero);
		controlar = true;
		notify();
		
		
	}
	
	public void comprobar(int numero) {
		if(numero%2==0) {
			controlar = true;
			
		}
		else {
			controlar = false;
		}

	}


}
