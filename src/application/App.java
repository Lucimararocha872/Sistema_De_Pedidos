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

public class App {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite os dados do cliente:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Data de nascimento (DD/MM/YYY): " );
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name,email,birthDate);
		
		System.out.println("Dados do pedido:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		System.out.println("Quantidade de ítens do pedido:");
		int N = sc.nextInt();
		System.out.println();
		Order order = new Order(new Date(), status, client);
		
		for(int i=0; i<N; i++) {
			System.out.println("Digite com os dados do #" + (i+1) + " item:");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Preço do produto: R$ ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println(order);
		
		
		sc.close();

	}

}
