import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

// Got the idea for this class from here https://faramira.com/solving-8-puzzle-problem-using-a-star-search-in-c/
public class Solver {

    State goalState;

    boolean solved;

    PriorityQueue<Node> openList = new PriorityQueue<>(new StateComparator());
    List<State> closedList = new ArrayList<>();

    Solver(Node start, State goal) {
        openList.add(start);
        this.goalState = goal;
    }

    void expandNode(Node current, Neighbors neighbors) {
        // apparently current can be null here
        if (current.state != null) {
            if (current.state == goalState) {
                solved = true;
                return;
            }
        } else return;


        int[] emptyCoordinates = current.state.findCoordinates('E');
        Point[] neighbors1 = neighbors.getNeighbors(new Point(emptyCoordinates[1], emptyCoordinates[0]));


        for (Point next: neighbors1) {
            State state = current.state;
            char nextChar = state.currentStateInChar[next.x][next.y];
            state.swapCharacter('E',nextChar);

            if (!stateAlreadyVisited(state)) {
                openList.add(new Node(state, current, current.depth+1));
            }
        }
    }


    // Not sure if this works
    boolean stateAlreadyVisited(State state) {
        for (State visitedState: closedList) {
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (visitedState.currentStateInChar[row][col] != state.currentStateInChar[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
