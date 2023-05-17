public class State {
    private Board board;

    public State(Board board){
        this.board = board;
    }


    public boolean isGoal(){
        for (int i = 0; i < board.getDimensions()[0]; i++){
            for (int j = 0; j < board.getDimensions()[1]; j++){
                if (!(board.getTiles()[i][j].getId() == (char) (i * board.getDimensions()[0] + j + 1))){
                    return false;
                }
            }
        }
        return true;
    }

    public Action[] actions(){
        int[] location = findSpace(board);
        boolean lowerRow = location[0] == board.getDimensions()[0] - 1;
        boolean upperRow = location[0] == 0;
        boolean leftCol = location[1] == 0;
        boolean rightCol = location[1] == board.getDimensions()[1] - 1;
        if (!lowerRow && !upperRow && !leftCol && !rightCol){
            // Case 1: The space tile is not on the sides.
            Action[] actions = new Action[4];
            actions[0] = new Action(board.getTiles()[location[0] + 1][location[1]],"up");
            actions[1] = new Action(board.getTiles()[location[0] - 1][location[1]],"down");
            actions[2] = new Action(board.getTiles()[location[0]][location[1] - 1],"right");
            actions[3] = new Action(board.getTiles()[location[0]][location[1] + 1],"left");
            return actions;
        }

        if (lowerRow && !upperRow && !leftCol && !rightCol){
            // Case 2: The space tile is on the lower row and not any corner.
            Action[] actions = new Action[3];
            actions[0] = new Action(board.getTiles()[location[0] - 1][location[1]],"down");
            actions[1] = new Action(board.getTiles()[location[0]][location[1] - 1],"right");
            actions[2] = new Action(board.getTiles()[location[0]][location[1] + 1],"left");
            return actions;
        }

        if (!lowerRow && upperRow && !leftCol && !rightCol){
            // Case 3: The space tile is on the upper row and now any corner.
            Action[] actions = new Action[3];
            actions[0] = new Action(board.getTiles()[location[0] + 1][location[1]],"up");
            actions[1] = new Action(board.getTiles()[location[0]][location[1] - 1],"right");
            actions[2] = new Action(board.getTiles()[location[0]][location[1] + 1],"left");
            return actions;
        }

        if (!lowerRow && !upperRow && leftCol && !rightCol){
            // Case 4: The space tile is on the left column and not any corner.
            Action[] actions = new Action[3];
            actions[0] = new Action(board.getTiles()[location[0] + 1][location[1]],"up");
            actions[1] = new Action(board.getTiles()[location[0] - 1][location[1]],"down");
            actions[2] = new Action(board.getTiles()[location[0]][location[1] + 1],"left");
            return actions;
        }

        if (!lowerRow && !upperRow && !leftCol && rightCol){
            // Case 5: The space tile is on the right column and not any corner.
            Action[] actions = new Action[3];
            actions[0] = new Action(board.getTiles()[location[0] + 1][location[1]],"up");
            actions[1] = new Action(board.getTiles()[location[0] - 1][location[1]],"down");
            actions[2] = new Action(board.getTiles()[location[0]][location[1] - 1],"right");
            return actions;
        }

        if (!lowerRow && upperRow && leftCol && !rightCol){
            // Case 6: The space tile is in the left upper corner.
            Action[] actions = new Action[2];
            actions[0] = new Action(board.getTiles()[location[0] + 1][location[1]],"up");
            actions[1] = new Action(board.getTiles()[location[0]][location[1] + 1],"left");
            return actions;
        }

        if (!lowerRow && upperRow && !leftCol && rightCol){
            // Case 7: The space tile is in the right upper corner.
            Action[] actions = new Action[2];
            actions[0] = new Action(board.getTiles()[location[0] + 1][location[1]],"up");
            actions[1] = new Action(board.getTiles()[location[0]][location[1] - 1],"right");

            return actions;
        }

        if (lowerRow && !upperRow && leftCol && !rightCol){
            // Case 8: The space tile is in the right lower corner.
            Action[] actions = new Action[1];
            actions[0] = new Action(board.getTiles()[location[0] - 1][location[1]],"down");
            actions[1] = new Action(board.getTiles()[location[0]][location[1] + 1],"left");
            return actions;
        }

        if (lowerRow && !upperRow && !leftCol && rightCol){
            // Case 9: The space tile is in the left lower corner.
            Action[] actions = new Action[2];
            actions[0] = new Action(board.getTiles()[location[0] - 1][location[1]],"down");
            actions[1] = new Action(board.getTiles()[location[0]][location[1] - 1],"right");
            return actions;
        }
        // Never.
        Action[] a = new Action[1];
        return a;
        // Never.
    }

    public int[] findSpace(Board board){
        int[] location = new int[2];
        for (int i = 0; i < board.getDimensions()[0]; i++){
            for (int j = 0; j < board.getDimensions()[1]; j++){
                if(board.getTiles()[i][j].getId() == ' '){
                    location[0] = i;
                    location[1] = j;
                    return location;
                }
            }
        }
        return location;
    }

    public Node result(Action action){
        if (action.getDirection().equals("up")){

        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof State)) {
            return false;
        }
        State otherState = (State) other;
        return board.equals(otherState.board);
    }

    @Override
    public int hashCode() {
        return board.hashCode();
    }
}
