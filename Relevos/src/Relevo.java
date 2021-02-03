
public class Relevo extends Thread{
	
	private ControlarRelevos con;
	private int numero,ultimo;
	
	
	public Relevo(ControlarRelevos c, int entero, int ultimoCorredor) {
		// TODO Auto-generated constructor stub
		
		con = c;
		numero = entero;
		ultimo = ultimoCorredor;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("Corredor "+numero+" ha llegado");
		con.esperar(numero,ultimo);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
