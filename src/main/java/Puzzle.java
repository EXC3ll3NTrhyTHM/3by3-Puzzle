import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Puzzle {

    public static void main(String[] args) throws FileNotFoundException {

        Node firstNode;
        Solver solver;
        State goalState;
        List<String> currentPuzzle = new ArrayList<String>();

        String firstLine = "123";
        String secondLine = "456";
        String thirdLine = "78E";

        List<String> goalStateList = new ArrayList<>();

        goalStateList.add(firstLine);
        goalStateList.add(secondLine);
        goalStateList.add(thirdLine);
        goalState = new State(goalStateList);

        Neighbors neighbors = new Neighbors();

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

                // This is after the final line of the puzzle so I begin solving it
                case 0:
                    for (String line: currentPuzzle) {
                        System.out.println(line);
                    }
                    System.out.println("\n");
                    firstNode = new Node(new State(currentPuzzle));
                    solver = new Solver(firstNode, goalState);
                    PriorityQueue<Node> queue = solver.openList;
                    while (!solver.solved) {
                            // Throws NPE here but Im check for if its null on the above line
                            Node node = queue.poll();
                            solver.expandNode(node, neighbors);
                    }

//                    for (int row = 0; row < 3; row++) {
//                        for (int col = 0; col < 3; col++) {
//                            System.out.println();
//                        }
//                    }
//                    System.out.println();
                    // print puzzle
                    currentPuzzle.clear();
                break;

                default:
                    System.out.println(lineLength);
                    break;
            }
        }
    }
}