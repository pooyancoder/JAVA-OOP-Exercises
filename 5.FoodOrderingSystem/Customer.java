import java.util.ArrayList;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }
// MenuItem... items
    public Order placeOrder(ArrayList<MenuItem> items) {
        Order order = new Order();
        for (MenuItem item : items) {
            order.addItem(item);
        }
        System.out.println(name + " placed an order. Total: $" + order.calculateTotal());
        return order;
    }
}