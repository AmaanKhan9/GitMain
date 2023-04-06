
class BookTicketApp {
	int total_ticekt = 20;

	public synchronized void bookTicket(int ticket) {
		if (total_ticekt >= ticket) {
			System.out.println("Tickets booked" + ticket);
			total_ticekt = total_ticekt - ticket;
			System.out.println("Tickets left" + total_ticekt);
		} else {
			System.out.println("Booking can't success");
			System.out.println("Tickets left" + total_ticekt);
		}
	}
}

public class MovieBookApp2 extends Thread {
	static BookTicketApp b;
	int seats;

	@Override
	public void run() {
		b.bookTicket(seats);
	}

	public static void main(String[] args) {
		b = new BookTicketApp();

		MovieBookApp2 amaan = new MovieBookApp2();
		amaan.seats = 20;
		amaan.run();
		MovieBookApp2 khan = new MovieBookApp2();
		khan.seats = 100;
		khan.run();
	}
}
