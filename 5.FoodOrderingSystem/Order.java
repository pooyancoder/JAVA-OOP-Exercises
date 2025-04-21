import java.util.ArrayList;
import java.util.List;

public class Order {
    private ArrayList<MenuItem> items;
    private String status;
    private String deliveryStatus = "Preparing";

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public boolean isPaid(){
        return (status.equalsIgnoreCase("card") || status.equalsIgnoreCase("cash"));
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
        System.out.println("Delivery status updated to: " + status);
    }

    public void pay (String s){
        this.status = s;
    }


    public Order() {
        this.items = new ArrayList<>();
        this.status = "Pending";
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void finalizeOrder(Restaurant r) {
        if (this.status.equalsIgnoreCase("Paid")) {
            this.status = "Completed";
            System.out.println("Order finalized and marked as Completed.");
        } else {
            System.out.println("Cannot finalize. Payment not received yet.");
        }
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
        for (MenuItem item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
        System.out.println("Status: " + status);
    }

}