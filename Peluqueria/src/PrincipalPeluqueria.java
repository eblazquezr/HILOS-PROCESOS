
public class PrincipalPeluqueria {

	public static void main(String[] args) {
		
		Peluqueria peluqueria = new Peluqueria(10);
		Cliente[] cliente = new Cliente[30];
		
		for (int i = 0; i < cliente.length; i++) {
			
			cliente[i] = new Cliente(peluqueria,i+1);
			cliente[i].start();
		}

		
		
	}

}
