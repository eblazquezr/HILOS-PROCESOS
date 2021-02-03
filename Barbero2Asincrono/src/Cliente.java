
public class Cliente extends Thread{
	
	
	private Barberia barberia;
	private int dni;
	
	public Cliente(Barberia barberia, int dni) {
		super();
		this.barberia = barberia;
		this.dni = dni;
	}
	
	
	private void tiempo() {
		
		int tiempo = (int)(Math.random()*2000);
		
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
			
			int numero = (int)(Math.random()*(5-0));
			
			barberia.entrar(dni,numero);
			tiempo();
			barberia.salir(dni,numero);
			tiempo();
			
		}
	}

}
