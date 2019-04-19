public class BoxContainer {
    private Box box;
    private char x;
    private int y;

    public BoxContainer(char x, int y, Box box) {
        this.box = box;
        this.x = x;
        this.y = y;
    }

    public Box getBox() {
        return box;
    }

    public char getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
