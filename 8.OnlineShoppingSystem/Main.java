import java.util.Scanner;

public class Main {
    static Scanner StringScanner = new Scanner(System.in);
    static Scanner IntScanner = new Scanner(System.in);

    static void makeAccount(Store store) {
        System.out.println("\n-------makeAccount-------");
        System.out.println("enter your account name!\n");
        String customerName;

        do {
            customerName = StringScanner.nextLine();
            if (store.semeName(customerName)) {
                System.out.println("the customer with same name already exist!");
                System.out.println("1. try another name");
                System.out.println("2. go to menu");
                int choice = IntScanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("try another name :");
                        continue;
                    case 2:
                        return;
                }
            }
        } while (store.semeName(customerName));

        System.out.println("choose a password for your account\nat least 8 characters :");
        String password;
        do {
            password = StringScanner.nextLine();
            if (password.length() < 8) {
                System.out.println("enter a password in 8 characters :");
            }
        } while (password.length() < 8);
        Customer newCustomer = new Customer(customerName, password);
        store.getCustomers().add(newCustomer);
        System.out.println(customerName + " successfully added to customer list\n");
        System.out.println("do you want to check an order out?");
        System.out.println("1. yes\n2. no");
        int choice = IntScanner.nextInt();
        switch (choice) {
            case 1:
                store.checkOrder(newCustomer);
            case 2:
                break;
        }
    }

    static void login(Store store) {
        System.out.println("-------LOGIN-----");
        System.out.println("for login to your account enter your account name and password correctly");
        boolean repeat;
        do {
            repeat = true;
            System.out.print("user name :\n>");
            String username = StringScanner.nextLine();
            System.out.print("password :\n>");
            String password = StringScanner.nextLine();
            for (Customer c : store.getCustomers()) {
                if (c.getName().equals(username) && c.getPassword().equals(password)) {
                    repeat = false;
                    do {
                        System.out.println("1. see existing order");
                        System.out.println("2. make new order");
                        System.out.println("3. pay last order cost");
                        System.out.print("4. to exit\n>");

                        int choice = IntScanner.nextInt();
                        switch (choice) {
                            case 1: {
                                c.getCart().showItems();
                                continue;
                            }
                            case 2: {
                                if (c.getCart().isPaid()) {
                                    c.makeOrder(store);
                                } else {
                                    System.out.println("you did not paid the last order cost");
                                }
                                continue;
                            }
                            case 3: {
                                c.payOrder();
                                continue;
                            }
                            case 4: {
                                return;
                            }
                        }
                    } while (true);
                }//
            }
            if (repeat) {
                System.out.println("wrong user name or password");
                System.out.println("1. continue\n2. go to menu");
                int choice1 = IntScanner.nextInt();

                switch (choice1) {
                    case 1: {
                        continue;
                    }
                    case 2: {
                        return;
                    }
                }
            }
        } while (repeat);
    }

    static void storeProducts(Store store) {
        System.out.println("-------store products-------");
        System.out.println("1. show products");
        System.out.println("2. add a product");

        int choice = IntScanner.nextInt();
        switch (choice) {
            case 1: {
                store.showProductList();
                break;
            }
            case 2: {
                addProduct(store);
            }
        }
    }

    static void addProduct(Store store) {
        System.out.println("-------add product-------");
        String name;
        double price;
        boolean Continue = false;
        do {
            System.out.print("enter product's name\nenter existing product name and also new price to make its price up to date\nenter -1 to exit\n>");
            name = StringScanner.nextLine();
            if (name.equalsIgnoreCase("-1"))
                return;
            System.out.print("enter product's price\n>");
            price = IntScanner.nextInt();
            for (Product p : store.getProductList()) {
                if (p.getName().equalsIgnoreCase(name) && p.getPrice() == price) {
                    System.out.println("the same product already exist!");
                    System.out.print("1. add new product\n2. go to menu\n>");
                    int choice = IntScanner.nextInt();
                    switch (choice) {
                        case 1: {
                            Continue = true;
                            continue;
                        }
                        case 2: {
                            return;
                        }
                        default:
                            System.out.println("wrong entry!");
                            return;
                    }
                } else if (p.getName().equalsIgnoreCase(name)) {
                    p.setPrice(price);
                    return;
                }
            }
        } while (Continue);
        store.addProduct(new Product(name, price));
    }

    public static void main(String[] args) {
        Store store = new Store();
        System.out.println("*****Welcome to our online shop!*****");
        do {
            int choose = 3;
            do {
                if (choose < 1 || choose > 5) {
                    System.out.println("Enter a number in range!");
                }
                System.out.println("--------shop menu---------");
                System.out.println("1. make an account");
                System.out.println("2. login");
                System.out.println("3. view shop products");
                System.out.println("4. store products");
                System.out.println("5. exit");
                System.out.print(">");
                choose = IntScanner.nextInt();
            } while (choose < 1 || choose > 5);
            switch (choose) {
                case 1: {
                    makeAccount(store);
                    continue;
                }
                case 2: {
                    login(store);
                    continue;
                }
                case 3: {
                    store.showProductList();
                    continue;
                }
                case 4: {
                    storeProducts(store);
                    continue;
                }
                case 5: {
                    return;
                }
            }
        } while (true);
    }
}