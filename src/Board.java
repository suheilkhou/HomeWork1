import java.util.Arrays;
public class Board {

    private int[] dimensions;
    private Tile[][] tiles;

    public Board(String board){
        this.dimensions = findDimensions(board);
        tiles = new Tile[dimensions[0]][dimensions[1]];
        for (int i = 0; i < dimensions[0]; i++){
            for(int j = 0; i < dimensions[1]; j++) {
                if ((board.charAt(j) != ' ') && (board.charAt(j) != '|')) {
                    this.tiles[i][j] = new Tile(board.charAt(j),i , j);
                }
            }
        }
    }

    public void moveTile(Tile tile, Direction direction){
        int i = tile.placement[0];
        int j = tile.placement[1];
        Tile tempTile = tile;
        switch (direction){
            case UP:
                this.tiles[i][j] = this.tiles[i-1][j];
                this.tiles[i-1][j] = tempTile;
                break;
            case DOWN:
                this.tiles[i][j] = this.tiles[i+1][j];
                this.tiles[i+1][j] = tempTile;
                break;
            case RIGHT:
                this.tiles[i][j] = this.tiles[i][j+1];
                this.tiles[i][j+1] = tempTile;
                break;
            case LEFT:
                this.tiles[i][j] = this.tiles[i][j-1];
                this.tiles[i][j-1] = tempTile;
                break;
        }
    }

    public Board(int[] dimensions, Tile[][] tiles){
        this.dimensions = dimensions;
        this.tiles = tiles;
    }

    private int[] findDimensions(String board){
        int[] dim = new int[2];
        int rows_ = 0;
        int columns_ = 0;
        for (int i = 0; i < board.length(); i++){
            if (board.charAt(i) == '|'){
                rows_ += 1;
            }
            if (board.charAt(i) == ' ' && rows_ == 0){
                columns_ += 1;
            }
        }
        dim[0] = rows_ + 1;
        dim[1] = columns_ + 1;
        return dim;
    }

    public int[] getDimensions() {
        return dimensions;
    }

    public void setDimensions(int[] dimensions) {
        this.dimensions = dimensions;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }


    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Board)) {
            return false;
        }
        Board board = (Board) other;
        return Arrays.deepEquals(tiles, board.tiles);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(tiles);
    }
}
