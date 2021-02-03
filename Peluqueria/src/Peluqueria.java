
public class Peluqueria {
	
	private int[] sillones;

	Peluqueria(int entero){
		
		sillones = new int[entero];
		
		for (int i = 0; i < sillones.length; i++) {
			
			sillones[i] = 0;
			
		}
		
	}
	
	
	private boolean sillonesLibres() {
		
		 boolean bandera = false;
		 
		 for (int i = 0; i < sillones.length && !bandera; i++) {
			 
			 if(sillones[i] == 0) {
				 
				 bandera = true;
			 }
			 
			
		}
		 
		 return bandera;
	}
	
	
	private int elegirSillon() {
		
		int	posicion = 0;
		
		boolean bandera = false;
		 
		 for (int i = 0; i < sillones.length && !bandera; i++) {
			 
			 if(sillones[i] == 0) {
				 posicion = i;
				 bandera = true;
			 }
			 
			
		}
		
		return  posicion;
		
	}
	
	private int dejarSillon(int dni) {
		
		int	posicion = 0;
		
		boolean bandera = false;
		 
		 for (int i = 0; i < sillones.length && !bandera; i++) {
			 
			 if(sillones[i] == dni) {
				 posicion = i;
				 bandera = true;
			 }
			 
			
		}
		
		return  posicion;
		
		
	}
	
	private void mostrarSillones() {
		
		String cadena = "";
		
		for (int i = 0; i < sillones.length; i++) {
			
			cadena += "["+sillones[i]+"] ";
			
		}	
		
		System.out.println(cadena);
	}
	
	
	public synchronized void entrar(int dni) {
		
		while(!sillonesLibres()) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}
		
		int entero = elegirSillon();
		System.out.println("CLIENTE ENTRA: Cliente "+dni+" entra en el sillon "+entero);
		sillones[entero] = dni;
		mostrarSillones();
		
	}
	
	public synchronized void salir(int dni) {
		
		int entero = dejarSillon(dni);
		System.out.println("CLIENTE SALE: Cliente "+dni+" sale");
		sillones[entero] = 0;
		mostrarSillones();
		notifyAll();
		
	}

}
