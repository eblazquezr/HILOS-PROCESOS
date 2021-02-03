
public class Juez extends Thread{
	
	private Pista pista;
	
	Juez(Pista pista){
		this.pista = pista;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("Todos los corredores listos");
		pista.correr();
	}

}
