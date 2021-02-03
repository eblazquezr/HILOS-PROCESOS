
public class Estacion {
	
	private boolean bandera = true;
	
	public synchronized void entrar(int entero) {
		
		while(!bandera) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Entra tren "+entero);
		bandera = false;
	}
	
	public synchronized void salir(int entero) {
		
		System.out.println("Sale tren "+entero);
		bandera = true;
		notifyAll();
		
	}

}
