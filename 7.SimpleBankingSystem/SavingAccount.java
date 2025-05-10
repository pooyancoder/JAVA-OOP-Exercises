import java.lang.Math;

public class SavingAccount extends BankAccount{
    private int interested;

    public SavingAccount(String AccountNumber , int Lasting , double Balance) {
        super(AccountNumber, Balance);
        this.interested = Lasting;
    }

    public int getInterested(){
        return interested;
    }

    public void interest(){
        if(interested == 0){
            return;
        }
        balance = balance*1.2;   //nadide begir ino
        this.interested --;
    }
}
