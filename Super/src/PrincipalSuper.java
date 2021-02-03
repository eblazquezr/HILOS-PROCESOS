
public class PrincipalSuper {

	public static void main(String[] args) {
		
		int numeroCajas = Integer.parseInt(args[0]),
			numeroClientes = Integer.parseInt(args[1]);
		
		Supermercado supermercado = new Supermercado(numeroCajas);
		Cliente[] cliente = new Cliente[numeroClientes];
		
		for (int i = 0; i < cliente.length; i++) {
			
			cliente[i] = new Cliente(supermercado,i+1);
			cliente[i].start();
			
			
		}
		

	}

}
