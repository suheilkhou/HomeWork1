public class Tile {
    private final char id;
    private static int total = 1;
    private int[] placement;

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

    public Tile(char value, int i, int j){
        this.id = value;
        placement[0] = i;
        placement[1] = j;
        total++;
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