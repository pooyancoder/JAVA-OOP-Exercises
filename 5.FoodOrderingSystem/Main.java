public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        MenuItem burger = new MenuItem("Burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", 8.99);

        Customer customer = new Customer("Alice");
        Order order = customer.placeOrder(burger, pizza);
        restaurant.receiveOrder(order);

        restaurant.updateOrderStatus(order, "In Progress");
    }
}