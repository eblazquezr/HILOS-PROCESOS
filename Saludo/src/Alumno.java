
public class Alumno extends Thread{
	
	private Clase clase;
	private int numero;
	
	
	public Alumno(Clase clase, int numero) {
		super();
		this.clase = clase;
		this.numero = numero;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("Alumno "+numero+" ha llegaodo");
		clase.saludoAlumnos(numero);
		
		
	}

}
