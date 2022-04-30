package com.florist.orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Order instance;
	private List<Ticket> tickets;

	private Order() {
		tickets = new ArrayList<Ticket>();
	}

	public static Order getInstance() { // Singleton
		if (instance == null) {
			instance = new Order();
		}
		return instance;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public void history() {
		for (Ticket t : tickets) {
			t.getPurchase();
			System.out.println("---------");
		}
	}

	public void moneyRaising() {
		float totalMoney = 0;
		for (Ticket t : tickets) {
			totalMoney += t.getPurchaseValue();
		}
		System.out.printf("Total orders value: %.2f%n", totalMoney);
	}

}
