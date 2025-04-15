import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Order> orders;

    public Restaurant() {
        this.orders = new ArrayList<>();
    }

    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }
}