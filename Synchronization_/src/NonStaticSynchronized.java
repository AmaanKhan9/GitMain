
class BL {
	synchronized void logic(int n) {
		synchronized (this) {
			for (int i = 0; i < n; i++) {
				System.out.println(Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				System.out.println(i);

			}
		}
	}
}

class Thread1 extends Thread {
	BL bl;

	public Thread1(BL bl) {
		this.bl = bl;
	}

	@Override
	public void run() {
		bl.logic(10);
	}

}

class Thread2 extends Thread {
	BL bl;

	public Thread2(BL bl) {
		this.bl = bl;
	}

	@Override
	public void run() {
		bl.logic(15);
	}
}

public class NonStaticSynchronized {
	public static void main(String[] args) {
		BL bl = new BL();
		bl.logic(5);
		Thread1 th = new Thread1(bl);
		th.start();
		Thread2 thh = new Thread2(bl);
		thh.start();

	}
}