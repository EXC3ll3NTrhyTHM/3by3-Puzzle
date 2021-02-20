import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Puzzle {

    private static State state = new State();
    public static List<String> currentPuzzle = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/resources/prog1_input.txt"));
        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();
            int lineLength = nextLine.length();

            // Puzzles of invalid length are skipped
            // Since I know the input I have not accounted for the different ways a puzzle could be inputted such as
            // incorrect formatting
            switch (lineLength) {
                case 2: System.out.println("invalid puzzle");
                break;

                case 6: currentPuzzle.add(nextLine);
                break;

                case 0:
                    for (String line: currentPuzzle) {
                        System.out.println(line);
                    }
                    System.out.println("\n");

                    List<String> resultPuzzle = state.attemptToSolve(currentPuzzle);
                    for (String line: resultPuzzle) {
                        System.out.println(line);
                    }

                    currentPuzzle.clear();
                break;

                default:
                    System.out.println(lineLength);
                    break;
            }
        }
    }
}