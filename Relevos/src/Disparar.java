
public class Disparar extends Thread{
	
	private ControlarRelevos con;
	private int numero,ultimo;
	
	
	public Disparar(ControlarRelevos c ) {
		// TODO Auto-generated constructor stub
		
		con = c;

	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("Todos los hilos creados");
		System.out.println("Doy la salida");
		con.empezar();
	}

}
