package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    //Criar uma data em formato customizado. Static é para que sirva para todos os objetos criados.
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    //Associar a classe Order com a classe Client. A relação de um para um.
    private Client cliente;

    //Associar a classe Order com a classe OrderItem.
    //Como a classe OrderItem é uma lista, porque a relação entre Order e OrderItem é de um para muitos.
    private List<OrderItem> items = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client cliente) {
        this.moment = moment;
        this.status = status;
        this.cliente = cliente;
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

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    //Adiciona item a lista items.
    public void addItem(OrderItem item){
        items.add(item);
    }

    //Remove item da lista items.
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    //Calcula o total do pedido, ou seja, busca dentro da lista de items, o subtotal deles e soma, para dar o valor total.
    public double total() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return  sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(cliente + "\n");
        sb.append("Order items: " + "\n");
        for (OrderItem item: items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }


}
