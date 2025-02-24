import java.util.List;

public class SearchResult {
    public List<Integer> path; // The path from start to target (if found)
    public List<Integer> visitedNodes; // All nodes visited during the search
    public String status; // Search status (e.g., "Goal Found" or "Search Completed")
    public Integer foundNode; // The target node if found, otherwise null or -1

    public SearchResult(List<Integer> path, List<Integer> visitedNodes, String status, Integer foundNode) {
        this.path = path;
        this.visitedNodes = visitedNodes;
        this.status = status;
        this.foundNode = foundNode;
    }
}