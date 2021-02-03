
public class PrincipalSuper {

	public static void main(String[] args) {
		
		ControlarSuper c = new ControlarSuper(5);
		
		Super[] clientes = new Super[10];
		
		for (int i = 0; i < clientes.length; i++) {
			
			clientes[i] = new Super(c, i+1);
			clientes[i].start();
			
		}

	}

}
