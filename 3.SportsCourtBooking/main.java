import java.awt.dnd.Autoscroll;
import java.util.Scanner;



public class main {
    static public Scanner StringScanner = new Scanner(System.in);


    static void  builtPlayer(){
        String name = StringScanner.nextLine();
        player p = new player(name);
    }
    static void deletePlayer(admin admin){
        String playerName = StringScanner.nextLine();
        for(player player : player.players){

        }
    }





    public static void main(String[] args) {
        admin admin = new admin();
        Scanner Scanner = new Scanner(System.in);

        boolean isEnd = false;
        while (!isEnd){
            int choose = 0;
            System.out.println("Enter"+1+"for add player");
            System.out.println("Enter"+2+"for delete player");
            System.out.println("Enter"+3+"for book a court");
            System.out.println("Enter"+4+"for create court");
            do {
                choose = Scanner.nextInt();
                if(choose<1 || choose>4){
                    System.out.println("enter a number5 between 1 and 4");
                }
            }while(choose<1 || choose>4);
            switch (choose){
                case 1 :{
                    builtPlayer();
                }
                case 2 :{
                    deletePlayer(admin);
                }
                case 3 :{
                    bookCourt();
                }
                case 4 :{
                    CreateCourt();
                }
            }
        }
    }
}
