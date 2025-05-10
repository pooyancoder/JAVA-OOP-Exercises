import java.util.ArrayList;

public class Admin {
    static ArrayList<Court> Courts;
    static ArrayList<Player> Players;

    public Admin() {
        Courts = new ArrayList<>();
        Players = new ArrayList<>();
    }

    public  ArrayList<Court> getCourts() {
        return Courts;
    }

    public  ArrayList<Player> getPlayers() {
        return Players;
    }

    public void setPlayer(Player player) {
        for (Player p : Players) {
            if (p.getName().equalsIgnoreCase(player.getName()) && p.getID() == player.getID()) {
                System.out.println("The Player With The Same Name And ID Is Already Exist");
                return;
            }
        }
        Players.add(player);
        System.out.println(player.getName() + " added in club!\n");
    }

    public void removePlayer(Player player) {
        for (Player p : Players) {
            if (p.getName().equals(player.getName()) && p.getID() == player.getID()) {
                Players.remove(player);
                System.out.println(player.getName() + " deleted\n");
                return;
            }
        }
        System.out.println("\n-----invalid player!-----\n     nobody deleted");
    }

    public void setCourts(Court court) {
        for (Court c : Courts) {
            if (c.getCourtNAme().equalsIgnoreCase(court.getCourtNAme())) {
                System.out.println("the court already exist!");
                return;
            }
        }
        Courts.add(court);
        System.out.println(court.getCourtNAme() + " added to the club!\n");
    }

    public void deleteCourt(Court court) {
        for (Court c : Courts) {
            if (c.getCourtNAme().equals(court.getCourtNAme())) {
                Courts.remove(court);
                System.out.println(court.getCourtNAme() + " deleted!\n");
                return;
            }
        }
        System.out.println("-----invalid court!-----\n     no court deleted");
    }

    public void setAvailableCourt(Court court){
        for (Court c : Courts){
            if (c.getCourtNAme().equalsIgnoreCase(court.getCourtNAme())){
                if (c.getIsAvailable())
                    System.out.println("the court namely " + c.getCourtNAme() + " was being available!\n");
                else
                    c.setIsAvailable();
            }
        }
    }

    public void bookCourt(Player p, Court c){
        for (Court court : Courts){
            if (court.getCourtNAme().equalsIgnoreCase(c.getCourtNAme())){
                if (court.getIsAvailable()){
                    court.bookCourt(p);
                    p.setCourt(c);
                    return;
                }
            }
        }
        System.out.println("court has been reserved!\n");
    }
}
