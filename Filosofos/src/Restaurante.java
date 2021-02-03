
public class Restaurante {
	
	private int[] sillas;
	private int total, posicion;
	private boolean bandera;
	
	
	public Restaurante( int total) {
		super();
	
		this.total = total;
		
		sillas = new int[this.total];
		
		for (int i = 0; i < sillas.length; i++) {
			
			sillas[i] = 0;
			
		}
		
	}
	
	private boolean comprobarSillasLibres() {
		
		bandera = false;
		
		for (int i = 0; i < sillas.length && !bandera; i++) {
			
			if(sillas[i] == 0) {
				
				bandera = true;
				
			}
			
		}
		
		return bandera;
		
	}

	
	private int elegirSilla() {
		
		bandera = false;
		
		for (int i = 0; i < sillas.length && !bandera; i++) {
			
			if(sillas[i] == 0) {
				
				posicion = i;
				bandera = true;
			}
			
		}
		
		
		return posicion;
		
	}
	
	private int dejarSilla(int dni) {
		
		bandera = false;
		
		for (int i = 0; i < sillas.length && !bandera; i++) {
			
			if(sillas[i] == dni) {
				
				posicion = i;
				bandera = true;
			}
			
		}
		
		
		return posicion;
		
	}
	
	private void mostrarSillas() {
		
		
		String cadena = "";
		
		for (int i = 0; i < sillas.length; i++) {
			
			cadena += "["+sillas[i]+"] ";
			
			
		}
		
		System.out.println(cadena);
		
	}
	
	public void entrar(int dni) {
		
		posicion = elegirSilla();
		System.out.println("CLIENTE ENTRA: Cliente "+dni+" sientese en la silla "+posicion);
		sillas[posicion]=dni;
		total--;
		System.out.println("ME QUEDAN LIBRES "+total+" SILLAS");
		mostrarSillas();
		
	}
	
	
	public void salir(int dni) {
		
		System.out.println("CLIENTE SALE: Cliente "+dni+" vuelva pronto");
		sillas[dejarSilla(dni)] = 0;
		total++;
		System.out.println("ME QUEDAN LIBRE "+total+" SILLAS");
		mostrarSillas();
		
		
	}
	
	
}
