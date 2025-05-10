# Online Shopping System 🛒

## Overview
This is an **Online Shopping System** built using **OOP principles in Java**. It allows customers to browse products, add them to a cart, and complete purchases.

## Features
- Customers can browse products.
- Add products to a shopping cart.
- Checkout and view order summary.

## Classes & Structure
```plaintext
OnlineShoppingSystem
 ├── Product
 ├── ShoppingCart
 ├── Customer
 ├── Store
 ├── Main (Runner)
```

## Implementation

### `Product.java`
```java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
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

### `ShoppingCart.java`
```java
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void checkout() {
        System.out.println("Total amount: $" + calculateTotal());
        System.out.println("Order placed successfully!");
        items.clear();
    }
}
```

### `Customer.java`
```java
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
```

### `Store.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> inventory;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        inventory.add(product);
        System.out.println(product.getName() + " added to store.");
    }

    public List<Product> getProducts() {
        return inventory;
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Product laptop = new Product("Laptop", 999.99);
        Product phone = new Product("Smartphone", 499.99);
        
        store.addProduct(laptop);
        store.addProduct(phone);
        
        Customer customer = new Customer("Alice");
        customer.addToCart(laptop);
        customer.addToCart(phone);
        customer.placeOrder();
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Implement payment gateway integration.
- Add order history tracking.
- Introduce user authentication.

---
🛍️ **Enjoy seamless online shopping!** 💳
