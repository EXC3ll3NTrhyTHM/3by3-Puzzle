import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

import static java.lang.Math.abs;

public class State {

    char[][] currentStateInChar;
    int depthInTree;
    State parentState;
    // manahttan distance + distance from starting position
    int weight;


    public State(char[][] currentPuzzle, State parent, int depth) {
        currentStateInChar = currentPuzzle;
        parentState = parent;
        depthInTree = depth;
    }

    public State(List<String> currentPuzzle) {
        currentStateInChar = convertTo2DCharArray(currentPuzzle);
        parentState = null;
        depthInTree = 0;
    }

    char[][] convertTo2DCharArray(List<String> currentPuzzle) {

        char[][] charArray = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String strippedOfSpaces = currentPuzzle.get(i).replaceAll(" ", "");
            charArray[i] = strippedOfSpaces.toCharArray();
        }
        currentStateInChar = charArray;
        return charArray;
    }

    void swapCharacter(char emptyCharacter, char number) {
        int[] coordinatesOfEmpty = findCoordinates(emptyCharacter);
        int[] coordinatesOfNumber = findCoordinates(number);

        currentStateInChar[coordinatesOfEmpty[1]][coordinatesOfEmpty[0]] = number;
        currentStateInChar[coordinatesOfNumber[1]][coordinatesOfNumber[0]] = emptyCharacter;
    }

    int[] findCoordinates(char character) {
        int[] coordinates = new int[2];
        int verticalValue = -1;
        int horizontalValue = -1;
        for (int i = 0; i < 3; i++) {
            horizontalValue = ArrayUtils.indexOf(currentStateInChar[i], character);

            if (horizontalValue != -1){
                verticalValue = i;
                break;
            }

        }
        // horizontal value is column
        // vertical value is row
        coordinates[0] = horizontalValue;
        coordinates[1] = verticalValue;

        return coordinates;
    }

    int findManhattanDistance(State currentState) {

        
        int[] coordinates = findCoordinates(c);
        int[] goalCoordinates;

        switch (c) {
            case '1':
                // first number is the row second number is the column
                goalCoordinates = new int[]{0, 0};
                break;
            case '2':
                goalCoordinates = new int[]{0, 1};
                break;
            case '3':
                goalCoordinates = new int[]{0, 2};
                break;
            case '4':
                goalCoordinates = new int[]{1, 0};
                break;
            case '5':
                goalCoordinates = new int[]{1, 1};
                break;
            case '6':
                goalCoordinates = new int[]{1, 2};
                break;
            case '7':
                goalCoordinates = new int[]{2, 0};
                break;
            case '8':
                goalCoordinates = new int[]{2, 1};
                break;
            case 'E':
                goalCoordinates = new int[]{2, 2};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }

        int verticalDistance = abs(coordinates[0] - goalCoordinates[0]);
        int horizontalDistance = abs(coordinates[1] - goalCoordinates[1]);

        return verticalDistance + horizontalDistance;
    }

//    int findDistanceFromStartingPosition(char c) {
//
//    }

    char[][] getCurrentStateInChar() {
        return currentStateInChar;
    }

    State getParentState() {return parentState;}

    void setParentState(State parent) {
        parentState = parent;
    }

    int getDepthInTree() {return depthInTree;}

}
