
public class Main {

	public static void main(String[] args) {
		
		Controlador controlador = new Controlador(5);
		
	
		Cliente[] cliente = new Cliente[10];
		for (int i = 0; i < cliente.length; i++) {
			
			
			cliente[i] = new Cliente(controlador,i+1);
			cliente[i].start();
			
		}
		
		

	}

}
