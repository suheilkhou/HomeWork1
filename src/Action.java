public class Action {
    private Tile tile;
    private String direction;

    public Action(Tile tile, String direction){
        this.tile = tile;
        this.direction = direction;
    }

    public String toString(){
            return "Move"+tile.getId()+" "+direction;
    }
}
