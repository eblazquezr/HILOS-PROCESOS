
public class ControlarBarbero {
	
	private boolean sillas [];
	private int total;
	
	ControlarBarbero(int numeroSillas){
		
		sillas = new boolean[numeroSillas];
		for (int i = 0; i < sillas.length; i++) {
			
			sillas[i] = true;
		}
		
		total = numeroSillas;
		
	}
	
	public synchronized boolean ocuparSilla(int numero) {
		
		boolean bandera  = false;
		
		if (sillas[numero]) {
			
			sillas[numero] = false;
			bandera = true;
			total--;
			System.out.println("QUEDAN "+total+" SILLAS");
			
		}
		
		return bandera;		
		
	}
	
	public synchronized void dejarSilla(int numero) {
		
		sillas[numero] = true;
		total++;
		System.out.println("QUEDAN "+total+" SILLAS");
	}

}
