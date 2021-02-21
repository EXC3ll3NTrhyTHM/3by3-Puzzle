import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {


    String firstLine;
    String secondLine;
    String thirdLine;
    private static List<String> currentPuzzle;
    private static State state;


    @BeforeEach
    private void setup() {
        firstLine = "123";
        secondLine = "456";
        thirdLine = "78E";

        currentPuzzle = new ArrayList<>();
        currentPuzzle.add(firstLine);
        currentPuzzle.add(secondLine);
        currentPuzzle.add(thirdLine);
        state = new State(currentPuzzle);

    }

    @Test
    public void testConvertTo2DCharArray() {
        char[][] resultedCharArray = state.getCurrentState();
        char[][] expectedCharArray = {
                firstLine.toCharArray(),
                secondLine.toCharArray(),
                thirdLine.toCharArray()
        };
        assertArrayEquals(resultedCharArray, expectedCharArray);
    }

    @Test
    public void testSwapCharacter() {
        secondLine = "45E";
        thirdLine = "786";

        char[] firstLineChars = firstLine.toCharArray();
        char[] secondLineChars = secondLine.toCharArray();
        char[] thirdLineChars = thirdLine.toCharArray();

        state.swapCharacter('E', '6');
        char[][] actualState = state.getCurrentState();

        assertArrayEquals(actualState[0], firstLineChars);
        assertArrayEquals(actualState[1], secondLineChars);
        assertArrayEquals(actualState[2], thirdLineChars);
    }

    @Test
    public void testFindCoordinates() {
        char emptyChar = 'E';
        int[] expectedCoordinates = {2,2};
        int[] actualCoordinates = state.findCoordinates(emptyChar);
        assertArrayEquals(expectedCoordinates, actualCoordinates);

    }

    @Test
    public void testFindCharacter() {
        int x = ArrayUtils.indexOf(thirdLine.toCharArray(), 'E');
        assertTrue(x != -1);
    }

    @Test
    public void findManhattanDistance() {
        state.swapCharacter('E', '6');
        int actual = state.findManhattanDistance('E');
        assertEquals(1, actual);
    }
}
