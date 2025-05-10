
public class Court {
    private final String courtNAme;
    private boolean iSAvailable;
    private Player player;

    public Court(String name){
        this.courtNAme = name;
        iSAvailable = true;
    }

    public boolean getIsAvailable(){
        return iSAvailable;
    }


    public String getCourtNAme(){
        return this.courtNAme;
    }

    public void setIsAvailable(){
        this.iSAvailable = true;
        player = null;
        System.out.println(courtNAme + " can be reserved!\n");
    }

    public void bookCourt(Player player){
        if (iSAvailable) {
            this.player = player;
            iSAvailable = false;
            System.out.println(player.getName() + " reserved the " + courtNAme + "\n");
        }else{
            System.out.println("no reservation!\n");
        }
    }
}
