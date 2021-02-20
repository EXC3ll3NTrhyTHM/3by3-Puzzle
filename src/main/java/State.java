import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

public class State {

    char[][] currentState;

    public List<String> attemptToSolve(List<String> currentPuzzle) {
        // convert string list to char array so that the chars may be moved around more easily

        // first index is y value
        char[][] currentState = convertTo2DCharArray(currentPuzzle);

        List<String> resultPuzzle = new ArrayList<>();


        return resultPuzzle;
    }

    char[][] convertTo2DCharArray(List<String> currentPuzzle) {

        char[][] charArray = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String strippedOfSpaces = currentPuzzle.get(i).replaceAll(" ", "");
            charArray[i] = strippedOfSpaces.toCharArray();
        }
        currentState = charArray;
        return charArray;
    }

    void swapCharacter(char emptyCharacter, char number) {
        
    }

    int[] findCoordinates(char character) {
        int[] coordinates = new int[2];
        int verticalValue = -1;
        int horizontalValue = -1;
        for (int i = 0; i < 3; i++) {
            horizontalValue = ArrayUtils.indexOf(currentState[i], character);
            if (horizontalValue != -1){
                verticalValue = i;
                break;
            }

        }
        coordinates[0] = horizontalValue;
        coordinates[1] = verticalValue;

        return coordinates;
    }
}
