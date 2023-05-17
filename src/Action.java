public class Action {
    private char tileNum;
    private String direction;

    public Action(char tileNum, String direction){
        this.tileNum = tileNum;
        this.direction = direction;
    }

    public String toString(){
            return "Move"+tileNum+" "+direction;
    }
}
