import java.util.ArrayList;


public class Store {
    private ArrayList<Product> productList;
    private ArrayList<Customer> customers;

    public Store() {
        this.customers = new ArrayList<>();
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
        System.out.println(product.getName() + " added to store.");
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void showProductList() {
        System.out.println("*********store product list*********");
        if (productList.isEmpty()) {
            System.out.println("no item to show!");
        } else {
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(i + ". " + productList.get(i).getName() + " " + productList.get(i).getPrice());
            }
        }
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean semeName(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name))
                return true;
        }
        return false;
    }

    public void checkOrder(Customer customer) {
        customer.makeOrder(this);
    }
}