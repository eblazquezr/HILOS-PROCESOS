
public class Alumno extends Thread{
	
	private ControlarNotas con;
	private int numero;
	
	public Alumno(ControlarNotas c, int entero) {
		// TODO Auto-generated constructor stub
		
		con = c;
		numero = entero;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("Alumno "+numero+" espera la nota");
		try {
			con.alumnos(numero);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
