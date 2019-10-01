package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {

		items.add(item);

	}

	public void removeItem(OrderItem item) {

		items.remove(item);

	}

	public Double total() {
		
		double sum = 0.0;
		
		for(OrderItem item : items) {
			
			sum += item.subTotal();
			
		}
		
		return sum;

	}
	
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("Order moment: ");
		stringBuilder.append(dateFormat.format(moment) + "\n");
		stringBuilder.append("Order status: ");
		stringBuilder.append(status + "\n");
		stringBuilder.append("Client: ");
		stringBuilder.append(client + "\n");
		stringBuilder.append("Order items: \n");
		
		for(OrderItem item : items) {
			
			stringBuilder.append(items + "\n");
			
		}
		
		stringBuilder.append("Total price: $");
		stringBuilder.append(String.format("%.2f", total()));
		
		return stringBuilder.toString();
		
	}

}
