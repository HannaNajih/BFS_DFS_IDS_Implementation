
import java.util.List;

public class Main {
    public static void main(String[] args) {
        graph sparseDirectedGraph = Graphgenerator.generateSparseDirectedGraph(10);
        graph denseDirectedGraph = Graphgenerator.generateDenseDirectedGraph(10);
        graph sparseUndirectedGraph = Graphgenerator.generateSparseUndirectedGraph(10);
        graph denseUndirectedGraph = Graphgenerator.generateDenseUndirectedGraph(10);

        runAlgorithmsOnGraph(sparseDirectedGraph, "Sparse Directed Graph");
        runAlgorithmsOnGraph(denseDirectedGraph, "Dense Directed Graph");
        runAlgorithmsOnGraph(sparseUndirectedGraph, "Sparse Undirected Graph");
        runAlgorithmsOnGraph(denseUndirectedGraph, "Dense Undirected Graph");
    }

    private static void runAlgorithmsOnGraph(graph graph, String graphType) {
        System.out.println("Running algorithms on " + graphType);

        List<Integer> bfsResult = GraphAlgorithms.bfs(graph, 0);
        System.out.println("BFS Visited Nodes: " + bfsResult);

        List<Integer> dfsResult = GraphAlgorithms.dfs(graph, 0);
        System.out.println("DFS Visited Nodes: " + dfsResult);

        List<Integer> idsResult = GraphAlgorithms.ids(graph, 0, 9, 10);
        System.out.println("IDS Visited Nodes: " + idsResult);

        System.out.println();
    }
}