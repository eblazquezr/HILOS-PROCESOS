
public class ControlarNotas {
	
	private boolean esperar = false;
	
	public synchronized void alumnos(int numero) throws InterruptedException {
		
		while(!esperar) {
			
			wait();
			
		}
		System.out.println("Alumno "+numero+" recibe la nota");
		notifyAll();
	}
	
	public synchronized void profesor() {
		
		esperar = true;
		notifyAll();
		
	}

}
