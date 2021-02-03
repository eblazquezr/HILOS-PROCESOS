import java.util.Random;

public class Barberia extends Thread{
	
	private ControlarBarbero con;
	private int silla,cliente;
	
	public Barberia( ControlarBarbero c,int numero, int numeroCliente ) {
		
		con = c;
		silla = numero;
		cliente = numeroCliente;
		
	}
	
	public void sentarse() {
		
		System.out.println("Cliente "+cliente+" se sienta");
		esperar();
	}
	
	public void esperar() {
		
		Random generador=new Random();
        int msAzar=generador.nextInt(3);
        try {
                Thread.sleep(msAzar);
        } catch (InterruptedException ex) {
                System.out.println("Fallo la espera");
        }
		
	}
	
	public void irse() {
		
		System.out.println("Cliente "+cliente+" se va");
		esperar();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			
			boolean comprobar = con.ocuparSilla(silla);
			
			if(comprobar) {
				
				sentarse();
				con.dejarSilla(silla);
				irse();
				
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
