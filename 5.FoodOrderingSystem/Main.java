import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner Scanner = new Scanner(System.in);

    static void createCustomer(Restaurant r) {
        System.out.println("Enter Customer name");
        String cName = Scanner.nextLine();
        Customer customer = new Customer(cName);
        ArrayList<MenuItem> menu = r.getMenu();
        for (MenuItem m : menu) {
            System.out.println(".. " + m.getName() + " " + m.getPrice());
        }
        ArrayList<MenuItem> CustomerMenu = new ArrayList<>();
        String Choose = "";
        do {
            System.out.println("Enter your choose 0 to finish the order");
            Choose = Scanner.nextLine();
            boolean found = false;
            for (MenuItem m : menu) {
                if (Choose.equalsIgnoreCase(m.getName())) {
                    CustomerMenu.add(m);
                    found = true;
                }
            }
            if (!found && !Choose.equals("0")) {
                System.out.println("Item not found in menu.");
            }

        } while (!Choose.equals("0"));
        Order newOrder = customer.placeOrder(CustomerMenu);
        newOrder.printSummary();
        System.out.println("The price equals " + newOrder.calculateTotal() + "dollars!");
        r.receiveOrder(newOrder);
        System.out.println("The Order Successfully received");
        System.out.println("Ent");
    }

    static void createMenuItem(Restaurant r) {
        System.out.println("enter menu Price");
        System.out.println("enter menu name");
        int price = Scanner.nextInt();
        String name = Scanner.nextLine();
        MenuItem newMenu = new MenuItem(name, price);
        r.items.add(newMenu);
    }

    static void UpdateOrder(Restaurant r) {
        ArrayList<Order> orders = r.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders to update.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(i + ": Order Status - " + orders.get(i).getStatus()
                    + " | Delivery: " + orders.get(i).getDeliveryStatus());
        }

        System.out.println("Enter the index of the order to update:");
        int index = Scanner.nextInt();
        Scanner.nextLine(); // clear newline

        Order order = orders.get(index);

        System.out.println("Choose what to update:");
        System.out.println("1 - Order status");
        System.out.println("2 - Payment");
        System.out.println("3 - Delivery status");

        int option = Scanner.nextInt();
        Scanner.nextLine();

        switch (option) {
            case 1:
                System.out.println("Enter new status:");
                String newStatus = Scanner.nextLine();
                order.updateStatus(newStatus);
                break;
            case 2:
                if (!order.isPaid()) {
                    System.out.println("Enter payment method (Card/Cash):");
                    String method = Scanner.nextLine();
                    order.pay(method);
                } else {
                    System.out.println("This order is already paid.");
                }
                break;
            case 3:
                System.out.println("Enter delivery status (Preparing / Out for Delivery / Delivered):");
                String deliveryStatus = Scanner.nextLine();
                order.updateDeliveryStatus(deliveryStatus);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }


    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        while (true) {
            int choose;
            System.out.println("enter 1 for create a customer");
            System.out.println("enter2 for create a menuItem");
            System.out.println("enter 3 for make an order");
            System.out.println("enter 4 for update order");
            System.out.println("enter 5 for exit");

            do {
                System.out.println("enter your choose");
                while (!Scanner.hasNextInt()) {
                    System.out.println("Please enter a number!");
                    Scanner.next();
                }
                choose = Scanner.nextInt();
                Scanner.nextLine(); // consume leftover newline
            } while (choose < 1 || choose > 5);

            switch (choose) {
                case 1:
                    createCustomer(restaurant);
                    break;
                case 2:
                    createMenuItem(restaurant);
                    break;
                case 3:
                    UpdateOrder(restaurant);
                    break;
                case 4:
                    // Reserved for future
                    break;
                case 5:
                    System.exit(0); // Exit cleanly
                    break;
            }

        }
    }
}