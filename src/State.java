public class State {
    private Board board;

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
        if (location[0] == board.getDimensions()[0] - 1 && location[1] != board.getDimensions()[1] - 1){
            Action[] actions = new Action[3];
            actions[0] = new Action(board.getTiles()[location[0] - 1][location[1]].getId(),"Down");
        }
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
