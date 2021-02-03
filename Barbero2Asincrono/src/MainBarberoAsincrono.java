
public class MainBarberoAsincrono {

	public static void main(String[] args) {
		
		Barberia barberia = new Barberia(5);
		Cliente[] cliente = new Cliente[20];
		
		for (int i = 0; i < cliente.length; i++) {
			
			cliente[i] = new Cliente(barberia,i+1);
			cliente[i].start();
			
		}

	}
	
}
