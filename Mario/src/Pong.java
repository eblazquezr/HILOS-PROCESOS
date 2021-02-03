
public class Pong extends Thread {

	private Mesa mesa;

	public Pong(Mesa mesa) {
		this.mesa = mesa;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			mesa.sayPong();
		}
		System.out.println("FIN PONG");
		mesa.terminarPartida();
	}
}
