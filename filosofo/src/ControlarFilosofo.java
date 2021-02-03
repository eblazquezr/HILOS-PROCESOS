
public class ControlarFilosofo {
	
	// CONJUNTO DE BOOLEANOS PARA SABER QUE CUBIERTOS HAY LIBRES Y QUE CUBIERTOS ESTAN OCUPADOS
	private boolean cubiertos[];
	
	public ControlarFilosofo(int numeroCubiertos) {
		
		// LA PRIMERA VEZ VAN A ESTAR TODOS LIBRES
		cubiertos = new boolean[numeroCubiertos];
		
		// RELLENO EL ARRAY CON TODO A TRUE
		for (int i = 0; i < cubiertos.length; i++) {
			
			cubiertos[i] = true;
			
		}
		
	}
	
	// MÉTODO CON EL QUE COMPRUEBO SI HAY DOS CUBIERTOS LIBRES
	public synchronized boolean cogerCubierto(int p1, int p2) {
		
		boolean bandera = false;
		
		// SI LOS DOS CUBIERTOS ESTAS LIBRES LOS PONGO EN FALSE Y DEVUELVO TRUE PARA DECIR QUE EL FILOSOFO ESTA COMIENDO
		if(cubiertos[p1] && cubiertos[p2]) {
			
			cubiertos[p1] = false;
			cubiertos[p2] = false;
			bandera = true;
		}
		
		return bandera;
	}

	// MÉTODO CON EL QUE DEJO LOS CUBIERTOS DESPUES DE COMER 
	public synchronized void dejarCubiertos(int p1, int p2) {
		
		cubiertos[p1] = true;
		cubiertos[p2] = true;
		
	}
	
}
