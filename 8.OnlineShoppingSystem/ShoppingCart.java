import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;
    private boolean isPaid;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public List<Product> getItems() {
        return items;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void checkout() {
        System.out.println("order placed!\nready to pay ...");
        System.out.println("Total amount: $" + calculateTotal());
        System.out.println("Order paid successfully!");
        isPaid = true;
        items.clear();
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("no item to show!");
        } else {
            System.out.println("items you ordered :");
            for (int i = 0; i < items.size(); i++) {
                System.out.println(i + ". " + items.get(i).getName() + " " + items.get(i).getPrice());
            }
            System.out.println("\ntotally amount : " + calculateTotal());
        }
    }


}