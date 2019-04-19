import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Chess {

    private static char maxX = 'i';
    private static char minX = 'a';
    private static int boardLength = 8;
    private Map<Character, Box[]> chequier;

    Chess() {
        this.chequier = new HashMap<Character, Box[]>();
        for (int i = minX; i < maxX; i++) {
            this.chequier.put((char) i, new Box[boardLength]);
        }
    }

    void setBox(char x, int y, Box box) {
        chequier.get(x)[y - 1] = box;
    }

    LinkedList<Result> check(BoxContainer boxContainer) {
        LinkedList<Result> results = new LinkedList<Result>();
        results.addAll(checkDown(boxContainer));
        results.addAll(checkRight(boxContainer));
        results.addAll(checkUp(boxContainer));
        results.addAll(checkLeft(boxContainer));
        return results;
    }

    private LinkedList<Result> checkRight(BoxContainer boxContainer) {
        LinkedList<Result> result = new LinkedList<Result>();
        int start = boxContainer.getX() + 1;
        for (char i = (char) start; i < maxX; i++) {
            if (checkLocal(boxContainer, result, i, boxContainer.getY()))
                break;
        }
        return result;
    }

    private LinkedList<Result> checkLeft(BoxContainer boxContainer) {
        LinkedList<Result> result = new LinkedList<Result>();
        for (char i = (char) (boxContainer.getX() - 1); i >= minX; i--) {
            if (checkLocal(boxContainer, result, i, boxContainer.getY()))
                break;
        }
        return result;
    }

    private LinkedList<Result> checkUp(BoxContainer boxContainer) {
        LinkedList<Result> result = new LinkedList<Result>();
        for (int i = boxContainer.getY() + 1; i <= boardLength; i++) {
            if (checkLocal(boxContainer, result, boxContainer.getX(), i))
                break;
        }
        return result;
    }

    private LinkedList<Result> checkDown(BoxContainer boxContainer) {
        LinkedList<Result> result = new LinkedList<Result>();
        for (int i = boxContainer.getY() - 1; i >= 0; i--) {
            if (checkLocal(boxContainer, result, boxContainer.getX(), i))
                break;
        }
        return result;
    }

    private boolean checkLocal(BoxContainer boxContainer, LinkedList<Result> result, char i, int y) {
        if (chequier.get(i)[y - 1] == null) {
            result.add(new Result(boxContainer.getX(), boxContainer.getY(), i, y, false));
        } else if (chequier.get(i)[y - 1].getColor() == boxContainer.getBox().getColor()) {
            return true;
        } else {
            result.add(new Result(boxContainer.getX(), boxContainer.getY(), i, y, true));
            return true;
        }
        return false;
    }
}
