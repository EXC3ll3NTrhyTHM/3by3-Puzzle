import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class State {

    char[][] currentState;

    public State(List<String> currentPuzzle) {
        currentState = convertTo2DCharArray(currentPuzzle);
    }

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
        // find the blank square
        // find the number we want to move it to
        // check that the blank can be moved to that number
        // if it can swap them

        int[] coordinatesOfEmpty = findCoordinates(emptyCharacter);
        int[] coordinatesOfNumber = findCoordinates(number);

        currentState[coordinatesOfEmpty[1]][coordinatesOfEmpty[0]] = number;
        currentState[coordinatesOfNumber[1]][coordinatesOfNumber[0]] = emptyCharacter;
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
        coordinates[1] = horizontalValue;
        coordinates[0] = verticalValue;

        return coordinates;
    }

    int findManhattanDistance(char c) {
        int[] coordinates = findCoordinates(c);
        int[] goalCoordinates;

        switch (c) {
            case '1':
                // first number is vertical value second number is horizontal value, oppone
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

    char[][] getCurrentState() {
        return currentState;
    }

}
