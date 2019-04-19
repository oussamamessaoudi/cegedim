public class Result {
    private int yTour, yPiece;
    private char xTour, xPiece;
    private boolean isLost;

    public Result(char xTour, int yTour, char xPiece, int yPiece, boolean isLost) {
        this.yTour = yTour;
        this.yPiece = yPiece;
        this.xTour = xTour;
        this.xPiece = xPiece;
        this.isLost = isLost;
    }

    @Override
    public String toString() {
        String lost = isLost?"x":"-";
        return "T"+xTour+yTour+lost+xPiece+yPiece;
    }
}
