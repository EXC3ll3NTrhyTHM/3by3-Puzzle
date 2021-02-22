import java.util.Comparator;

public class StateComparator implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {

        int manhattanDistance_node1 = node1.state.findManhattanDistance();
        int manhattanDistance_node2 = node1.state.findManhattanDistance();

        int totalCostWithHeuristic_node1 = manhattanDistance_node1 + node1.depth;
        int totalCostWithHeuristic_node2 = manhattanDistance_node2 + node2.depth;

        if (totalCostWithHeuristic_node1 < totalCostWithHeuristic_node2) {
            return -1;
        } else if (totalCostWithHeuristic_node1 > totalCostWithHeuristic_node2) {
            return 1;
        } else if (manhattanDistance_node1 < manhattanDistance_node2) {
            return -1;
        } else if (manhattanDistance_node1 < manhattanDistance_node2) {
            return 1;
        }

        return 0;
    }
}
