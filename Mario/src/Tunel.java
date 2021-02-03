
public class Tunel {

	private final int maxTrenes;
	private int trenesDentro;
	
	public Tunel(int maxTrenes) {
		this.maxTrenes = maxTrenes;
		this.trenesDentro = 0;
	}
	
	
	public void entrarTunel(String nombre) {
		synchronized (this) {
			while(trenesDentro>=maxTrenes) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			trenesDentro++;
			notifyAll();
		}
		System.out.println("Entro TUNEL ["+nombre+"]");
		
	}
	
	public void salirTunel(String nombre) {
		synchronized (this) {
			trenesDentro--;
			notifyAll();
		}
		System.out.println("Salgo TUNEL["+nombre+"]");
	}
	
	
	
	
	
}
