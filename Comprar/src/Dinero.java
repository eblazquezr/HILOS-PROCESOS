
public class Dinero extends Thread{
	
	private ControladorDinero controladordinero;
	private int dinero;
	
	
	public Dinero(ControladorDinero controladordinero, int dinero) {
		super();
		this.controladordinero = controladordinero;
		this.dinero = dinero;
		
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		controladordinero.esperar(dinero);
		controladordinero.continuar();
		
	}
	

}
