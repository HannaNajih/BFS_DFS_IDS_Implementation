import java.util.*;

public class IDS {
///////////////////////////////////////////////////////////////////////////////////////////
/// لەسەر تایپی سرج ریزەڵت دروستی دەکەین تاکو بتوانێت پارامیتەرەکانی 
/// //پاث و ڕیسبەندی چێکردنی نۆدەکان و ستاتەس و تارگەتەکەمان بۆ بگەرێنێتەوە
    // Method to perform Iterative Deepening Search (IDS) using an adjacency matrix
    public static SearchResult idsMatrix(boolean[][] adjacencyMatrix, int start, int target) {
        int depthLimit = 0; // Start with depth limit 0
        while (true) {
            boolean[] visited = new boolean[adjacencyMatrix.length]; // Array to track visited nodes
            List<Integer> visitedOrder = new ArrayList<>(); // List to store the order of visited nodes
            List<Integer> path = new ArrayList<>(); // List to store the current path
            // Perform Depth-Limited Search (DLS) with the current depth limit
            boolean found = dlsMatrix(adjacencyMatrix, start, target, depthLimit, visited, visitedOrder, path);
            if (found) {
                // If the target is found, return the result as a SearchResult object
                return new SearchResult(path, visitedOrder, "Goal Found", target);
            }//ئەگەر ئەم مەرجەی سەرەوە دروست نەبوو واتا تارگێت نەدۆزرایەوە قولبوونەوە زیاد دەکەین تاکو لە 
            //ئایتەرەیشنەکانی داهاتوودا بتوانیت تارگەت بدۆزێتەوە
            depthLimit++; // Increment the depth limit for the next iteration
        }
    }

    // Recursive helper method for Depth-Limited Search (DLS) using an adjacency matrix
    private static boolean dlsMatrix(boolean[][] adjacencyMatrix, int vertex, int target, int depthLimit, boolean[] visited, List<Integer> visitedOrder, List<Integer> path) {
        visited[vertex] = true; // Mark the current node as visited
        visitedOrder.add(vertex); // Add the current node to the visited order list
        path.add(vertex); // Add the current node to the current path

        // If the current node is the target, return true
        if (vertex == target) {
            return true;
        }

        // If the depth limit is reached, backtrack and return false
        if (depthLimit <= 0) {
            path.remove(path.size() - 1); // Remove the current node from the path
            return false;
        }

        // Explore all neighbors of the current node
        for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
            // Check if there is an edge to the neighbor and if it hasn't been visited
            if (adjacencyMatrix[vertex][neighbor] && !visited[neighbor]) {
                // Recursively perform DLS on the neighbor with a reduced depth limit
                boolean found = dlsMatrix(adjacencyMatrix, neighbor, target, depthLimit - 1, visited, visitedOrder, path);
                if (found) {
                    return true; // If the target is found in the recursion, return true
                }
            }
        }

        // If the target is not found in this path, backtrack by removing the current node from the path
        path.remove(path.size() - 1);
        return false; // Return false to indicate the target was not found in this branch
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Method to perform Iterative Deepening Search (IDS) using an adjacency list
    public static SearchResult idsList(List<List<Integer>> adjacencyList, int start, int target) {
        int depthLimit = 0; // Start with depth limit 0
        while (true) {
            boolean[] visited = new boolean[adjacencyList.size()]; // Array to track visited nodes
            List<Integer> visitedOrder = new ArrayList<>(); // List to store the order of visited nodes
            List<Integer> path = new ArrayList<>(); // List to store the current path
            // Perform Depth-Limited Search (DLS) with the current depth limit
            boolean found = dlsList(adjacencyList, start, target, depthLimit, visited, visitedOrder, path);
            if (found) {
                // If the target is found, return the result as a SearchResult object
                return new SearchResult(path, visitedOrder, "Goal Found", target);
            }
            depthLimit++; // Increment the depth limit for the next iteration
        }
    }

    // Recursive helper method for Depth-Limited Search (DLS) using an adjacency list
    private static boolean dlsList(List<List<Integer>> adjacencyList, int vertex, int target, int depthLimit, boolean[] visited, List<Integer> visitedOrder, List<Integer> path) {
        visited[vertex] = true; // Mark the current node as visited
        visitedOrder.add(vertex); // Add the current node to the visited order list
        path.add(vertex); // Add the current node to the current path

        // If the current node is the target, return true
        if (vertex == target) {
            return true;
        }

        // If the depth limit is reached, backtrack and return false
        if (depthLimit <= 0) {
            path.remove(path.size() - 1); // Remove the current node from the path
            return false;
        }

        // Explore all neighbors of the current node
        for (int neighbor : adjacencyList.get(vertex)) {
            // Check if the neighbor hasn't been visited
            if (!visited[neighbor]) {
                // Recursively perform DLS on the neighbor with a reduced depth limit
                boolean found = dlsList(adjacencyList, neighbor, target, depthLimit - 1, visited, visitedOrder, path);
                if (found) {
                    return true; // If the target is found in the recursion, return true
                }
            }
        }

        // If the target is not found in this path, backtrack by removing the current node from the path
        path.remove(path.size() - 1);
        return false; // Return false to indicate the target was not found in this branch
    }
}