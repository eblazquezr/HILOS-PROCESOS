
public class Supermercado {
	
	private int[] cajas;
	
	Supermercado(int totalCajas){
		
		cajas = new int[totalCajas];
		
		for (int i = 0; i < cajas.length; i++) {
			
			cajas[i] = 0;
			
		}
		
	}
	
	private boolean comprobarCajasLibres() {
		
		boolean bandera = false;
		
		for (int i = 0; i < cajas.length && !bandera; i++) {
			
			if(cajas[i]==0) {
				bandera = true;
			}
			
		}
		
		return bandera;
		
	}
	
	private int obtenerNumeroCaja(int opcion,int persona) {
		
		int numeroCaja = 0;
		boolean bandera = false;
		
		if(opcion == 0) {
			
			for (int i = 0; i < cajas.length && !bandera; i++) {
				
				if(cajas[i]==0) {
					cajas[i] = persona;
					numeroCaja = i;
					bandera = true;
				}
				
			}
		}
		else {
			for (int i = 0; i < cajas.length && !bandera; i++) {
				
				if(cajas[i]==persona) {
					cajas[i] = 0;
					numeroCaja = i;
					bandera = true;
				}
				
			}
		}
		
		return numeroCaja;
		
	}
	
	private void mostrarCajas() {
		
		String camaras="";
		
		for (int i = 0; i < cajas.length; i++) {
			
			camaras += "["+cajas[i]+"] ";

		}
		
		System.out.println(camaras);
		
	}
	
	
	public synchronized void esperar(int persona) {
		
		while(!comprobarCajasLibres()) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int numeroCaja = obtenerNumeroCaja(0, persona);
		System.out.println("IR A CAJA: Persona "+persona+" va a caja "+numeroCaja);
		mostrarCajas();
		
	}
	
	public synchronized void pagar(int persona) {
		
		int numeroCaja = obtenerNumeroCaja(1, persona);
		System.out.println("CAJA LIBRE: Persona "+persona+" paga en caja "+numeroCaja);
		mostrarCajas();
		notifyAll();
		
	}

}
