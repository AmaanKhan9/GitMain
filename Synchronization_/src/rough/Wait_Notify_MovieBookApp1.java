package rough;

class BookTicket extends Thread {
	int a = 10;

	@Override
	public synchronized void run() {

		for (int i = 0; i < 10; i++) {
			a = a + 100;
		}

		this.notify();
	}
}

public class Wait_Notify_MovieBookApp1 extends Thread {
	public static void main(String[] args) throws InterruptedException {
		BookTicket b = new BookTicket();
		b.start();
		synchronized (b) {
			b.wait();
			System.out.println(b.a);
		}
	}
}
