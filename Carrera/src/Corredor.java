
public class Corredor extends Thread{
	
	private Pista pista;
	private int dorsal, ultimo;
	
	public Corredor(Pista pista, int dorsal, int ultimo) {
		
		this.pista  = pista;
		this.dorsal = dorsal;
		this.ultimo = ultimo;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("Corredor "+dorsal+" preparado");
		pista.salida(dorsal, ultimo);
		
	}

}
