
public class MainFilosofo {

	public static void main(String[] args) {
		
		Restaurante restaurante	= new Restaurante(5);
		
		Filosofo[] filosofo = new Filosofo[10];
		
		for (int i = 0; i < filosofo.length; i++) {
			
			filosofo[i] = new Filosofo(restaurante,i+1);
			filosofo[i].start();
			
		}

	}

}
