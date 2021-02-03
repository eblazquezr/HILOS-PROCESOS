
public class ControlarRelevos {
	
	private boolean disparo = false;
	
	
	public synchronized void esperar(int numero,int total) {
				
		while(!disparo) {
			try {
				
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Soy "+(numero+1)+" estoy corriendo");
		
		if((numero+1)==total) {
			System.out.println("Termine");
			System.out.println("Hemos terminado");
		}
		else {
			System.out.println("Termine, Paso el testigo a "+(numero+2));
			disparo = true;
			notify();
		}
	
	}
	
	
	public synchronized void empezar() {
		
		disparo = true;
		notify();

		
	}
	


}
