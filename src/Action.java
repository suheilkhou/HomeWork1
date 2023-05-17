public class Action {
    private Tile tile;
    private String direction;

    public Action(Tile tile, String direction){
        this.tile = tile;
        this.direction = direction;
    }

    public Action opposite(){
        if (this.direction == "up"){
            return new Action(this.tile, "down");
        } else if (this.direction == "down") {
            return new Action(this.tile, "up");
        } else if (this.direction == "left") {
            return new Action(this.tile, "right");
        }else
            return new Action(this.tile,"left");
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String toString(){
            return "Move"+tile.getId()+" "+direction;
    }
}
