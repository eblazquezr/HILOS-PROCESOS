
public class ControlarSuper {
	
	private int cajas[];
	private int cajasTotales;
	
	public ControlarSuper(int numeroTotalCajas) {
		
		cajas = new int[numeroTotalCajas];
		
		for (int i = 0; i < cajas.length; i++) {
			
			cajas[i] = 0;
			
		}
		
		cajasTotales = numeroTotalCajas;
		
	}
	
	private boolean comprobarOcupacion() {
		
		boolean bandera = false;
		
		for (int i = 0; i < cajas.length && !bandera; i++) {
			
			if(cajas[i]==0) {
				
				bandera = true;
			}
			
		}
		
		return bandera;
	}
	
	private boolean comprobarCaja(int posicion) {
		
		if(cajas[posicion]!=0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	private int elegirCaja() {
		
		int numeroCaja = 0;
		
		do {
			
			numeroCaja = (int)(Math.random()*cajasTotales);
			
		} while (!comprobarCaja(numeroCaja));
		
		return numeroCaja;
		
	}
	
	
	public synchronized void irACaja(int cliente) {
		
		while(!comprobarOcupacion()) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int caja = elegirCaja();
		System.out.println("Cliente "+cliente+" está en caja "+caja);
		cajas[caja]=cliente;
		mostrar();
//		notifyAll();
	}
	
	public int buscarCaja(int cliente) {
		
		boolean bandera = false;
		int caja = 0;
		
		for (int i = 0; i < cajas.length && !bandera; i++) {
			
			if(cajas[i] == cliente) {
				
				caja = i;
				bandera = true;
				
			}
			
		}
		
		return caja;
		
	}
	
	
	
	public synchronized void pagar(int cliente) {
		
		System.out.println("Cliente "+cliente+" paga 100€");
		cajas[buscarCaja(cliente)] = 0;
		mostrar();
		notifyAll();
		
	}
	
	public void mostrar() {
		
		String cadena="";
		
		for (int i = 0; i < cajas.length; i++) {
			
			cadena+="["+cajas[i]+"] ";
			
		}
		
		System.out.println(cadena);
	}

}
