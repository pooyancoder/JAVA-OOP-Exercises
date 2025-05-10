import java.util.Scanner;

public class Main {
    static Scanner StringScanner = new Scanner(System.in);
    static Scanner IntScanner = new Scanner(System.in);

    static void builtPlayer(Admin admin) {
        System.out.println("_-_-_-_-_exist players list_-_-_-_-_");
        for (Player p : admin.getPlayers()) {
            System.out.println(p.getName() + " " + p.getID());
        }
        System.out.println("\nEnter yor player name and his ID");
        String name = StringScanner.nextLine();
        int ID = IntScanner.nextInt();
        Player newPlayer = new Player(name, ID);
        admin.setPlayer(newPlayer);
    }

    static void deletePlayer(Admin admin) {
        for (int i = 0; i < admin.getPlayers().size(); i++) {
            System.out.println(i + ". for " + admin.getPlayers().get(i).getName()+ " his ID " + admin.getPlayers().get(i).getID());
        }
        System.out.println("Enter your choice\n>>");
        int choice = IntScanner.nextInt();
        admin.removePlayer(admin.getPlayers().get(choice));
    }

    static void CreateCourt(Admin admin) {
        System.out.println("_-_-_-_-_exist courts list_-_-_-_-_");
        for (Court c : admin.getCourts()) {
            System.out.println(c.getCourtNAme());
        }
        System.out.println("\nEnter court name\n>>");
        String courtNAme = StringScanner.nextLine();
        admin.setCourts(new Court(courtNAme));
    }

    static void deleteCourt(Admin admin) {
        for (int i = 0; i < admin.getCourts().size(); i++) {
            System.out.println(i + ". for " + admin.getCourts().get(i).getCourtNAme());
        }
        System.out.println("\nEnter your choice\n>>");
        int choice = IntScanner.nextInt();
        admin.deleteCourt(admin.getCourts().get(choice));
    }

    static void bookCourt(Admin admin) {
        System.out.println("___________reserving a court___________");
        for (int i = 0; i < admin.getPlayers().size(); i++) {
            System.out.println(i + ". for " + admin.getPlayers().get(i).getName() + " ID " + admin.getPlayers().get(i).getID());
        }
        System.out.println("\nselect a player\n>");
        int firstChoice = IntScanner.nextInt();
        for (int i = 0; i < admin.getCourts().size(); i++) {
            System.out.println(i + ". for " + admin.getCourts().get(i).getCourtNAme());
        }
        System.out.println("\nselect a court\n>");
        int secondChoice = IntScanner.nextInt();

        admin.bookCourt(admin.getPlayers().get(firstChoice), admin.getCourts().get(secondChoice));
    }

    static void availableCourt(Admin admin){
        for (int i = 0; i < admin.getCourts().size(); i++) {
            System.out.println(i + ". for " + admin.getCourts().get(i).getCourtNAme());
        }
        System.out.println("\nEnter your choice\n>>");
        int choice = IntScanner.nextInt();
        admin.setAvailableCourt(admin.getCourts().get(choice));
    }

    public static void main(String[] args) {
        Admin admin = new Admin();

        System.out.println(">>>>>>welcome to our club<<<<<<<");
        boolean isEnd = false;
        while (!isEnd) {
            int choose = 0;
            System.out.println(">>>>>>>>>>sport court<<<<<<<<<<<");
            System.out.println("1. add player");
            System.out.println("2. delete player");
            System.out.println("3. book a court");
            System.out.println("4  create court");
            System.out.println("5. delete court");
            System.out.println("6. make a court available");
            System.out.println("7. exit");
            System.out.println(">");

            do {
                choose = IntScanner.nextInt();
                if (choose < 1 || choose > 7) {
                    System.out.println("enter a number5 between 1 and 4");
                    System.out.println(">>");
                }
            } while (choose < 1 || choose > 7);
            switch (choose) {
                case 1: {
                    builtPlayer(admin);
                    break;
                }
                case 2: {
                    deletePlayer(admin);
                    break;
                }
                case 3: {
                    bookCourt(admin);
                    break;
                }
                case 4: {
                    CreateCourt(admin);
                    break;
                }
                case 5: {
                    deleteCourt(admin);
                    continue;
                }
                case 6: {
                    availableCourt(admin);
                    continue;
                }
                case 7: {
                    isEnd = true;
                }
            }
        }
    }
}
