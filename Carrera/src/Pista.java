
public class Pista {
	
	private boolean disparo = false;
	
	private void corredorTestigo(int numero, int ultimo) {
		
		if(numero==ultimo) {
			
			System.out.println("Corredor "+numero+" corriendo");
			System.out.println("Todos los corredores han terminado");
			System.out.println("Carrera terminada");
			
		}
		
		else {
			
			System.out.println("Corredor "+numero+" corriendo");
			System.out.println("Pasa el testigo a "+(numero+1));
			
		}
		
	}
	
	public synchronized void salida(int numero, int ultimo) {
		
		while(!disparo) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		disparo = true;
		corredorTestigo(numero, ultimo);
		notify();
		
		
	}
	
	public synchronized void correr() {
		
		disparo = true;
		notify();
		
	}

}
