
public class Barberia {
	
	private int[] sillas;
	private int total,global;
	
	public Barberia( int total) {
		super();
		
		this.total = total;
		this.global = total;
		
		sillas = new int[total];
		
		for (int i = 0; i < sillas.length; i++) {
			
			sillas[i] = 0;
			
		}
		
	}
	
	
	private boolean comprobarSillasLibres() {
		
		boolean bandera = false;
		
		for (int i = 0; i < sillas.length && !bandera; i++) {
			
			if(sillas[i] == 0) {
				
				bandera = true;
				
			}
			
		}
		
		return bandera;
		
	}
	
	
	private int sentarseEnSilla() {
		
		int silla = 0;
		
		boolean bandera = false;
		
		for (int i = 0; i < sillas.length && !bandera; i++) {
			
			if(sillas[i] == 0) {
				
				silla = i;
				bandera = true;
				
			}
			
		}
		
		return silla;
		
	}
	
	private int dejarSilla(int posicion) {
		
		int silla = 0;
		
		boolean bandera = false;
		
		for (int i = 0; i < sillas.length && !bandera; i++) {
			
			if(sillas[i] == posicion) {
				
				silla = i;
				bandera = true;
				
			}
			
		}
		
		return silla;
		
	}
	
	
	private void mostrarSillas() {
		
		String cadena = "";
		
		for (int i = 0; i < sillas.length; i++) {
			
			cadena += "["+sillas[i]+"]";
			
		}
		
		System.out.println(cadena);
		
	}
	
	
	
	public void entrar(int dni) {
		
		
		int silla = (int)(Math.random()*global);
		System.out.println("CLIENTE NUEVO: Cliente "+dni+" entra en el sillon "+silla);
		sillas[silla] = dni;
		total--;
		System.out.println("SILLAS LIBRES: "+total);
		mostrarSillas();
		
		
	}
	
	
	public void salir(int dni) {
		
		int silla = dejarSilla(dni);
		System.out.println("CLIENTE SALE: Cliente "+dni+" sale");
		sillas[silla] = 0;
		total++;
		System.out.println("SILLAS LIBRES: "+total);
		mostrarSillas();
		
		
		
	}
	
	

}
