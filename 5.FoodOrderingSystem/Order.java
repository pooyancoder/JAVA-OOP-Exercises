import java.util.ArrayList;
import java.util.List;

public class Order {
    private ArrayList<MenuItem> items;
    private String status;

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

//    public void finaliize(Restaurant r){
//        if(this.status.equals("payed")){
//            for(Order o : r.getOrders()){
//               if()
//            }
//        }
//    }

    public void updateStatus(String status) {
        this.status = status;
        System.out.println("status changed!");
    }

    public String getStatus() {
        return status;
    }
}