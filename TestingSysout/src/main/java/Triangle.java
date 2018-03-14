/**
 * Created by iwonasasak on 14.03.2018.
 */
public class Triangle implements TrianglePrintable {

    public void printTriangle(int numberOfLevels) {
        if (numberOfLevels == 0) {
            System.out.print("");
        } else if (numberOfLevels == 1) {
            System.out.print("*");
        } else {
            for (int i = 1; i <= numberOfLevels; i++) {
                printTriangleLevel(numberOfLevels, i);
            }
        }
    }

    private void printTriangleLevel(int numberOfLevels, int actualLevel) {
        printSpaces(numberOfLevels, actualLevel);
        printStars(actualLevel);
        if (numberOfLevels > actualLevel) System.out.println();
    }

    private void printSpaces(int numberOfLevels, int actualLevel) {
        for (int i = 0; i < numberOfLevels - actualLevel; i++) {
            System.out.print(" ");
        }
    }

    private void printStars(int actualLevel) {
        for (int i = 0; i < 2 * actualLevel - 1; i++) {
            System.out.print("*");
        }
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        t.printTriangle(4);
    }
}
