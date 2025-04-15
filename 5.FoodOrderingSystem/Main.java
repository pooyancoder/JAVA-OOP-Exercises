import java.util.ArrayList;
import java.util.Scanner;


public class Main {
   static Scanner  Scanner = new Scanner(System.in);

   static void  createCustomer(Restaurant r){
       System.out.println("Enter Customer name");
       String cName = Scanner.nextLine();
       Customer customer = new Customer(cName);
       ArrayList<MenuItem> menu = r.getMenu();
       for(MenuItem m : menu){
           System.out.println(".. "+m.getName()+" "+m.getPrice());
       }
       ArrayList<MenuItem> CustomerMenu = new ArrayList<>();
       String Choose = "";
       do{
           System.out.println("Enter your choose 0 to finish the order");
           Choose = Scanner.nextLine();
           for(MenuItem m : menu){
               if(Choose.equals(m.getName())){
                   CustomerMenu.add(m);
               }
           }
       }while (!Choose.equals("0"));
       Order newOrder = customer.placeOrder(CustomerMenu);
       System.out.println("The price equals "+newOrder.calculateTotal()+"dollars!");
       r.receiveOrder(newOrder);
       System.out.println("The Order Successfully received");
   }

   static void createMenuItem(Restaurant r){
       System.out.println("enter menu Price");
       System.out.println("enter menu name");
       int price = Scanner.nextInt();
       String name = Scanner.nextLine();
       MenuItem newMenu = new MenuItem(name , price);
       r.items.add(newMenu);
   }

    static void UpdateOrder(Restaurant r){
       for(Order o : r.getOrders()){
           System.out.println(o.getStatus());
       }
        System.out.println("Enter your choose which one should change?");
       int choose = Scanner.nextInt();
       ArrayList<Order> Orders = r.getOrders();
       Order o = Orders.get(choose);
        System.out.println("Enter your own Status");
        String Status = Scanner.nextLine();
       o.updateStatus(Status);
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        while (true){
            int choose;
            System.out.println("enter 1 for create a customer");
            System.out.println("enter2 for create a menuItem");
            System.out.println("enter 3 for make an order");
            System.out.println("enter 4 for update order");
            System.out.println("enter 5 for exit");

            do {
                System.out.println("enter your choose");
                choose = Scanner.nextInt();
                if(choose<5 && choose>0)
                    break;
            }while (true);

            switch (choose){
                case 1 :{
                   createCustomer(restaurant);
                }
                case 2 :{
                    createMenuItem(restaurant);
                }
                case 3 :{
                    UpdateOrder(restaurant);
                }
                case 4 :{
                    break;
                }
            }
        }
    }
}