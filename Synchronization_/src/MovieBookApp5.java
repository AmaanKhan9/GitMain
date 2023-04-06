class BookTicket1 {
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
public class MovieBookApp5 {

}
