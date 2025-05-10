import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Order> orders;
    public ArrayList<MenuItem> MenuItems;
    public ArrayList<Customer> customers;

    public Restaurant() {
        this.MenuItems = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public ArrayList<MenuItem> getMenu() {
        return this.MenuItems;
    }

    public void showCustomers(){
        if (customers.isEmpty()){
            System.out.println("there is no customer here!\n");
            return;
        }
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + ". "+customers.get(i).getName());
            System.out.println(customers.get(i).getOrder().getStatus());
        }
    }

    public void showDeliveryOrders(){
        if (customers.isEmpty()){
            System.out.println("there is no customer here!\n");
            return;
        }
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getOrder().getClass().equals(DeliveryOrder.class)){
                System.out.println(i + ". "+customers.get(i).getName());
                DeliveryOrder order = (DeliveryOrder) customers.get(i).getOrder();
                System.out.println(order.getDeliveryStatus());
            }
        }
    }


    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    public void receiveItem(MenuItem Item) {
        MenuItems.add(Item);
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }

    public void showItems(){
        if (MenuItems.isEmpty()){
            System.out.println("no Item to show!\n");
            return;
        }
        for (int i = 0; i < MenuItems.size(); i++) {
            System.out.println(i + ". " + MenuItems.get(i).getName() + " " + MenuItems.get(i).getPrice());
        }
    }
}