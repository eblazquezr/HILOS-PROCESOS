
public class Controlador {

	private int[] cajas;
	private int max,dinero,clientes,ultimoCliente;
	
	Controlador(int total){
		
		cajas = new int[total];
		
		for (int i = 0; i < cajas.length; i++) {
			
			cajas[i] = 0;
			
		}
		
		max = total;
		clientes = total;
		dinero = 0;
		ultimoCliente = 0;
	}
	
	private boolean comprobarLibres() {
		
		boolean bandera = false;
		
		for (int i = 0; i < cajas.length && !bandera; i++) {
			
			if(cajas[i] == 0) {
				
				bandera = true;
			}
			
		}
		
		return bandera;
		
	}
	
	private int cajaAleatoria() {
		
		int caja = 0;
		
		do {
			
			caja = (int)(Math.random()*max);
			
		} while (cajas[caja]!=0);
		
		
		return caja;
		
	}
	
	
	private int dejarCaja(int dni) {
		
		boolean bandera = false;
		int caja=0;
		
		for (int i = 0; i < cajas.length && !bandera; i++) {
			
			if(cajas[i] == dni) {
				
				caja = i;
				bandera = true;
			}
			
		}
		
		return caja;
		
		
	}
	
	private void mostrar() {
		
		String cadena = "";
		
		for (int i = 0; i < cajas.length; i++) {
			
			cadena +="["+cajas[i]+"] ";
			
		}
		
		System.out.println(cadena);
		
	}
	
	
	public synchronized void entrar(int dni) {
		
		while(!comprobarLibres()) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		int caja = cajaAleatoria();
		System.out.println("CLIENTE ENTRA: Cliente "+dni+" en caja "+caja);
		cajas[caja]=dni;
		clientes--;
		mostrar();
		
	}
	
	
	public synchronized void salir(int dni) {
		
		if(clientes==4) {
			
			ultimoCliente = dni;
			
		}
		
		
		cajas[dejarCaja(dni)] = 0;
		int pagar = (int)(Math.random()*(1000-0));
		System.out.println("CLIENTE SALE: Cliente "+dni+" sale y paga "+pagar);
		dinero+=pagar;
		clientes++;
		
		
		
		mostrar();
		notifyAll();
		
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getClientes() {
		return clientes;
	}

	public void setClientes(int clientes) {
		this.clientes = clientes;
	}

	public int getUltimoCliente() {
		return ultimoCliente;
	}

	public void setUltimoCliente(int ultimoCliente) {
		this.ultimoCliente = ultimoCliente;
	}
	
	
	
	
}
