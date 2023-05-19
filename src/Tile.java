public class Tile {
    private final char id;
    private static int total = 0;
    int placement[];

    public Tile(char value,int i, int j){
        this.placement = new int[2];
        this.id = value;
        this.placement[0] = i;
        this.placement[1] = j;
        total++;
    }

    public Tile copyTile(){
        return new Tile(this.id,this.placement[0],this.placement[1]);
    }


    public char getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Tile.total = total;
    }

    public int[] getPlacement() {
        return placement;
    }

    public void setPlacement(int[] placement) {
        this.placement = placement;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tile)) {
            return false;
        }
        Tile tile = (Tile) other;
        return id == tile.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}