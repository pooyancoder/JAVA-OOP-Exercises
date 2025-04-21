import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private ArrayList<Order> orders;
    public ArrayList<MenuItem> items;

    public Restaurant() {
        this.items = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders(){
        return this.orders;
    }
    public ArrayList<MenuItem> getMenu(){
        return this.items;
    }


    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    public void receiveItem(MenuItem Item) {
        items.add(Item);
        System.out.println("New Item received.");
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }

    public void finalizeOrder(Order order) {
        order.finalizeOrder(this);
    }

}