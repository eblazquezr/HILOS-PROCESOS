
public class Ping extends Thread {

	private Mesa mesa;

	public Ping(Mesa mesa) {
		this.mesa = mesa;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			mesa.sayPing();
		}
		System.out.println("FIN PiNG");
		mesa.terminarPartida();
	}
	
	
	
}
