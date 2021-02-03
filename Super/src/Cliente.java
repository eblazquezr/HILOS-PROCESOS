
public class Cliente extends Thread{
	
	private Supermercado supermercado;
	private int persona;
	
	
	public Cliente(Supermercado supermercado, int persona) {
		super();
		this.supermercado = supermercado;
		this.persona = persona;
	}
	
	
	private void tiempo() {
		
		int t = (int)(Math.random()*(2000-1500));
		
		try {
			Thread.sleep(t);
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
			
			supermercado.esperar(persona);
			tiempo();
			supermercado.pagar(persona);
			tiempo();
		}
		
	}

}
