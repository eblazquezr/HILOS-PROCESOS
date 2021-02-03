import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {

//		Mesa m=new Mesa();
//		Ping ping=new Ping(m);
//		Pong pong=new Pong(m);
//		ping.start();
//		pong.start();
//		
//		try {
//			ping.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			pong.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Tunel t=new Tunel(2);
		List<Tren> trenes=new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Tren tren=new Tren(t,String.valueOf(i));
			trenes.add(tren);
			tren.start();
		}
		
		for(Tren temp:trenes) {
			try {
				
				temp.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("TRENES FUERA");
		
		
	}

}
