# Food Ordering System 🍽️

## Overview
This is a **Food Ordering System** built using **OOP principles in Java**. Users can browse a menu, place orders, and restaurant staff can manage orders.

## Features
- Customers can view the menu and place an order.
- Each order has multiple items.
- Restaurant staff can update order status.

## Classes & Structure
```plaintext
FoodOrderingSystem
 ├── MenuItem
 ├── Order
 ├── Customer
 ├── Restaurant
 ├── Main (Runner)
```

## Implementation

### `MenuItem.java`
```java
public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```

### `Order.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
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

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
```

### `Customer.java`
```java
public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Order placeOrder(MenuItem... items) {
        Order order = new Order();
        for (MenuItem item : items) {
            order.addItem(item);
        }
        System.out.println(name + " placed an order. Total: $" + order.calculateTotal());
        return order;
    }
}
```

### `Restaurant.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Order> orders;

    public Restaurant() {
        this.orders = new ArrayList<>();
    }

    public void receiveOrder(Order order) {
        orders.add(order);
        System.out.println("New order received. Status: " + order.getStatus());
    }

    public void updateOrderStatus(Order order, String status) {
        order.updateStatus(status);
        System.out.println("Order status updated to: " + status);
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        MenuItem burger = new MenuItem("Burger", 5.99);
        MenuItem pizza = new MenuItem("Pizza", 8.99);

        Customer customer = new Customer("Alice");
        Order order = customer.placeOrder(burger, pizza);
        restaurant.receiveOrder(order);
        
        restaurant.updateOrderStatus(order, "In Progress");
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Add payment integration.
- Implement a delivery tracking system.
- Improve user interface with a GUI.

---
🍕 **Order your favorite meals easily!** 🍔
