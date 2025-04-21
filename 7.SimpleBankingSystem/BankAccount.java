import java.util.ArrayList;

public class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected ArrayList<String> History;

    public BankAccount(){}

    public BankAccount(String accountNumber) {
        History = new ArrayList<>();
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            History.add(String.valueOf(amount));
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            History.add("-"+String.valueOf(amount));
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showHistory(){
        for (String s : History){
            System.out.println(s);
        }
    }
}