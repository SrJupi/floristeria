import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<Ticket> tickets;

	Order() {
		tickets = new ArrayList<Ticket>();
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public void deleteTicket(Ticket ticket) {
		tickets.remove(findTicket(ticket));
	}

	public int findTicket(Ticket ticket) {
		int i = 0;
		int index = 0;
		boolean match = false;
		while (match) {
			match = tickets.get(i).equals(ticket);
			if (match == true) {
				index = i;
			}
			i++;
		}
		return index;
	}
}
