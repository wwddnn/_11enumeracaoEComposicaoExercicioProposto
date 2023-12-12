package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //Creating object 'sdf' for the customize date. (Criar um objeto data em formato customizado).
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Recording client data. (registrando dados do cliente).
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());
        //Creating object client with 3 attributes. (criando um objeto cliente com 3 atributos).
        Client client1 = new Client(name, email, birthDate);

        //Transforming enter data to enums of OrderStatus. Using method 'valueOf'. (transformando dados de entrada em tipo enum OrderStatus).
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        //Creating object order with 3 attributes: moment, enum status, and client. (criando um objeto order com seus 3 atributos).
        Order order1 = new Order(new Date(), status, client1);

        //Registering product and their attributes name and price. (gravando o pedido e seus atributos nome e price).
        System.out.print("How many items to this order? ");
        int items = sc.nextInt();
        for (int i = 0; i < items; i++) {
            System.out.println("Enter #" + (i+1) + " item data: ");
            System.out.print("Product name: ");
            sc.nextLine();
            String nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            double priceProduct = sc.nextDouble();
           //Creating object product with 2 attributes. (criando um objeto produto com 2 atributos).
            Product product1 = new Product(nameProduct, priceProduct);

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            //Creating object orderItem with 3 attributes. (criando um objeto orderItem com 3 atributos).
            OrderItem orderItem1 = new OrderItem(quantity, priceProduct, product1);

            order1.addItem(orderItem1);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.print(order1);


        sc.close();
    }
}
