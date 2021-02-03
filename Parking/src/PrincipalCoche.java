
public class PrincipalCoche {

	public static void main(String[] args) {
		
		ControlarParking c = new ControlarParking(5);
		Coche[] coche = new Coche[10];
		
		for (int i = 0; i < coche.length; i++) {
			
			coche[i] = new Coche(c, i+1);
			coche[i].start();
			
		}

	}

}
