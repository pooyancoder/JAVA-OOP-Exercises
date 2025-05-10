import java.util.ArrayList;

public class Customer {
    private final String name;
    private final Order order;

    public Order getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public Customer(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    public Order placeOrder(ArrayList<MenuItem> items) {
        Order order = new Order();
        for (MenuItem item : items) {
            order.addItem(item);
        }
        System.out.println(name + " placed an order. Total: $" + order.calculateTotal());
        return order;
    }
}