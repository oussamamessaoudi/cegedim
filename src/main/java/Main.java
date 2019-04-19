import java.util.List;

public class Main {
    public static void main(String[] str) {
        Chess chess = new Chess();
        //Input

        BoxContainer boxContainerTour = new BoxContainer('d', 5, new Box(Pieces.tour, Color.white));
        //initialization
        initializeTour(chess, boxContainerTour);
        initialize(chess);

        //Treatment
        List<Result> results = chess.check(boxContainerTour);
        //Results
        for (Result result : results) {
            System.out.println(result);
        }

    }

    private static void initializeTour(Chess chess, BoxContainer boxContainer) {
        chess.setBox(boxContainer.getX(), boxContainer.getY(), boxContainer.getBox());
    }

    private static void initialize(Chess chess) {

        chess.setBox('g', 5, new Box(Pieces.chevalier, Color.white));
        chess.setBox('d', 2, new Box(Pieces.chevalier, Color.white));
        chess.setBox('d', 7, new Box(Pieces.fou, Color.black));

    }
}

