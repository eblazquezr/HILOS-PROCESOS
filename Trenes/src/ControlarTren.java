
public class ControlarTren {
	
	private boolean bandera = true;
	
	public synchronized void entrada(int numero) {
		
		while(!bandera) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Entra el tren "+numero);
		bandera = false;
		notifyAll();
	}
	
	
	public synchronized void salida(int numero) {
		
		System.out.println("Sale el tren "+numero);		
		bandera = true;
		notifyAll();
		
	}
	

}
