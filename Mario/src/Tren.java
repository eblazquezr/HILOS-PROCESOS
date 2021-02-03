
public class Tren extends Thread{

	private Tunel tunel;
	private String nombre;

	public Tren(Tunel tunel,String nombre) {
		this.tunel = tunel;
		this.nombre=nombre;
	}
	
	@Override
	public void run() {
		tunel.entrarTunel(nombre);
		tunel.salirTunel(nombre);
	}
	
}
