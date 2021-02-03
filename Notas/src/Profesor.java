
public class Profesor extends Thread{
	
	private ControlarNotas con;
	private String nombre;
	
	public Profesor(ControlarNotas c, String cadena) {
		// TODO Auto-generated constructor stub
		con = c;
		nombre = cadena;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("Profesor "+nombre+" pone notas");
		con.profesor();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
