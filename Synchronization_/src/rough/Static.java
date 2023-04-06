package rough;

class MovieTicket {
	static int total_ticket = 20;

	public static synchronized void bookTicket(int ticket) {
		if (total_ticket >= ticket) {
			System.out.println("Ticket booked " + total_ticket);
			total_ticket = total_ticket - ticket;
			System.out.println("Ticket left " + total_ticket);
		} else {
			System.out.println("Ticket can't be booked");
			System.out.println("Ticket left " + total_ticket);
		}
	}
}

public class Static extends Thread {
	MovieTicket b;
	int seats;

	@Override
	public void run() {
		MovieTicket.bookTicket(seats);

	}

	public static void main(String[] args) {
		Static static1 = new Static();
		static1.seats = 15;
		static1.start();

		Static static2 = new Static();
		static2.seats = 50;
		static2.start();

	}
}                            
