import java.util.ArrayList;
import java.util.List;

public class State {

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

        return charArray;
    }

    void swapCharacter(char emptyCharacter, char number) {

    }

    int[] findCoordinates(char character) {
        int[] coordinates = new int[2];

        
        return coordinates;
    }
}
