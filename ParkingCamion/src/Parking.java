
public class Parking {

	private int[] plazas;
	
	private int total;
	
	Parking(int totalPlazas){
		
		total = totalPlazas;
		
		plazas = new int[totalPlazas];
		
		for (int i = 0; i < plazas.length; i++) {
			
			plazas[i] = 0;
			
		}
		
	}
	
	
	private boolean comprobarEspacio(int posicion) {
		
		boolean bandera = false;
		
		if(posicion == 0) {
			
			
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				if(plazas[i]==0) {
					
					bandera = true;
				}
				
			}
			
		}
		
		else
		{
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				if(plazas.length>i+1) {
					
					if(plazas[i]==0 && plazas[i+1]==0) {
						
						bandera = true;
					}
					
				}
				
			}
		}
		
		return bandera;
		
	}
	

	private int encontrarPlazaEntrada(int posicion) {
		
		boolean bandera = false;
		int entero = 0;
		
		if(posicion == 0) {
			
			
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				if(plazas[i]==0) {
					entero = i;
					bandera = true;
				}
				
			}
			return entero;
			
		}
		
		else {
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				if(plazas[i]==0 && plazas[i+1]==0) {
					entero = i;
					bandera = true;
					
				}
				
			}
			return entero;
		}
		
		
		
		
	}
	
	private int buscarCoche(int matricula) {
		
		boolean bandera = false;
		int entero = 0;
		
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==matricula) {
				entero = i;
				bandera = true;
			}
				
			
			
		}
		
		return entero;
		
	}
	
	private void mostrar() {
		
		
		String cadena="";
		
		for (int i = 0; i < plazas.length; i++) {
			
			cadena += "["+plazas[i]+"] ";
			
		}
		
		System.out.println(cadena);
		
	}
	
	
	public synchronized void entrar(int posicion, int matricula) {
		
		while(!comprobarEspacio(posicion)) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(posicion == 0) {
			
			int entero = encontrarPlazaEntrada(posicion);
			System.out.println("ENTRADA COCHE: Coche "+matricula+" aparca en "+entero);
			total--;
			System.out.println("PLAZAS LIBRES: "+total);
			plazas[entero]=matricula;
			mostrar();
			
		}
		else {
			
			int entero = encontrarPlazaEntrada(posicion);
			System.out.println("ENTRADA CAMION: Camion "+matricula+" aparca en "+entero);
			total-=2;
			System.out.println("PLAZAS LIBRES: "+total);
			plazas[entero]=matricula;
			plazas[entero+1]=matricula;
			mostrar();
			
		}
		
	}
	
	public synchronized void salida(int posicion, int matricula) {
		
		if(posicion == 0) {
			
			int entero = buscarCoche(matricula);
			System.out.println("SALIDA COCHE: Coche "+matricula+" saliendo");
			total++;
			System.out.println("PLAZAS LIBRES: "+total);
			plazas[entero]=0;
			mostrar();
			notifyAll();
			
		}
		
		else {
			int entero = buscarCoche(matricula);
			System.out.println("SALIDA CAMION: Camion "+matricula+" saliendo");
			total+=2;
			plazas[entero]=0;
			plazas[entero+1]=0;
			System.out.println("PLAZAS LIBRES: "+total);
			mostrar();
			notifyAll();
		}
		
		
	}
	
}
