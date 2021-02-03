
public class ControladorDinero {
	
	private boolean b = false;
	
	public synchronized void esperar(int dinero) {
		
		while(!b) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("TOTAL: "+dinero);
	}
	
	public synchronized void continuar() {
		
		b = true;
		notifyAll();
		
	}

}
