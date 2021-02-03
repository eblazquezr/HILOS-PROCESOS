
public class PrincipalParkingCoches {

	public static void main(String[] args) throws InterruptedException {
		
		Parking p = new Parking(5);
		coche[] c = new coche[10];
		coche[] c2 = new coche[10];
		
		
		for (int i = 0; i < c.length; i++) {
			
			c[i] = new coche(p,i+1);
			c[i].start();
			
			c2[i] = new coche(p,(i+1)*10);
			c2[i].start();
			
		}
		


	}

}
