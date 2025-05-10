import java.util.Scanner;

public class Main {
    static Scanner StringScanner = new Scanner(System.in);
    static Scanner IntScanner = new Scanner(System.in);

    static void AddCustomer(Bank bank) {
        System.out.println("customer name ?\n" + ">>");
        String customerName = StringScanner.nextLine();
        System.out.println("customer account number ?\n" + ">>");
        String accountNumber = StringScanner.nextLine();

        System.out.println("\n>>>>>>>>>>>><<<<<<<<<<<");
        System.out.println("1. for current account");
        System.out.println("2. for saving account");
        int choice = IntScanner.nextInt();

        switch (choice) {
            case 1: {
                CurrentAccount CA = new CurrentAccount(accountNumber);
                Customer c = new Customer(customerName, CA);
                bank.addCustomer(c);
                System.out.println("\nCustomer namely " + customerName + " successfully added to bank!\n");
                break;
            }
            case 2: {
                System.out.println("enter first balance\n >>");
                double balance = IntScanner.nextDouble();
                System.out.println("enter your account lasting (in month)\n >>");
                int lasting = IntScanner.nextInt();
                SavingAccount s = new SavingAccount(accountNumber, lasting, balance);
                Customer c = new Customer(customerName, s);
                bank.addCustomer(c);
                System.out.println("\ncustomer namely " + customerName + " successfully added to bank!\n");
            }
        }
    }

    static void accessAccount(Bank bank) {
        System.out.println(">>>>>>>>welcome to access Account function");
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            System.out.println(i + ".  " + bank.getCustomers().get(i).getName() + " : " + bank.getCustomers().get(i).getAccount().getClass().getSimpleName());
        }

        System.out.println("\n which customer's account you want access?\n");
        int choice = IntScanner.nextInt();
        Customer Customer = bank.getCustomers().get(choice);

        System.out.println("1. depositMoney");
        System.out.println("2. withdraw");
        System.out.println("3. get balance");
        System.out.println("4. showHistory");
        System.out.println("5. interesting (only saving account)");
        System.out.print(">>");

        int work = IntScanner.nextInt();
        switch (work) {
            case 1: {
                System.out.println("how much you would add ?");
                double money = IntScanner.nextDouble();
                Customer.getAccount().deposit(money);
                break;
            }
            case 2: {
                System.out.println("how much you would catch ?");
                double money = IntScanner.nextDouble();
                Customer.getAccount().withdraw(money);
                break;
            }
            case 3: {
                System.out.println("balance equals : " + Customer.getAccount().getBalance());
                break;
            }
            case 4: {
                Customer.getAccount().showHistory();
                System.out.println('\n');
                break;
            }
            case 5: {
                if (Customer.getAccount().getClass().equals(SavingAccount.class)) {
                    SavingAccount s = (SavingAccount) Customer.getAccount();
                    System.out.println(s.getInterested());
                } else {
                    System.out.println("your choice is not saving account!");
                }
                break;
            }
            default:
                break;
        }
    }

    static void showAccounts(Bank bank) {
        System.out.println(">>>>>>>>>>><<<<<<<<<<<\nwelcome to our bank!\n");
        for (Customer c : bank.getCustomers()) {
            System.out.println("customer " + " namely " + c.getName());
            System.out.println("account type : " + c.getAccount().getClass().getSimpleName());
            System.out.println("account number : " + c.getAccount().getAccountNumber());
            System.out.println("balance : " + c.getAccount().getBalance());
            if (c.getAccount().getClass().getSimpleName().equals("SavingAccount")) {
                SavingAccount s = (SavingAccount) c.getAccount();
                System.out.println("interesting lasted :" + s.getInterested());
            }
            System.out.println();
        }
    }

    static void interest(Bank bank) {
        System.out.println("________time to interest________");
        for (Customer c : bank.getCustomers()) {
            if (c.getAccount().getClass().equals(SavingAccount.class)) {
                SavingAccount s = (SavingAccount) c.getAccount();
                System.out.println(c.getName() + "'s account");
                System.out.println("balance before interest " + s.getBalance());
                s.interest();
                System.out.println("balance after interest " + s.getBalance());
            }
        }
    }


    public static void main(String[] args) {
        Bank bank = new Bank();
        do {
            int choose = 1;
            do {
                if (choose < 1 || choose > 5) {
                    System.out.println("Enter a number in range!");
                }
                System.out.println("\n>>>>>>bank menu<<<<<<<<");
                System.out.println("1. add customer in bank");
                System.out.println("2. for access to an account");
                System.out.println("3. show accounts and balances");
                System.out.println("4. Interest saving accounts");
                System.out.println("5. for exit");
                System.out.print("> Enter ");
                choose = IntScanner.nextInt();
                System.out.println(">----------------------------<\n");
            } while (choose < 1 || choose > 5);
            switch (choose) {
                case 1: {
                    AddCustomer(bank);
                    continue;
                }
                case 2: {
                    accessAccount(bank);
                    continue;
                }
                case 3: {
                    showAccounts(bank);
                    continue;
                }
                case 4: {
                    interest(bank);
                    continue;
                }
                case 5: {
                    return;
                }
            }
        } while (true);

    }
}