
public class Super extends Thread{
	
	private ControlarSuper con;
	private int cliente;
	
	Super(ControlarSuper c, int entero){
		con = c;
		cliente = entero;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			con.irACaja(cliente);
			esperar();
			con.pagar(cliente);
			esperar();
		}
		
	}
	
	private void esperar() {
		
		int tiempo = (int)(Math.random()*5000);
		
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
