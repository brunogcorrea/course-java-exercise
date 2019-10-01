package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDateClient = dateFormat.parse(sc.next());
		
		Client client = new Client(nameClient, emailClient, birthDateClient);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus statusOrder = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), statusOrder, client);
		
		System.out.print("How many items to this order? ");
		int quantityItemsOrder = sc.nextInt();
		
		for(int i=0; i<quantityItemsOrder; i++) {
			
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			
			Product product = new Product(nameProduct, priceProduct);
			
			System.out.print("Quantity: ");
			Integer quantityProduct = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();

	}

}
