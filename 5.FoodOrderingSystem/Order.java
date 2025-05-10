import java.util.ArrayList;


public class Order {
    private final ArrayList<MenuItem> menuItems;
    private String status;

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Order() {
        this.menuItems = new ArrayList<>();
        this.status = "Pending";
    }

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public boolean isPaid() {
        return (status.equalsIgnoreCase("card") || status.equalsIgnoreCase("cash"));
    }


    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : menuItems) {
            total += item.getPrice();
        }
        return total;
    }


    public void updateStatus(String status) {
        this.status = status;
        System.out.println("status changed!");
    }

    public String getStatus() {
        return status;
    }

    public void printSummary() {
        System.out.println("Order Summary:");
        for (MenuItem item : menuItems) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
        System.out.println("Status: " + status);
    }

}