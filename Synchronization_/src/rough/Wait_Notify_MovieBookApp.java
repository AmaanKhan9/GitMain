package rough;

class TotalEarnings extends Thread {
	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				total = total + 100;

			}
			this.notify();
		}

	}
}

public class Wait_Notify_MovieBookApp {
	public static void main(String[] args) throws InterruptedException {
		TotalEarnings te = new TotalEarnings();
		te.start();  
		// System.out.println(te.total);

		synchronized (te) {
			te.wait();
			System.out.println(te.total);
		}
	}
}
