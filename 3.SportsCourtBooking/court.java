import java.util.Scanner;

public class court {
    private String courtNAme;
    private boolean iSAvailable;
    private player booker;

    Scanner Scanner = new Scanner(System.in);

    public player getBooker(){
        return this.booker;
    }

    public court(String name){
        this.courtNAme = name;
        iSAvailable = true;
    }

    public boolean isiSAvailable(){
        return iSAvailable;
    }

    public void setCourt(player bookMAn){
            iSAvailable = false;
            this.booker = bookMAn;
            System.out.println("the court"+courtNAme+"booked by"+bookMAn);
    }
    public void deletePlayer(){
        this.courtNAme ="";
        iSAvailable = true;
        this.booker = null;
    }

    public String getCourtNAme(){
        return this.courtNAme;
    }
}