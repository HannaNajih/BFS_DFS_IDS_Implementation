import java.util.*;

public class DFS {
/////////////////////////////////////////////////////////////////////////////////////////
    //bam methoda matrixaka ba BFS search dakain
    public static SearchResult dfsMatrix(boolean[][] adjacencyMatrix, int start, int target) {
        int numNodes = adjacencyMatrix.length; // Number of nodes in the graph
        boolean[] visited = new boolean[numNodes]; // Array to track visited nodes
        List<Integer> visitedOrder = new ArrayList<>(); // List to store the order of visited nodes
        List<Integer> path = new ArrayList<>(); // List to store the current path
        boolean found = dfsMatrixRecursive(adjacencyMatrix, start, target, visited, visitedOrder, path); // Perform DFS recursively

        // Return the result as a SearchResult object
        return new SearchResult(path, visitedOrder, found ? "Goal Found" : "Search Completed", found ? target : null);
    }
///////////////////////////////////////////////////////////////////////////////////////////
    //am methoda recursive dubara searchman bo dakat ba qully la naw matrixakamanda takw hamw node akan traverse bkat
    private static boolean dfsMatrixRecursive(boolean[][] adjacencyMatrix, int vertex,
     int target, boolean[] visited, List<Integer> visitedOrder, List<Integer> path) {
        visited[vertex] = true; // Mark the current node as visited
        visitedOrder.add(vertex); // Add the current node to the visited order list
        path.add(vertex); // Add the current node to the current path

        // If the current node is the target, return true
        if (vertex == target) {
            return true;
        }

        // Explore all neighbors of the current node, agar current node target bet yan na har traverse dakat takw kota vertex(node)
        for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
            // Check if there is an edge to the neighbor and if it hasn't been visited
            if (adjacencyMatrix[vertex][neighbor] && !visited[neighbor]) {
                // Recursively perform DFS on the neighbor
                if (dfsMatrixRecursive(adjacencyMatrix, neighbor, target, visited, visitedOrder, path)) {
                    return true; // If the target is found in the recursion, return true
                }
            }
        }
        //agar am current node target nabw, wata lam brancha targetakai teda nabw awa mn current node akama darawa la listaka, bamash dacheta naw 
        //brancheke tr bo nmuna agar child lai  chapcheck krabet aw dakaina darawa achin bo child lai rast
        // If the target is not found in this path, backtrack by removing the current node from the path
        path.remove(path.size() - 1);
        return false; // Return false to indicate the target was not found in this branch
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Method to perform DFS using an adjacency list
    public static SearchResult dfsList(List<List<Integer>> adjacencyList, int start, int target) {
        int numNodes = adjacencyList.size(); // Number of nodes in the graph
        boolean[] visited = new boolean[numNodes]; // Array to track visited nodes
        List<Integer> visitedOrder = new ArrayList<>(); // List to store the order of visited nodes
        List<Integer> path = new ArrayList<>(); // List to store the current path
        boolean found = dfsListRecursive(adjacencyList, start, target, visited, visitedOrder, path); // Perform DFS recursively

        // Return the result as a SearchResult object
        return new SearchResult(path, visitedOrder, found ? "Goal Found" : "Search Completed", found ? target : null);
    }
///////////////////////////////////////////////////////////////////////////////////
    // Recursive helper method for DFS using an adjacency list
    private static boolean dfsListRecursive(List<List<Integer>> adjacencyList, int vertex, int target, boolean[] visited, List<Integer> visitedOrder, List<Integer> path) {
        visited[vertex] = true; // Mark the current node as visited
        visitedOrder.add(vertex); // Add the current node to the visited order list
        path.add(vertex); // Add the current node to the current path

        // If the current node is the target, return true
        if (vertex == target) {
            return true;
        }

        // Explore all neighbors of the current node
        for (int neighbor : adjacencyList.get(vertex)) {
            // Check if the neighbor hasn't been visited
            if (!visited[neighbor]) {
                // Recursively perform DFS on the neighbor
                if (dfsListRecursive(adjacencyList, neighbor, target, visited, visitedOrder, path)) {
                    return true; // If the target is found in the recursion, return true
                }
            }
        }

        // If the target is not found in this path, backtrack by removing the current node from the path
        path.remove(path.size() - 1);
        return false; // Return false to indicate the target was not found in this branch
    }
}