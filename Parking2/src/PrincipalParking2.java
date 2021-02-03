
// LOS TENGO EN CLASES DISTINTAS

public class PrincipalParking2 {

	public static void main(String[] args) throws InterruptedException {
		
		ControlarParking c = new ControlarParking(3);
		
		Coche[] coche = new Coche[2];
		Camion[] camion = new Camion[3];
		
		for (int i = 0; i < coche.length; i++) {
			
			coche[i] = new Coche(c,i+1,0);
			coche[i].start();

		}

		
		for (int i = 0; i < camion.length; i++) {
			
			camion[i] = new Camion(c,i+100,1);
			camion[i].start();
			
		}
		
	}
	
	public static int restar(int numero, int mayor) {
		
		int entero = mayor;
		
		if(entero>numero) {
			
			do {
				
				entero -=numero; 
				
				
			} while (entero>numero);
		}
		
		return entero;
	}
	

}
