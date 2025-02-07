

import java.util.*;

public class GraphAlgorithms {

    public static List<Integer> bfs(graph graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        boolean[] visitedArray = new boolean[graph.getNodes()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visitedArray[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);

            for (int neighbor : graph.getAdjacencyList().get(node)) {
                if (!visitedArray[neighbor]) {
                    visitedArray[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return visited;
    }

    public static List<Integer> dfs(graph graph, int startNode) {
        List<Integer> visited = new ArrayList<>();
        boolean[] visitedArray = new boolean[graph.getNodes()];
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visitedArray[node]) {
                visitedArray[node] = true;
                visited.add(node);

                for (int neighbor : graph.getAdjacencyList().get(node)) {
                    if (!visitedArray[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return visited;
    }

    public static List<Integer> ids(graph graph, int startNode, int targetNode, int maxDepth) {
        for (int depth = 0; depth <= maxDepth; depth++) {
            List<Integer> visited = new ArrayList<>();
            if (dls(graph, startNode, targetNode, depth, visited, new boolean[graph.getNodes()])) {
                return visited;
            }
        }
        return new ArrayList<>();
    }

    private static boolean dls(graph graph, int node, int targetNode, int depth, List<Integer> visited, boolean[] visitedArray) {
        visited.add(node);
        visitedArray[node] = true;

        if (node == targetNode) {
            return true;
        }

        if (depth == 0) {
            return false;
        }

        for (int neighbor : graph.getAdjacencyList().get(node)) {
            if (!visitedArray[neighbor]) {
                if (dls(graph, neighbor, targetNode, depth - 1, visited, visitedArray)) {
                    return true;
                }
            }
        }
        visited.remove(visited.size() - 1);  // Backtrack
        return false;
    }
}