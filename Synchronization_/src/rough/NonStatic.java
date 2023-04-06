package rough;

class BookApp {
	int total_ticket = 10;

	public synchronized void bookTicket(int tickets) {
		if (total_ticket >= tickets) {
			System.out.println("Ticket booked " + tickets);
			total_ticket = total_ticket - tickets;
			System.out.println("Tickets left " + total_ticket);
		} else {
			System.out.println("Sorry can't book");
			System.out.println("Tickets left " + total_ticket);
		}

	}
}

public class NonStatic extends Thread {
	int seats;
	static BookApp b;

	@Override
	public void run() {
		b.bookTicket(seats);
	}

	public static void main(String[] args) {
		b = new BookApp();

		NonStatic amaan = new NonStatic();
		amaan.seats = 7;
		amaan.start();

		NonStatic khan = new NonStatic();
		khan.seats = 4;
		khan.start();
	}
}
