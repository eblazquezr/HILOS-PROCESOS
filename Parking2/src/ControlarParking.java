
public class ControlarParking {

	private int[] plazas;
	private int sitio,total;
	
	public ControlarParking(int totalPlazas) {
		// TODO Auto-generated constructor stub
		
		plazas = new int[totalPlazas];
		
		for (int i = 0; i < plazas.length; i++) {
			
			plazas[i] = 0;
			
		}
		
		total = totalPlazas;
		
	}
	
	private boolean comprobarPlazasLibres(int opcion) {
		
		boolean bandera = false;
		
		
		// OPCION PARA COCHES
		if(opcion == 0) { 
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				if(plazas[i] == 0) {
					
					bandera = true;
				}
				
			}		
			
			return bandera;
		}
		
		// OPCION CAMIONES
		else {
			
			
			
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				
				// ¿Solucion? 
				if(i+1<plazas.length) {

					if(plazas[i] == 0 && plazas[i+1]==0) {
						
						bandera = true;
					}
				}
				
			}		
			
			return bandera;
		}

		
		 
	}
	
	
	
	private String buscarPlaza(int opcion) {
		
		boolean bandera = false;
		String plaza = "";
		
		// OPCION PARA COCHES
		if(opcion == 0) {
			
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				if(plazas[i] == 0) {
					
					plaza = String.valueOf(i);		
					bandera = true;
					
				}
				
			}
			
			return plaza;
			
		}
		
		// OPCION PARA CAMIONES
		else {
			
			for (int i = 0; i < plazas.length && !bandera; i++) {
				
				if(plazas[i] == 0 && plazas[i+1]==0) {
					
					plaza = String.valueOf(i)+' '+String.valueOf(i+1);		
					bandera = true;
					
				}
				
			}
			
			return plaza;
			
		}
		
		// Segun el programa no, los camiones llega un momento que no 
		
	}
	
	public int buscarPlazaVehiculo(int matricula) {
		
		
		boolean bandera = false;
		int entero = 0;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i] == matricula) {
				
				entero = i;
				bandera = true;
				
			}
			
		}
		
		return entero;
		
	}
	
	public synchronized void entrada(int matricula,int tipo) {
		
		while(!comprobarPlazasLibres(tipo)) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(tipo == 0) {
			
			sitio = Integer.parseInt(buscarPlaza(tipo));
			
			System.out.println("ENTRADA: Coche "+matricula+" aparca en "+sitio);
			total--;
			System.out.println("Plazas libres: "+total);
			plazas[sitio] = matricula;
			mostrar();
		}
		else {
			
			String[] sitios = buscarPlaza(tipo).split(" ");
			
			System.out.println("ENTRADA: Camion "+matricula+" aparca en "+Integer.parseInt(sitios[0]));
			total-=2;
			System.out.println("Plazas libres: "+total);
			plazas[Integer.parseInt(sitios[0])] = matricula;
			plazas[Integer.parseInt(sitios[1])] = matricula;
			mostrar();

		}
	}
	
	public synchronized void salida(int matricula, int tipo) {
		
		if(tipo == 0) {
			
			System.out.println("SALIDA: Coche "+matricula+" saliendo");
			total ++;
			System.out.println("Plazas libre: "+total);
			plazas[buscarPlazaVehiculo(matricula)] = 0;
			mostrar();
			notifyAll();
			
			
		}
		else {
			System.out.println("SALIDA: Camion "+matricula+" saliendo");
			total +=2;
			System.out.println("Plazas libre: "+total);
			int posicion = buscarPlazaVehiculo(matricula);
			plazas[posicion] = 0;
			plazas[posicion+1] = 0;
			mostrar();
			notifyAll();
			
		}
		
	}
	
	private void mostrar() {
		
		String cadena = "";
		
		for (int i = 0; i < plazas.length; i++) {
			
			cadena+="["+String.valueOf(plazas[i])+"] ";
			
		}
		System.out.println(cadena);
	}
	
}
