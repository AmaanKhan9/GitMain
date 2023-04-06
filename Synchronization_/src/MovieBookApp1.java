class BookTicket {
	int total_ticket = 100;

	public synchronized void bookTicket(int ticket) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());

		synchronized (this) {
			if (total_ticket >= ticket) {
				System.out.println("Ticket booked" + ticket);
				total_ticket = total_ticket - ticket;
				System.out.println("Ticket left " + total_ticket);
			} else {
				System.out.println("Ticket can't be booked");
				System.out.println("Ticket left " + total_ticket);
			}
		}

		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getName());

	}
}

public class MovieBookApp1 extends Thread {
	static BookTicket b;
	int seats;

	@Override
	public void run() {
		b.bookTicket(seats);
	}

	public static void main(String[] args) {
		b = new BookTicket();
		MovieBookApp1 amaan = new MovieBookApp1();
		amaan.seats = 55;
		amaan.start();

		MovieBookApp1 khan = new MovieBookApp1();
		khan.seats = 1000;
		khan.start();
	}
}
