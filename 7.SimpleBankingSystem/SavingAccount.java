import java.lang.Math;

public class SavingAccount extends BankAccount{
    private int MonthLasting;
    private double balance;
    private int interested;

    public SavingAccount(String AccountNumber , int Lasting , double Balance) {
        super(AccountNumber);
        this.MonthLasting = Lasting;
        this.interested = Lasting;
        this.balance = Balance;
    }

    public void interest(){
        if(interested == 0){
            return;
        }
        balance = balance * Math.pow(1.1 , 1);   //nadide begir ino
        this.interested --;
    }
}
