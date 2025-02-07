


public class Graphgenerator {

    public static graph generateSparseDirectedGraph(int nodes) {
        return graph.generateRandomGraph(nodes, 0.2, true);
    }

    public static graph generateDenseDirectedGraph(int nodes) {
        return graph.generateRandomGraph(nodes, 0.7, true);
    }

    public static graph generateSparseUndirectedGraph(int nodes) {
        return graph.generateRandomGraph(nodes, 0.2, false);
    }

    public static graph generateDenseUndirectedGraph(int nodes) {
        return graph.generateRandomGraph(nodes, 0.7, false);
    }
}