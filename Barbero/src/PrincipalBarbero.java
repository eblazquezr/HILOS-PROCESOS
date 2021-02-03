
public class PrincipalBarbero {

	public static void main(String[] args) {
		
		ControlarBarbero c = new ControlarBarbero(4);
		
		Barberia[] b = new Barberia[10];
		
		System.out.println(b.length);
		
		for (int i = 0; i < b.length; i++) {
			
			b[i] = new Barberia(c, (int)(Math.random()*4), i+1);
			b[i].start();
			
		}

	}
	

	

}
