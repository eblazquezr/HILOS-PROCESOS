
public class Coche extends Thread{
	
	private Parking parking;
	private int matricula, tipo;
	
	
	public Coche(Parking parking, int matricula, int tipo) {
		super();
		this.parking = parking;
		this.matricula = matricula;
		this.tipo = tipo;
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
			
			parking.entrar(tipo, matricula);
			tiempo();
			parking.salida(tipo, matricula);
			tiempo();
			
		}
		
	}

}
