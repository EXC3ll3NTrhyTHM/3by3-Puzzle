import java.awt.*;
import java.util.*;

// Got the idea and design for this class from https://faramira.com/solving-8-puzzle-problem-using-a-star-search-in-c/
public class Neighbors {

    public HashMap<Point, Point[]> neighbors = new HashMap<>();


    public Neighbors() {
        createNeighborsForAllCells();
    }

    public void createNeighborsForAllCells() {
        //first number is the column, second number is the row
        neighbors.put(new Point(0, 0), new Point[]{new Point(1, 0), new Point(0, 1)});
        neighbors.put(new Point(1, 0), new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 0)});
        neighbors.put(new Point(2, 0), new Point[]{new Point(1, 0), new Point(2, 1)});
        neighbors.put(new Point(0, 1), new Point[]{new Point(0, 0), new Point(1, 1), new Point(0, 2)});
        neighbors.put(new Point(1, 1), new Point[]{new Point(1, 0), new Point(2, 1), new Point(1, 2), new Point(0, 1)});
        neighbors.put(new Point(2, 1), new Point[]{new Point(2, 0), new Point(1, 1), new Point(2, 2)});
        neighbors.put(new Point(0, 2), new Point[]{new Point(0, 1), new Point(2, 1)});
        neighbors.put(new Point(1, 2), new Point[]{new Point(0, 2), new Point(1, 1), new Point(2, 2)});
        neighbors.put(new Point(2, 2), new Point[]{new Point(2, 1), new Point(1, 2)});
    }

    public Point[] getNeighbors(Point coordinates) {
        return neighbors.get(coordinates);
    }
}
