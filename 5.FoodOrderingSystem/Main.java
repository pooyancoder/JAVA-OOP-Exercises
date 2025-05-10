import java.util.Scanner;


public class Main {
    static Scanner IntScanner = new Scanner(System.in);
    static Scanner StringScanner = new Scanner(System.in);

    static void customers(Restaurant restaurant) {
        System.out.println("-----customers------");
        System.out.println("1. create a customer");
        System.out.println("2. show customers\n");

        int choice = IntScanner.nextInt();
        switch (choice) {
            case 1: {
                createCustomer(restaurant);
                break;
            }
            case 2: {
                restaurant.showCustomers();
                break;
            }
        }

    }

    static void orders(Restaurant restaurant) {
        System.out.println("-----orders------");
        System.out.println("1. change status");
        System.out.println("2. change deliveryStatus (only for delivery status)\n");

        System.out.println("\nenter your choice");
        int choice = IntScanner.nextInt();

        switch (choice) {
            case 1: {
                changeStatus(restaurant);
                break;
            }
            case 2: {
                changeDeliveryStatus(restaurant);
                break;
            }
            default:
        }

    }

    static void menuItems(Restaurant restaurant) {
        System.out.println("-----menuItems------");
        System.out.println("1. add a Item ");
        System.out.println("2. delete a Item ");
        System.out.println("3. show Items ");

        System.out.println("\nenter your choice");
        int choice = IntScanner.nextInt();

        switch (choice) {
            case 1: {
                addItem(restaurant);
                break;
            }
            case 2: {
                deleteItem(restaurant);
                break;
            }
            case 3: {
                restaurant.showItems();
            }
            default:
        }
    }

    static void createCustomer(Restaurant restaurant) {
        System.out.println("-------create customer--------");
        System.out.println("enter customers name");
        Order newOrder;
        Customer newCustomer;
        String name = StringScanner.nextLine();


        System.out.println("do you want have delivery?");
        System.out.println("1. yes");
        System.out.println("2. no");
        int delivery = IntScanner.nextInt();

        switch (delivery) {
            case 1: {
                newOrder = new DeliveryOrder();
                System.out.println("now choice your Items");

                while (true) {
                    restaurant.showItems();
                    int choice;
                    do {
                        System.out.println("enter number food you would\nenter -1 to exit");
                        choice = IntScanner.nextInt();
                    } while (choice >= restaurant.getMenu().size() || choice < -1);
                    if (choice == -1)
                        break ;
                    else {
                        newOrder.addItem(restaurant.getMenu().get(choice));
                    }
                }
               if (!newOrder.getMenuItems().isEmpty()){
                   newCustomer = new Customer(name, newOrder);
                   System.out.println("customer successfully added!\n");
                   newCustomer.getOrder().printSummary();
                   restaurant.getCustomers().add(newCustomer);
                   restaurant.getOrders().add(newCustomer.getOrder());
               }
                break;
            }
            case 2: {
                newOrder = new Order();
                System.out.println("now choice your Items");

                while (true) {
                    restaurant.showItems();
                    int choice;
                    do {
                        System.out.println("enter number food you would\nenter -1 to exit");
                        choice = IntScanner.nextInt();
                    } while (choice >= restaurant.getMenu().size() || choice < -1);
                    if (choice == -1)
                        break ;
                    else {
                        newOrder.addItem(restaurant.getMenu().get(choice));
                    }
                }
                if (!newOrder.getMenuItems().isEmpty()){
                    newCustomer = new Customer(name, newOrder);
                    System.out.println("customer successfully added!\n");
                    newCustomer.getOrder().printSummary();
                    restaurant.getCustomers().add(newCustomer);
                    restaurant.getOrders().add(newCustomer.getOrder());
                }
                break;
            }
            default: {
                System.out.println("invalid choice");
            }
        }
    }

    static void changeStatus(Restaurant restaurant) {
        System.out.println("-------change status---------");
        restaurant.showCustomers();
        if (restaurant.getOrders().isEmpty()){
            System.out.println("no order to change!\n");
            return;
        }
        System.out.println("\nnow choice\n>");
        int choice = IntScanner.nextInt();
        System.out.println("enter status :\n>");
        String status = StringScanner.nextLine();
        restaurant.getCustomers().get(choice).getOrder().updateStatus(status);
        if (restaurant.getCustomers().get(choice).getOrder().isPaid()) {
            System.out.println("an order closed! pattern : " + restaurant.getCustomers().get(choice).getOrder().getStatus());
        }
    }

    static void changeDeliveryStatus(Restaurant restaurant) {
        System.out.println("-------change delivery status---------");
        restaurant.showDeliveryOrders();
        if (restaurant.getOrders().isEmpty()){
            System.out.println("no order to change!\n");
            return;
        }
        System.out.println("\nenter shown numbers to change");
        int choice = IntScanner.nextInt();
        DeliveryOrder order = (DeliveryOrder) restaurant.getCustomers().get(choice).getOrder();
        System.out.println("enter the status\n");
        String status = StringScanner.nextLine();
        order.setDeliveryStatus(status);
    }

    static void addItem(Restaurant restaurant) {
        System.out.println("-------add Item in restaurant menu---------");
        restaurant.showItems();
        System.out.println("Enter menuItem name :\n>");
        String newItemName = StringScanner.nextLine();
        System.out.println("Enter menuItem price :\n>");
        double price = IntScanner.nextDouble();
        for (MenuItem m : restaurant.getMenu()) {
            if (newItemName.equalsIgnoreCase(m.getName()) && price == m.getPrice()) {
                System.out.println("Item exist now!");
                return;
            }
        }
        for (int i = 0; i < restaurant.getMenu().size(); i++) {
            if (newItemName.equalsIgnoreCase(restaurant.getMenu().get(i).getName())) {
                restaurant.getMenu().set(i, new MenuItem(newItemName, price));
                System.out.println("Item " + newItemName + "'s price up to date : " + price);
                return;
            }
        }
        restaurant.receiveItem(new MenuItem(newItemName, price));
        System.out.println("new Item added\n");
    }

    static void deleteItem(Restaurant restaurant) {
        System.out.println("------delete Item-------");
        restaurant.showItems();
        System.out.println("\nenter item name to delete :\n>");
        String deleteItem = StringScanner.nextLine();
        for (MenuItem m : restaurant.getMenu()) {
            if (deleteItem.equalsIgnoreCase(m.getName())) {
                restaurant.getMenu().remove(m);
                System.out.println(m.getName() + " successfully removed\n");
                return;
            }
        }
        System.out.println("there is no such item\n");
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        System.out.println("--------welcome to restaurant---------");

        while (true) {
            int choose;
            System.out.println(">>>>>>>restaurant menu<<<<<<<");
            System.out.println("1. access to customers");
            System.out.println("2. restaurant orders");
            System.out.println("3. restaurant items");
            System.out.print("4. exit\n>");

            do {
                while (!IntScanner.hasNextInt()) {
                    System.out.println("Please enter a number!");
                    IntScanner.next();
                }
                choose = IntScanner.nextInt();
                IntScanner.nextLine(); // consume leftover newline
            } while (choose < 1 || choose > 5);

            switch (choose) {
                case 1:
                    customers(restaurant);
                    break;
                case 2:
                    orders(restaurant);
                    break;
                case 3:
                    menuItems(restaurant);
                    break;
                case 4:
                    System.exit(0); // Exit cleanly
                    break;
                default:
                    break;
            }

        }
    }
}