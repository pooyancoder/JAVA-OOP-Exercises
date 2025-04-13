import java.util.ArrayList;
import java.util.List;

public class admin {
    private List<court> courts;
//    private ArrayList<player> playerlist;

    public admin(){
        courts = new ArrayList<>();
//        playerlist = new ArrayList<>();
    }

    public void setCourt(court court){
        courts.add(court);
    }
//    public void setPlayer(player player){
//        playerlist.add(player);
//    }


   public List<court> getCourts(){
     return this.courts;
    }
//    public ArrayList<player> getPlayerlist(){return this.playerlist;}
}
