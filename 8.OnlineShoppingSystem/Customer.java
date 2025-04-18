public class Customer {
    private String name;
    private ShoppingCart cart;

    public Customer(String name) {
        this.name = name;
        this.cart = new ShoppingCart();
    }

    public void addToCart(Product product) {
        cart.addItem(product);
    }

    public void placeOrder() {
        cart.checkout();
    }
}