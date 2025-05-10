public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        System.out.println("price up to date " + price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}