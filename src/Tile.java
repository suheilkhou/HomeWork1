public class Tile {
    private final char id;
    private static int total = 1;

    public char getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Tile.total = total;
    }

    public Tile(char value){
        this.id = value;
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