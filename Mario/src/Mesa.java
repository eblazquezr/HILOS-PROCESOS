 
public class Mesa {

	
	
	public void sayPing() {
		synchronized(this) {
			System.out.println("PING");
			try {
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void sayPong() {
		synchronized(this) {
			System.out.println("PONG");
			try {
				notifyAll();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void terminarPartida() {
		synchronized(this) {
			notifyAll();
		}
	}
	
	
}
