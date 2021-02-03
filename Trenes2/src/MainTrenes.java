
public class MainTrenes {

	public static void main(String[] args) {

		Estacion estacion = new Estacion();
		Tren[] tren = new Tren[5];
		
		for (int i = 0; i < tren.length; i++) {
			
			 tren[i] = new Tren(estacion,i+1);
			 tren[i].start();
			
		}
		for (int i = 0; i < tren.length; i++) {
			
			try {
				tren[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
	}

}
