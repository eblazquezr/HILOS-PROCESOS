
public class PrincipalTren {

	public static void main(String[] args) {
		
		ControlarTren c = new ControlarTren();
		
		Tren[] t = new Tren[10];
		
		for (int i = 0; i < t.length; i++) {
			
			t[i] = new Tren(c,i+1);
			t[i].start();
			
		}

	}

}
