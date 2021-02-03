
public class PrincipalParkingCamion {

	public static void main(String[] args) {
		
		Parking parking = new Parking(5);
		Coche[] coche = new Coche[20];
		Camion[] camion = new Camion[10];
		
		for (int u = 0; u <5; u++) {
			
			for (int i = 0; i < coche.length; i++) {
				
				coche[i] = new Coche(parking,i+1,0);
				coche[i].start();
				
			}
			
			for (int i = 0; i < camion.length; i++) {
				
				camion[i] = new Camion(parking,i+1,1);
				camion[i].start();
				
			}
			
		}

	}

}
