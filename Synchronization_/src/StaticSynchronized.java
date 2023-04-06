
class BLL {
	synchronized static void logic(int n) {

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

class Thread3 extends Thread {

	@Override
	public void run() {
		BLL.logic(10);
	}

}

class Thread4 extends Thread {

	@Override
	public void run() {
		BLL.logic(15);
	}
}

public class StaticSynchronized {
	public static void main(String[] args) {
		BLL bl = new BLL();
		BLL.logic(5);
		Thread3 thhh = new Thread3();
		thhh.start();
		Thread4 thhhh = new Thread4();
		thhhh.start();
	}
}