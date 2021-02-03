
public class Cliente extends Thread{
	
	private Peluqueria peluqueria;
	private int dni;
	
	public Cliente(Peluqueria peluqueria, int dni) {
		super();
		this.peluqueria = peluqueria;
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
		
		for (int i = 0; i < 5; i++) {
			
			peluqueria.entrar(dni);
			tiempo();
			peluqueria.salir(dni);
			
		}
	}
	

}
