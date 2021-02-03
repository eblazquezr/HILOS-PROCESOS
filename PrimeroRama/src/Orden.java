
public class Orden extends Thread{
	
	private ControlarPrimero con;
	private int numero;
	
	Orden(ControlarPrimero c, int entero){
		
		con = c;
		numero = entero;
		
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		con.comprobar(numero);
		con.par(numero);

		
		
	}
	
}
