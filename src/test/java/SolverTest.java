import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SolverTest {

    Node notGoalStateNode;
    Solver solver;

    @BeforeEach
    void setUp() {

        String firstLine1 = "123";
        String secondLine1 = "456";
        String thirdLine1 = "78E";

        String firstLine2 = "123";
        String secondLine2 = "45E";
        String thirdLine2 = "786";

        State goalState;

        List<String>currentPuzzle1 = new ArrayList<>();
        currentPuzzle1.add(firstLine1);
        currentPuzzle1.add(secondLine1);
        currentPuzzle1.add(thirdLine1);

        goalState = new State(currentPuzzle1);

        List<String>currentPuzzle2 = new ArrayList<>();
        currentPuzzle2.add(firstLine2);
        currentPuzzle2.add(secondLine2);
        currentPuzzle2.add(thirdLine2);
        State notGoalState = new State(currentPuzzle2);
        notGoalStateNode = new Node(notGoalState);

        solver = new Solver(notGoalStateNode, goalState);
    }

    //@Test
    void testExpandNode() {
        //solver.expandNode();
    }
}
