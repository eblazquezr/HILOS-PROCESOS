
public class coche extends Thread{
	
	private Parking	p;
	private int matricula;
	
	coche(Parking p, int matricula){
		
		this.p = p;
		this.matricula = matricula;
		
		
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 2; i++){
			
			p.entrar(matricula);
			try {
				Thread.sleep((int)(Math.random()*(1500-1200)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p.salir(matricula);
			try {
				Thread.sleep((int)(Math.random()*(1500-1200)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
