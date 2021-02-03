
public class Profesor extends Thread{
	
	private Clase clase;
	private String nombre;
	public Profesor(Clase clase, String nombre) {
		super();
		this.clase = clase;
		this.nombre = nombre;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		System.out.println("Ha llegado el profesor "+nombre);
		clase.saludoProfesor(nombre);
		
		
	}
	
	

}
