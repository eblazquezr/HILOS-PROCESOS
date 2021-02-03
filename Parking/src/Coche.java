import java.util.Random;

public class Coche extends Thread{
	
	private ControlarParking con;
	private int matricula;
	
	public Coche(ControlarParking c, int numero) {
		
		con = c;
		matricula = numero;
		
	}
	
	public void esperar() {
		
		int tiempo = (int)(Math.random()*(1500-1200));
	
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			con.entrar(matricula);
			esperar();
			con.salir(matricula);
			esperar();
		}
		
	}

}
