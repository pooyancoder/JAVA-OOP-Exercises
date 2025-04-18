import java.util.Scanner;
import java.util.List;

public class Main {
    static Scanner StringScanner = new Scanner(System.in);
    static Scanner IntScanner = new Scanner(System.in);

    static void addProduct(Store store){
        String name;
        int price;
        System.out.println("you would add a item");
        System.out.println("Enter your product's name");
        name = StringScanner.nextLine();
        System.out.println("Enter your product's price");
        price = IntScanner.nextInt();
        Product p  = new Product(name , price);
        store.addProduct(p);
        return;
    }

    static void showProducts(Store store){
        List<Product> products = store.getProducts();
        for(Product p : products){
            System.out.println(p.getName()+" with price "+p.getPrice()+"$");
        }
        return;
    }

    static void addCustomer(Store store){
        String name;
        System.out.println("Enter your customer name");
        name = StringScanner.nextLine();
        Customer customer = new Customer(name);
        int maxChoice = store.getProducts().size();
        showProducts(store);
        System.out.println("Enter your choices number! how many do you need?");
        int choice = 0;
        do {
            System.out.println("Enter your choice");
            choice = IntScanner.nextInt();
        }while (choice>maxChoice || choice<0);
        if(choice == 0){
            System.out.println("You wouldn't buy as you choosed so good F..K");
            return;
        }
        for (int i = 1; i <= choice ; i++) {
            Product p = null;
            System.out.println("Enter your pro's name");
            String pNAme = StringScanner.nextLine();
            for(Product pro : store.getProducts()){
                if (pNAme.equals(pro.getName())){
                    customer.addToCart(pro);
                    System.out.println("the product successfully added to shoppingCart");
                    p = pro;
                    break;
                }
            }
                System.out.println("we don't have something like you need");
        }
        customer.placeOrder();
    }


    public static void main(String[] args){
        Store Store = new Store();
        System.out.println("*****Welcome to our online shopping center!*****");
        System.out.println("Choose an item to start shopping");
        do {
            int choose=2;
            do {
                if(choose<1 || choose>4){
                    System.out.println("Enter a number in range!");
                }
                System.out.println("Enter "+1+" for add a product to store");
                System.out.println("Enter "+2+" for show shop products list");
                System.out.println("Enter "+3+" for add a customer for making a shoppingcart");
                System.out.println("Enter "+4+" for exit");
//                System.out.println("Enter"+5+"for");
                choose = IntScanner.nextInt();
            }while (choose<1 || choose>4);
            switch (choose){
                case 1 :{
                    addProduct(Store);
                    continue;
                }
                case 2 :{
                    showProducts(Store);
                    continue;
                }
                case 3 :{
                    addCustomer(Store);
                    continue;
                }
                case 4 :{
                    break;
                }
            }
        }while (true);
    }
}