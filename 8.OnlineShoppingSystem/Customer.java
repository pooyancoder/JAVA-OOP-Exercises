import java.util.Scanner;

public class Customer {
    public Scanner scanner = new Scanner(System.in);
    private final String name;
    private final ShoppingCart cart;
    private final String password;

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
        this.cart = new ShoppingCart();
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void placeOrder() {
        cart.checkout();
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void makeOrder(Store store) {
        do {
            store.showProductList();
            System.out.println("enter your choice to add the product to your shopping cart -1 to close");
            int choice = scanner.nextInt();
            if (choice < -1 || choice >= store.getProductList().size())
                continue;
            else if (choice == -1) {
                break;
            }else
                addToCart(store.getProductList().get(choice));
        } while (true);
        if (cart.getItems().isEmpty()){
            System.out.println("no product added to cart!");
        }else {
            cart.setPaid(false);
            cart.showItems();
            System.out.println(cart.calculateTotal());
        }
    }

    public void payOrder() {
        if (!cart.isPaid()){
            placeOrder();
        }
    }
}