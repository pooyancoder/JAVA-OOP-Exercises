# Simple Banking System 💰

## Overview
This is a **Simple Banking System** built using **OOP principles in Java**. It allows users to create bank accounts, deposit, withdraw, and check balances.

## Features
- Users can create bank accounts.
- Perform deposits and withdrawals.
- Check account balance.
- Prevent overdraft withdrawals.

## Classes & Structure
```plaintext
SimpleBankingSystem
 ├── BankAccount
 ├── Customer
 ├── Bank
 ├── Main (Runner)
```

## Implementation

### `BankAccount.java`
```java
public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
```

### `Customer.java`
```java
public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    public void withdrawMoney(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println(name + "'s balance: $" + account.getBalance());
    }
}
```

### `Bank.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer);
    }
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");
        
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        
        customer1.depositMoney(500);
        customer1.withdrawMoney(200);
        customer1.checkBalance();
    }
}
```

## How to Run
1. If you use new versions of java you can compile and run your code with this command in the terminal that is in your folder path:
   ```bash
   java fileName.java
   ```

## Future Enhancements
- Implement an interest system for savings accounts.
- Add online banking features.
- Introduce transaction history tracking.

---
🏦 **Manage your finances with ease!** 💳
