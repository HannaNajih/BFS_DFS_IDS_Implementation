import java.util.*;

public class BFS {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // bam methoda aw matrixay ka hamana ba BFS traversy teda dakain
    public static SearchResult bfsMatrix(boolean[][] adjacencyMatrix, int start, int target) {
        int numNodes = adjacencyMatrix.length; // Number of nodes in the graph
        boolean[] visited = new boolean[numNodes]; // Array to track visited nodes
        List<Integer> visitedOrder = new ArrayList<>(); // List to store the order of visited nodes
        List<Integer> path = new ArrayList<>(); // List to store the path from start to target
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal
        Map<Integer, Integer> parentMap = new HashMap<>(); // Map to store parent nodes for path reconstruction,
        // boya amamn bakar hena takw btwanyn path y dozinaway targetaka ba jya la visited nodakany save bkain

/// lerada hamw eshakany BFS dakain ka hardw inputy matrix w list wardagret
        queue.add(start); // Add the start node to the queue
        visited[start] = true; // Mark the start node as visited
        parentMap.put(start, -1); // Set the parent of the start node as -1 (no parent)

        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue the current node
            visitedOrder.add(vertex); // Add the current node to the visited order list

            // agar curent node targetakaya awkat bom return ka lagal aw pathay ka pey gayshtuyn
            if (vertex == target) {
                int current = vertex;
                while (current != -1) {
                    path.add(current); // current nodaka add akain bo naw listy path
                    current = parentMap.get(current); // Move to the parent node
                }
                Collections.reverse(path); // Reverse the path to get the correct order
                return new SearchResult(path, visitedOrder, "Goal Found", vertex); // Return the result
            }

            // hamw noda drawsekany current node bdozarawa 
            for (int neighbor = 0; neighbor < numNodes; neighbor++) {
                // Check if there is an edge to the neighbor and if it hasn't been visited
                //daipshknin agardrawseyak la drawsekany ka edge la newanyan haya, yan visit krawa yan na 
                if (adjacencyMatrix[vertex][neighbor] && !visited[neighbor]) {
                    visited[neighbor] = true; // Mark the neighbor as visited
                    queue.add(neighbor); // Add the neighbor to the queue
                    parentMap.put(neighbor, vertex); // r agar node drawseyakai check krabw pesh xoy ba parenty am current node daydaneyn
                }
            }
        }

        // agar target la naw graphakaman nadozrayawa awa dabet pathy dozinaway target null bet wata hych nanwsen 
        return new SearchResult(new ArrayList<>(), visitedOrder, "Search Completed", null);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // am methoda ba tanha bo drwst krdny Adjacency list
    public static SearchResult bfsList(List<List<Integer>> adjacencyList, int start, int target) {
        int numNodes = adjacencyList.size(); // Number of nodes in the graph
        boolean[] visited = new boolean[numNodes]; // Array to track visited nodes
        List<Integer> visitedOrder = new ArrayList<>(); // List to store the order of visited nodes
        List<Integer> path = new ArrayList<>(); // List to store the path from start to target
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal
        Map<Integer, Integer> parentMap = new HashMap<>(); // Map to store parent nodes for path reconstruction

        queue.add(start); // Add the start node to the queue
        visited[start] = true; // Mark the start node as visited
        parentMap.put(start, -1); // Set the parent of the start node as -1 (no parent)

        while (!queue.isEmpty()) {
            int vertex = queue.poll(); // Dequeue the current node
            visitedOrder.add(vertex); // Add the current node to the visited order list

            // If the current node is the target, reconstruct the path and return the result
            if (vertex == target) {
                int current = vertex;
                while (current != -1) {
                    path.add(current); // Add the current node to the path
                    current = parentMap.get(current); // Move to the parent node
                }
                Collections.reverse(path); // am reverse katek esh dakat current node targetaka nabet dabetbchin bo nodakany tr ta bedozinawa
                return new SearchResult(path, visitedOrder, "Goal Found", vertex); // Return the result
            }

            // Explore all neighbors of the current node
            for (int neighbor : adjacencyList.get(vertex)) {
                // Check if the neighbor hasn't been visited
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Mark the neighbor as visited
                    queue.add(neighbor); // Add the neighbor to the queue
                    parentMap.put(neighbor, vertex); // Set the current node as the parent of the neighbor
                }
            }
        }

        // If the target is not found, return the result with an empty path
        return new SearchResult(new ArrayList<>(), visitedOrder, "Search Completed", null);
    }
}