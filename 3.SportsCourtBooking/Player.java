import java.util.ArrayList;

public class Player {
    private String name;
    static public ArrayList<Player> players = new ArrayList<>();
    static int maxMember = 20;

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public String getName(){
        return this.name;
    }

    public Player(String name){
        if(players.size() < 20){
            players.add(this);
            this.name = name;
        }else{
            System.out.println("you cant make a new player!");
        }
    }

    public void bookCourt(Court court){
        if(court.isiSAvailable()){
            court.setCourt(this);
        }else
            System.out.println("this court has been Previously reserved");
    }

    public void deletePlayer(Player p , Admin a){
        for(Court court : a.getCourts()){
            if(court.getBooker().getName().equals( p.getName())){
                court.deletePlayer();
            }
        }
    }
}
