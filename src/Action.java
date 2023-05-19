public class Action {
    private Tile tile;
    private Direction direction;

    public Action(Tile tile, Direction direction){
        this.tile = tile;
        this.direction = direction;
    }

    public Action opposite(){
        if (this.direction == Direction.UP){
            return new Action(this.tile, Direction.DOWN);
        } else if (this.direction == Direction.DOWN) {
            return new Action(this.tile, Direction.UP);
        } else if (this.direction == Direction.LEFT) {
            return new Action(this.tile, Direction.RIGHT);
        }else
            return new Action(this.tile,Direction.RIGHT);
    }

    public Action copyAction(){
        return new Action(this.tile.copyTile(),this.direction);
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String toString(){
            return "Move"+tile.getId()+" "+direction.toString().toLowerCase();
    }
}
