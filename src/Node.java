public class Node {
    private State state;
    private Node parent;
    private Action action;

    public Node(State state){
        this.state = state;
        this.parent = null;
        this.action = null;
    }

    public Node(State state, Node parent, Action action){
        this.state = state;
        this.parent = parent;
        this.action = action;
    }


    public Node[] expand(){
        int length = this.state.actions().length;
        Node[] nodes = new Node[length];
        for (int i = 0; i < length; i++){
            nodes[i]
        }

    }

    public int heuristicValue(){
        return 0;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

}
