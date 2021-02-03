import java.util.Random;

public class Filosofo extends Thread{
	
	private ControlarFilosofo con;
	private int p1,p2;
	
	// NECESITA COMO PARAMETROS LA CLASE CONTROLADORA Y LOS 2 CUBIERTOS QUE VA A USAR
	public Filosofo(ControlarFilosofo c, int numero1, int numero2) {
		// TODO Auto-generated constructor stub
		
		con = c;
		p1 = numero1;
		p2 = numero2;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		// BUCLE INFINITO
		while(true) {
			
			// COMPROBAMOS QUE HAY CUBIERTOS LIBRES
			boolean cogerCubierto = con.cogerCubierto(p1, p2);
			
			// SI HAY CUBIERTOS LIBRES HACEMOS QUE COMA, DEJE LOS CUBIERTOS Y DUERMA
			if(cogerCubierto) {
				comer();
				con.dejarCubiertos(p1, p2);
				dormir();
			}
			
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	// MOSTRAMOS QUE EL FILOSOFO COME DURANTE X SEGUNDOS
	public void comer() {
		
		System.out.println("Filosofo "+Thread.currentThread().getName()+ " comiendo");
		
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
	
	// EL FILOSOFO DUERME DURANTE X SEGUNDOS
	public void dormir() {
		
		System.out.println("Filosofo "+Thread.currentThread().getName()+" durmiendo");
		esperar();
		
	}
}
