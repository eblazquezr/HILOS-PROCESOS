
public class PrincipalPrimero {

	public static void main(String[] args) throws InterruptedException {
		
		ControlarPrimero c = new ControlarPrimero();
		
		for (int i = 1; i <= 18; i++) {
			
			Orden o = new Orden(c,i);
			o.start();
			Thread.sleep(500);
		}
		
		
	}
	
}
