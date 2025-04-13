import java.util.ArrayList;

public class player {
    private String name;
    static public ArrayList<player> players = new ArrayList<>();
    static int maxMember = 20;

    public ArrayList<player> getPlayers(){
        return players;
    }

    public String getName(){
        return this.name;
    }

    public player(String name){
        if(players.size() < 20){
            players.add(this);
            this.name = name;
        }else{
            System.out.println("you cant make a new player!");
        }
    }

    public void bookCourt(court court){
        if(court.isiSAvailable()){
            court.setCourt(this);
        }else
            System.out.println("this court has been Previously reserved");
    }

    public void deletePlayer(player p , admin a){
        for(court court : a.getCourts()){
            if(court.getBooker().getName().equals( p.getName())){
                court.deletePlayer();
            }
        }
    }

}
