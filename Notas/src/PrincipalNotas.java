
public class PrincipalNotas {

	public static void main(String[] args) throws InterruptedException {
		
		ControlarNotas c = new ControlarNotas();
		
		Alumno[] a = new Alumno[10];
		
		for (int i = 0; i < a.length; i++) {
			
			a[i] = new Alumno(c,i+1);
			a[i].start();
			Thread.sleep(500);
		}
		
		Profesor p = new Profesor(c,"Ernesto");
		p.start();

	}

}
