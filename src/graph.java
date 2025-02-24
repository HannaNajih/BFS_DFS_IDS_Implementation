import java.util.*;

public class Graph {
    private int numNodes; // Number of nodes in the graph
    private boolean[][] adjacencyMatrix; // Adjacency matrix representation
    private List<List<Integer>> adjacencyList; // Adjacency list representation
//1->6,7,8,0
    // Constructor to initialize the graph
    public Graph(int numNodes, boolean isDirected, double edgeProbability) {
        this.numNodes = numNodes;
        adjacencyMatrix = new boolean[numNodes][numNodes];
        adjacencyList = new ArrayList<>(numNodes);

        // Initialize adjacency list
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Generate random edges
        Random random = new Random();
        for (int u = 0; u < numNodes; u++) {
            for (int v = 0; v < numNodes; v++) {
                if (u != v && random.nextDouble() < edgeProbability) {
                    addEdge(u, v, isDirected);
                }
            }
        }
    }

    // Add an edge to the graph
    private void addEdge(int u, int v, boolean isDirected) {
        adjacencyMatrix[u][v] = true; // Add edge in adjacency matrix
        adjacencyList.get(u).add(v); // Add edge in adjacency list

        if (!isDirected) {//la halatekda agar edge akaman arastay nabw wata bidirectional bw 
            adjacencyMatrix[v][u] = true; // Add reverse edge for undirected graph
            adjacencyList.get(v).add(u); // Add reverse edge for undirected graph
        }
    }

    // Get adjacency matrix
    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    // Get adjacency list
    public List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    // Print adjacency matrix
    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    // Print adjacency list
    public void printAdjacencyList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < numNodes; i++) {
            System.out.print(i + ": ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}