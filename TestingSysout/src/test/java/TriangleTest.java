import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

/**
 * Created by iwonasasak on 14.03.2018.
 */
public class TriangleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final String zeroLevelsTriangle = "";
    private final String oneLevelTriangle = "*";
    private final String fourLevelsTriangle = "   *\n  ***\n *****\n*******";

    private final Triangle triangle = new Triangle();

    @BeforeMethod
    public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        outContent.reset();
    }

    @Test
    public void simpleHolaTest() {
        System.out.print("Hola");
        assertEquals("Hola", outContent.toString());
    }

    @Test
    public void printTriangleForZeroLevels() {
        testTriangle(0, zeroLevelsTriangle);
    }

    @Test
    public void printTriangleForOneLevel() {
        testTriangle(1, oneLevelTriangle);
    }

    @Test
    public void printTriangleFor4Levels() {
        testTriangle(4, fourLevelsTriangle);
    }

    @AfterMethod
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    private void testTriangle(int numberOfLevels, String expectedTriangleType) {
        triangle.printTriangle(numberOfLevels);
        assertEquals(expectedTriangleType, outContent.toString());
    }
}