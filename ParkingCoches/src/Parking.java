
public class Parking {
	
	private int[] plazas;
	private int maxPlazas;

	public Parking(int totalPlazas) {
		super();
		
		plazas = new int[totalPlazas];
		
		for (int i = 0; i < plazas.length; i++) {
			
			plazas[i] = 0;
			
		}
		
		maxPlazas = totalPlazas;
		
	}
	
	
	private boolean comprobarPlazas() {
		
		boolean bandera = false;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==0) {
				bandera = true;
			}
			
		}
		
		return bandera;
		
	}
	
	private int encontrarCoche(int matricula) {
		
		boolean bandera = false;
		int plaza = 0;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==matricula) {
				bandera = true;
				plaza = i;
			}
			
		}
		
		return plaza;
		
	}
	
	private int plazaLibre() {
		
		boolean bandera = false;
		int plaza = 0;
		
		for (int i = 0; i < plazas.length && !bandera; i++) {
			
			if(plazas[i]==0) {
				bandera = true;
				plaza = i;
			}
			
		}
		
		return plaza;
		
	}
	
	
	private void mostrar() {
		
		String esquema = "";
		
		for (int i = 0; i < plazas.length; i++) {
			
			esquema += "["+plazas[i]+"] ";
			
		}
		
		System.out.println(esquema);
	}
	
	public synchronized void entrar(int matricula) {
		
		int plaza;
		
		while(!comprobarPlazas()) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		plaza = plazaLibre();
		
		plazas[plaza] = matricula;
		maxPlazas--;
		
		System.out.println("ENTRAR: Coche "+matricula+" aparca en la plaza "+plaza);
		System.out.println("PLAZAS LIBRES: "+maxPlazas);	
		mostrar();
		
		notifyAll();		
		
		
	}
	
	public synchronized void salir(int matricula) {
		
		plazas[encontrarCoche(matricula)]=0;
		maxPlazas++;
		
		System.out.println("SALIR: Coche "+matricula+" sale");
		System.out.println("PLAZAS LIBRES: "+maxPlazas);
		mostrar();
		notifyAll();
		
		
	}

}
