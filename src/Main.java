
public class Main {
    public static void main(String[] args) {
        int numNodes = 10; // Number of nodes in the graph
        int start = 0; // Start node for all searches
        int target = 9; // Target node for IDS

        // Generate graphs
        Graph sparseDirected = new Graph(numNodes, true, 0.2); // Sparse Directed Graph
        Graph denseDirected = new Graph(numNodes, true, 0.7); // Dense Directed Graph
        Graph sparseUndirected = new Graph(numNodes, false, 0.2); // Sparse Undirected Graph
        Graph denseUndirected = new Graph(numNodes, false, 0.7); // Dense Undirected Graph

        // Print adjacency lists and matrices (optional)
        System.out.println("Sparse Directed Graph:");
        sparseDirected.printAdjacencyList();
        sparseDirected.printAdjacencyMatrix();

        System.out.println("\nDense Directed Graph:");
        denseDirected.printAdjacencyList();
        denseDirected.printAdjacencyMatrix();

        System.out.println("\nSparse Undirected Graph:");
        sparseUndirected.printAdjacencyList();
        sparseUndirected.printAdjacencyMatrix();

        System.out.println("\nDense Undirected Graph:");
        denseUndirected.printAdjacencyList();
        denseUndirected.printAdjacencyMatrix();

        // Run algorithms and measure execution time
        runAlgorithms(sparseDirected, "Sparse Directed Graph", start, target);
        runAlgorithms(denseDirected, "Dense Directed Graph", start, target);
        runAlgorithms(sparseUndirected, "Sparse Undirected Graph", start, target);
        runAlgorithms(denseUndirected, "Dense Undirected Graph", start, target);
    }
//bo run krdny algothimakan dana ba dana ba wrdy
    private static void runAlgorithms(Graph graph, String graphType, int start, int target) {
        System.out.println("\n===== " + graphType + " =====");
    
        // BFS - Adjacency List
        long startTime = System.nanoTime();
        SearchResult bfsListResult = BFS.bfsList(graph.getAdjacencyList(), start, target);//dozinaway pathy targetaka 
        long endTime = System.nanoTime();
        long bfsListTime = (endTime - startTime);
        System.out.println("BFS (Adjacency List):");
        System.out.println("Path: " + bfsListResult.path);
        System.out.println("Nodes Visited: " + bfsListResult.visitedNodes);
        System.out.println("Status: " + bfsListResult.status);
        System.out.println("Found Node: " + (bfsListResult.foundNode != null ? bfsListResult.foundNode : "Not Found"));
        System.out.println("Execution Time: " + bfsListTime + " nanos");
    
        // BFS - Adjacency Matrix
        startTime = System.nanoTime();
        SearchResult bfsMatrixResult = BFS.bfsMatrix(graph.getAdjacencyMatrix(), start, target);
        endTime = System.nanoTime();
        long bfsMatrixTime = (endTime - startTime);
        System.out.println("BFS (Adjacency Matrix):");
        System.out.println("Path: " + bfsMatrixResult.path);
        System.out.println("Nodes Visited: " + bfsMatrixResult.visitedNodes);
        System.out.println("Status: " + bfsMatrixResult.status);
        System.out.println("Found Node: " + (bfsMatrixResult.foundNode != null ? bfsMatrixResult.foundNode : "Not Found"));
        System.out.println("Execution Time: " + bfsMatrixTime + " nanos");
    
        // DFS - Adjacency List
        startTime = System.nanoTime();
        SearchResult dfsListResult = DFS.dfsList(graph.getAdjacencyList(), start, target);
        endTime = System.nanoTime();
        long dfsListTime = (endTime - startTime);
        System.out.println("DFS (Adjacency List):");
        System.out.println("Path: " + dfsListResult.path);
        System.out.println("Nodes Visited: " + dfsListResult.visitedNodes);
        System.out.println("Status: " + dfsListResult.status);
        System.out.println("Found Node: " + (dfsListResult.foundNode != null ? dfsListResult.foundNode : "Not Found"));
        System.out.println("Execution Time: " + dfsListTime + " nanos");
    
        // DFS - Adjacency Matrix
        startTime = System.nanoTime();
        SearchResult dfsMatrixResult = DFS.dfsMatrix(graph.getAdjacencyMatrix(), start, target);
        endTime = System.nanoTime();
        long dfsMatrixTime = (endTime - startTime);
        System.out.println("DFS (Adjacency Matrix):");
        System.out.println("Path: " + dfsMatrixResult.path);
        System.out.println("Nodes Visited: " + dfsMatrixResult.visitedNodes);
        System.out.println("Status: " + dfsMatrixResult.status);
        System.out.println("Found Node: " + (dfsMatrixResult.foundNode != null ? dfsMatrixResult.foundNode : "Not Found"));
        System.out.println("Execution Time: " + dfsMatrixTime + " nanos");
    
        // IDS - Adjacency List
        startTime = System.nanoTime();
        SearchResult idsListResult = IDS.idsList(graph.getAdjacencyList(), start, target);
        endTime = System.nanoTime();
        long idsListTime = (endTime - startTime);
        System.out.println("IDS (Adjacency List):");
        System.out.println("Path: " + idsListResult.path);
        System.out.println("Nodes Visited: " + idsListResult.visitedNodes);
        System.out.println("Status: " + idsListResult.status);
        System.out.println("Found Node: " + (idsListResult.foundNode != null ? idsListResult.foundNode : "Not Found"));
        System.out.println("Execution Time: " + idsListTime + " nanos");
    
        // IDS - Adjacency Matrix
        startTime = System.nanoTime();
        SearchResult idsMatrixResult = IDS.idsMatrix(graph.getAdjacencyMatrix(), start, target);
        endTime = System.nanoTime();
        long idsMatrixTime = (endTime - startTime);
        System.out.println("IDS (Adjacency Matrix):");
        System.out.println("Path: " + idsMatrixResult.path);
        System.out.println("Nodes Visited: " + idsMatrixResult.visitedNodes);
        System.out.println("Status: " + idsMatrixResult.status);
        System.out.println("Found Node: " + (idsMatrixResult.foundNode != null ? idsMatrixResult.foundNode : "Not Found"));
        System.out.println("Execution Time: " + idsMatrixTime + " nanos");
    }
}