class BookTheareSeat {
	int total_seats = 10;

	public synchronized void bookSeat(int seats) {
		if (total_seats >= seats) {
			System.out.println("Seats fully booked" + seats);
			total_seats = total_seats - seats;
			System.out.println("Seats left" + total_seats);
		} else {
			System.out.println("Seats can't be booked");
			System.out.println("Seats left" + total_seats);
		}
	}
}

public class MovieBookApp extends Thread {
	static BookTheareSeat b;
	int seats;

	public void run() {
		b.bookSeat(seats);
	}

	public static void main(String[] args) {
		b = new BookTheareSeat();
		MovieBookApp amaan = new MovieBookApp();
		amaan.seats = 7;
		amaan.start();

		MovieBookApp khan = new MovieBookApp();
		khan.seats = 3;
		khan.start();
	}
}
