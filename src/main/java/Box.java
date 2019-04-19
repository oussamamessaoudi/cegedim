public class Box {
    private Pieces piece;
    private Color color;

    public Box(Pieces piece, Color color) {
        this.piece = piece;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
