package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;

public class App {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		Product p = new Product("TV", 1000.00);
		
		Client c1 = new Client("Maria", "maria@gmail.com", sdf.parse("20/10/1995"));
		
		OrderItem oi1 = new OrderItem( 1, 1000.00, p);
		
		System.out.println(oi1);
		
		System.out.println(c1);
		
		sc.close();

	}

}
