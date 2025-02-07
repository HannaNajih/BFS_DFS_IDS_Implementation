
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class graph {
    private final int nodes;
    private final boolean directed;
    private final boolean[][] adjacencyMatrix;
    private final List<List<Integer>> adjacencyList;

    public graph(int nodes, boolean directed) {
        this.nodes = nodes;
        this.directed = directed;
        this.adjacencyMatrix = new boolean[nodes][nodes];
        this.adjacencyList = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjacencyMatrix[src][dest] = true;
        adjacencyList.get(src).add(dest);
        if (!directed) {
            adjacencyMatrix[dest][src] = true;
            adjacencyList.get(dest).add(src);
        }
    }

    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public int getNodes() {
        return nodes;
    }

    public boolean isDirected() {
        return directed;
    }

    public static graph generateRandomGraph(int nodes, double probability, boolean directed) {
        graph graph = new graph(nodes, directed);
        Random rand = new Random();
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i != j && rand.nextDouble() < probability) {
                    graph.addEdge(i, j);
                }
            }
        }
        return graph;
    }
}