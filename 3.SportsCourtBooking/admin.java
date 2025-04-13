import java.util.ArrayList;
import java.util.List;

public class admin {
    private List<court> courts;

    public admin(){
        courts = new ArrayList<>();
    }

    public void setCourt(court court){
        courts.add(court);
    }

   public List<court> getCourts(){
     return this.courts;
    }
}
