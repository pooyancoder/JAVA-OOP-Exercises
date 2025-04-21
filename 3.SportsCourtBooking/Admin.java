import java.util.ArrayList;

public class Admin {
    private ArrayList<Court> courts;
    public ArrayList<Player> playerlist;

    public Admin(){
        courts = new ArrayList<>();
        playerlist = new ArrayList<>();
    }

    public void setCourt(Court court){
        courts.add(court);
    }
    public void setPlayer(Player player){playerlist.add(player);}


    public ArrayList<Court> getCourts(){
        return this.courts;
    }
    public ArrayList<Player> getPlayerlist(){return this.playerlist;}
}
