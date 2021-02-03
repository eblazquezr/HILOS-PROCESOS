
public class ControlarParking {
	
	private int plazas [];
	private boolean barrera = false;
	
	public ControlarParking(int totalPlazas) {
		
		plazas = new int[totalPlazas];
		
		for (int i = 0; i < plazas.length; i++) {
			
			plazas[i] = 0;
			
		}
		
	}
	
	public int aparcarCoche(int coche) {
		
		boolean bandera = false;
		int plaza = 0;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==0) {
				
				plazas[i] = coche;
				plaza = i;
				bandera = true;
			}
			
		}
		
		return plaza;
		
	}
	
	public boolean comprobarEspacio() {
	
		boolean bandera = false;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==0) {
				bandera = true;
			}
			
		}
		
		return bandera;
	}
	
	public int plazasLibres() {
		
		int contador = 0;
		
		for (int i = 0; i < plazas.length; i++) {
			
			if(plazas[i]==0) {
				contador++;
			}
			
		}
		
		return contador;
	}
	
	public int plazaAparca() {
		
		int plaza  = 0;
		boolean bandera =  false;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==0) {
				plaza = i;
				bandera = true;
			}
			
		}
		
		return plaza;
		
	}
	
	public int buscarPlaza(int numero) {
		
		int plaza  = 0;
		boolean bandera =  false;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==numero) {
				plaza = i;
				bandera = true;
			}
			
		}
		
		return plaza;
	}
	
	public synchronized void entrar(int coche) {
		
		while(!comprobarEspacio()) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		int numero = plazaAparca();
		
		System.out.println("ENTRADA: Coche "+coche+" aparca en "+numero);
		plazas[numero] = coche;
		System.out.println("PLAZAS LIBRES: "+plazasLibres());
		mostrarPlazas();
		
		
	}
	
	public synchronized void salir(int coche) {
		
		
		System.out.println("SALIDA: Coche "+coche+" saliendo");
		plazas[buscarPlaza(coche)] = 0;
		System.out.println("PLAZAS LIBRES: "+plazasLibres());
		mostrarPlazas();
		notifyAll();	
		
	}
	
	public void mostrarPlazas() {
		
		String cadena="";
		
		for (int i = 0; i < plazas.length; i++) {
			
			cadena+="["+plazas[i]+"] ";
			
		}
		
		System.out.println(cadena);
	}

}
