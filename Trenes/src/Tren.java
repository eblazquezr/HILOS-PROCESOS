
public class Tren extends Thread{
	
	private ControlarTren con;
	private int numero;
	
	public Tren(ControlarTren c, int entero) {
		
		con = c;
		numero = entero;
		
	}
	
	public void esperar() {
		
		int tiempo = (int)(Math.random()*1500);
		
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
			con.entrada(numero);
			esperar();
			con.salida(numero);
			esperar();
		}
		
	}

}
