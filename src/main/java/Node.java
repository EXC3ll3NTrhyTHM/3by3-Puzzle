// Got the idea for this class from here https://faramira.com/solving-8-puzzle-problem-using-a-star-search-in-c/
public class Node {
    State state;
    Node parent;
    int depth;

    Node(State state, Node parent, int depth) {
        this.state = state;
        this.parent = parent;
        this.depth = depth;
    }

    Node(State state) {
        this.state = state;
        this.parent = null;
        this.depth = 0;
    }

    void setParent(Node parent) {
        this.parent = parent;
    }

    Node getParent() {
        return this.parent;
    }


    State getState() {
        return this.state;
    }

    int getDepth() {
        return this.depth;
    }
}
