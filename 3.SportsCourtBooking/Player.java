public class Player {
    private final String name;
    long ID;
    Court court;


    public Player(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return this.name;
    }

    public void setCourt(Court court){
        this.court = court;
    }


}
