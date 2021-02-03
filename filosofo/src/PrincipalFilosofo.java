
public class PrincipalFilosofo {

	public static void main(String[] args) {
		
		// PRIMERO DEFINO EL CONTROLADOR
		ControlarFilosofo c = new ControlarFilosofo(5);
		
		// DEFINDO EL ARRAY DE FILOSOFOS PARA SABER CUANTOS CUBIERTOS NECESITAN
		Filosofo[] filosofos = new Filosofo[5];
		
		// RECORRO LOS FILOFOS
		for (int i = 1; i < filosofos.length; i++) {
			
			// INSTANTCIO EL FILOSOFO
			filosofos[i] = new Filosofo(c, i, i-1);
			
			// EMPIEZA EL FILOSFO
			filosofos[i].start();
		}
		

	}

}
