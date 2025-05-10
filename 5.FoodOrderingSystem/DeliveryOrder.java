public class DeliveryOrder extends Order {
    private String deliveryStatus = "Preparing";

    public DeliveryOrder(){
        super();
        deliveryStatus = "preparing";
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String status) {
        this.deliveryStatus = status;
        System.out.println("Delivery status updated to: " + status);
    }
}
