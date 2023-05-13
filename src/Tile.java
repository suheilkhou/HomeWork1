public class Tile {

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tile)) {
            return true;
        }
        Tile tile = (Tile) other;
        return value == tile.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}