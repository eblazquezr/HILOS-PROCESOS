
public class Cliente extends Thread{
	
	private Controlador controlador;
	private ControladorDinero controladorDinero = new ControladorDinero();
	private int dni;
	
	public Cliente(Controlador controlador, int dni) {
		super();
		this.controlador = controlador;
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
		
		for (int i = 0; i < 2; i++) {
			
			controlador.entrar(dni);
			tiempo();
			controlador.salir(dni);
			tiempo();
			
		}
		
		if(controlador.getClientes()==5 && controlador.getUltimoCliente()==dni) {
			controladorDinero.continuar();
			controladorDinero.esperar(controlador.getDinero());		
		}
		
		
	}
	

}
