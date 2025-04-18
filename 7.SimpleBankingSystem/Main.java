import java.util.Scanner;

public class Main {
    static Scanner StringScanner = new Scanner(System.in);
    static Scanner IntScanner = new Scanner(System.in);

    static void AddCustomer(Bank bank){
        System.out.println("Enter your account Number");
        String accountNum = StringScanner.nextLine();
        for(Customer c : bank.getCustomers()){
            if(accountNum.equals(c.getAccount().getAccountNumber())){
                System.out.println("Tish account number you would add is already exist!");
                return;
            }
        }
        BankAccount newAccount = new BankAccount(accountNum);
        System.out.println("Enter customer's name");
        String customerName = StringScanner.nextLine();
        Customer newCustomer = new Customer(customerName , newAccount);
        bank.addCustomer(newCustomer);
    }

    static void accessAccount(Bank bank){
        int members = bank.getCustomers().size();
        for (Customer c : bank.getCustomers()){
            System.out.println(c.getAccount().getAccountNumber());
        }
        System.out.println("Enter as account have been shown choose an account");
        String accountNumber = StringScanner.nextLine();
        for (Customer c : bank.getCustomers()){
            if(c.getAccount().getAccountNumber().equals(accountNumber)){
                int choose = 1;
                System.out.println(1+" for deposit money");
                System.out.println(2+" for withdraw money");
                System.out.println("Enter your choice");
                choose = IntScanner.nextInt();
                if (choose == 1){
                    depMoney(c);
                    return;
                }
                else if (choose == 2) {
                    withMoney(c);
                    return;
                }else {
                    System.out.println("invalid entry!");
                    return;
                }
            }
        }
    }

    static void depMoney(Customer customer){
        System.out.println("customer's balance equals "+customer.getAccount().getBalance());
        System.out.println("Enter your own money");
        int wouldDepositMoney = IntScanner.nextInt();
        customer.depositMoney(wouldDepositMoney);
        System.out.println("Finally balance :"+customer.getAccount().getBalance());
    }

    static void withMoney(Customer customer){
        System.out.println("customer's balance equals "+customer.getAccount().getBalance());
        System.out.println("How many you would catch?\nEnter a positive amount");
        int wouldWithdrawMoney = IntScanner.nextInt();
        customer.withdrawMoney(wouldWithdrawMoney);
        System.out.println("Finally balance :"+customer.getAccount().getBalance());
    }

    static void showAccounts(Bank bank){
        for (Customer c : bank.getCustomers()){
            System.out.println("Customer namely "+c.getName()+" with balance "+c.getAccount().getBalance()+" exist");
        }
    }


    public static void main(String[] args) {
        Bank bank = new Bank();
        do {
            int choose=1;
            do {
                if(choose<1 || choose>4){
                    System.out.println("Enter a number in range!");
                }
                System.out.println("Enter "+1+" for add customer in bank");
                System.out.println("Enter "+2+" for access to an account");
                System.out.println("Enter "+3+" for show accounts and balances");
                choose = IntScanner.nextInt();
            }while (choose<1 || choose>4);
            switch (choose){
                case 1 :{
                    AddCustomer(bank);
                    continue;
                }
                case 2 :{
                    accessAccount(bank);
                    continue;
                }
                case 3 :{
                    showAccounts(bank);
                }
                case 4 :{
                    return;
                }
            }
        }while (true);

    }
}