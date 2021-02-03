
public class Camion extends Thread{
	
	private ControlarParking con;
	private int matricula,tipo;
	
	public Camion(ControlarParking c, int entero, int opcion) {
		
		con = c;
		matricula = entero;
		tipo = opcion;
		
	}
	
	private void esperar() {
		
		int tiempo = (int)(Math.random()*2500);
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
			
		for (int i = 0; i < 2; i++) {
			
			con.entrada(this.matricula+i*10, tipo);
			esperar();
			con.salida(this.matricula+i*10, tipo);
			
		}
		
	}
	


}
