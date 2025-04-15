import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static public Scanner StringScanner = new Scanner(System.in);


    static void  builtPlayer(){
        String name = StringScanner.nextLine();
        Player p = new Player(name);
    }
    static void deletePlayer(Admin admin){
        String playerName = StringScanner.nextLine();
        for(Player p : Player.players){
            if(p.getName().equals(playerName)){
                p.deletePlayer(p , admin);
                System.out.println("player"+playerName+" deleted from courts and the player static list ");
                ArrayList<Player> pl = admin.getPlayerlist();
                for(Player p1 : pl){
                    if(p1.getName().equals(p)){
                        admin.playerlist.remove(p1);
                        System.out.println("player"+playerName+"successfully deleted from admin player list");

                    }
                }
            }
        }
    }

    static void  bookCourt(Admin admin){
        ArrayList<Player> players= Player.players;
        ArrayList<Court> courts = admin.getCourts();

        for(Player p : players){
            System.out.println( p.getName());
        }
        System.out.println("choose a player");
        String player = StringScanner.nextLine();
        for(Player p : players){
            if(player.equals(p.getName())){
                for(Court c : courts){
                    System.out.println(c.getCourtNAme());
                }
                String AimCourt = StringScanner.next();
                for(Court c : courts){
                    if(c.getCourtNAme().equals(AimCourt)){
                        c.setCourt(p);
                        return;
                    }
                }
            }
        }
    }

    static void CreateCourt(Admin admin){
        String courtNAme;
        boolean again = true;
        do {
            System.out.println("enter court name you want add");
            courtNAme = StringScanner.nextLine();
            for(Court c : admin.getCourts()){
                if(courtNAme.equals(c.getCourtNAme())){
                    again  = true;
                    break;
                }else{
                    again = false;
                }
            }
        }while (again);
        Court court1 = new Court(courtNAme);
        admin.setCourt(court1);
        System.out.println("court "+courtNAme+" successfully Added");
    }





    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner Scanner = new Scanner(System.in);

        boolean isEnd = false;
        while (!isEnd){
            int choose = 0;
            System.out.println("Enter"+1+"for add player");
            System.out.println("Enter"+2+"for delete player");
            System.out.println("Enter"+3+"for book a court");
            System.out.println("Enter"+4+"for create court");
            System.out.println("Enter"+5+"for exit");

            do {
                choose = Scanner.nextInt();
                if(choose<1 || choose>5){
                    System.out.println("enter a number5 between 1 and 4");
                }
            }while(choose<1 || choose>5);
            switch (choose){
                case 1 :{
                    builtPlayer();
                }
                case 2 :{
                    deletePlayer(admin);
                }
                case 3 :{
                    bookCourt(admin);
                }
                case 4 :{
                    CreateCourt(admin);
                }
                case 5 :{
                    isEnd =true;
                }
            }
        }
    }
}
