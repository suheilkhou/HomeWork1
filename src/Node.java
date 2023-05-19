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
        Action[] actions = this.state.actions();
        int length = actions.length;
        Node[] nodes = new Node[length-1];
        int j = 0;
        for (int i = 0; i < length; i++){
            if (this.action.getDirection().equals(actions[i].opposite())){
                break;
            }
            nodes[j] = new Node(,this.Node,actions[i]);
        }
        return nodes;
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
