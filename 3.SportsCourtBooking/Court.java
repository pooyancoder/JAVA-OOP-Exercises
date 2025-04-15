import java.util.Scanner;

public class Court {
    private String courtNAme;
    private boolean iSAvailable;
    private Player booker;

    java.util.Scanner Scanner = new Scanner(System.in);

    public Player getBooker(){
        return this.booker;
    }

    public Court(String name){
        this.courtNAme = name;
        iSAvailable = true;
    }

    public boolean isiSAvailable(){
        return iSAvailable;
    }

    public void setCourt(Player bookMAn){
        iSAvailable = false;
        this.booker = bookMAn;
        System.out.println("the court"+courtNAme+"booked by"+bookMAn);
    }
    public void deletePlayer(){
        iSAvailable = true;
        this.booker = null;
    }

    public String getCourtNAme(){
        return this.courtNAme;
    }
}
