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
        Node[] nodes = new Node[length];
        int j = 0;
        for (int i = 0; i < length; i++){
            if (this.action != null) {
                if (this.action.getDirection().equals(actions[i].opposite().getDirection())) {
                    break;
                }
            }
            nodes[j] = new Node(this.state.copyState().result(actions[i]),this.CopyNode(),actions[i]);
            j++;
        }
        return nodes;
    }



    public Node CopyNode(){
        if (this.parent == null && this.action == null){
            return new Node(this.state.copyState());
        }
        return new Node(this.state.copyState(),this.parent,this.action.copyAction());
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
