
public class PrincipalRelevos {

	public static void main(String[] args) throws InterruptedException {
		
		ControlarRelevos c = new ControlarRelevos();
		
		int total = 200;
		
		for (int i = 0; i < total; i++) {
			Relevo r = new Relevo(c, i, total);
			r.start();
			Thread.sleep(10);
		}
		Disparar d = new Disparar(c);
		d.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
