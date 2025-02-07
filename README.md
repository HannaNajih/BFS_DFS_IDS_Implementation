# Advanced Algorithm Project Two

## Project Objective
The goal of this project is to deepen your understanding and practical implementation skills of fundamental graph search algorithms. You will also investigate how different graph representations affect the performance of these algorithms. By implementing Breadth-First Search (BFS), Depth-First Search (DFS), and Iterative Deepening Search (IDS), you will gain hands-on experience with graph data structures and search algorithms. This project will enable you to compare and analyze the performance differences of these algorithms on various types of graphs when using different graph representations (adjacency matrix and adjacency list).

## Problem Description
In this project, you are required to implement the following three graph search algorithms:
1. Breadth-First Search (BFS) – Refer to section 20.2 of the CLRS textbook.
2. Depth-First Search (DFS) – Refer to section 20.3 of the CLRS textbook.
3. Iterative Deepening Search (IDS)

These algorithms must be executed on four different types of graphs:
1. Sparse Directed Graph
2. Dense Directed Graph
3. Sparse Undirected Graph
4. Dense Undirected Graph

## Graph Generation and Representation
- **Graph Size**: For each graph type, a graph with ten nodes is generated.
- **Random Generation**: Graph generation is random, using random numbers and probabilities.
- **Sparse vs. Dense**:
  - Sparse Graphs: The probability of an edge existing between two nodes is low (e.g., a probability of 0.2).
  - Dense Graphs: The probability of an edge existing between two nodes is high (e.g., a probability of 0.7).
- **Directed vs. Undirected**:
  - Directed Graphs: Edges have a direction (from one node to another).
  - Undirected Graphs: Edges are bidirectional. When generating random edges for undirected graphs, if an edge is created between node A and B, it implies an edge exists from A to B and from B to A. In directed graphs, an edge can exist from A to B, B to A, or both, or neither.

## Graph Representations
Each generated graph is represented in memory using the following two methods:
1. **Adjacency Matrix**: A two-dimensional array that indicates the presence of an edge between nodes.
2. **Adjacency List**: An array of lists, where each list for a node contains its neighboring nodes.

## Implementation Requirements
- **Programming Language**: Java.
- **Algorithm Implementation for Both Representations**: Implement BFS, DFS, and IDS algorithms for both graph representations (adjacency matrix and adjacency list).
- **Start Node**: Assume node number 0 is the starting node for all searches.
- **Output**: For each algorithm execution on each graph type and for both graph representations, provide the following output:
  - Graph Representation: Specify which graph representation was used (Adjacency Matrix or Adjacency List).
  - Visited Nodes: A list of nodes visited by the algorithm, in the order they were visited.
  - Experiment Results: Present the results of running the algorithms on all four graph types and for both graph representations in a tabular or graphical format.
  - Comparison of Graph Representations: Compare the performance of the algorithms using the adjacency matrix and adjacency list representations and analyze the results.

## Evaluation Criteria
- **Implementation Correctness**: The algorithms must be implemented correctly and produce accurate results for both adjacency matrix and adjacency list representations.
- **Code Quality**: The code should be readable, well-organized, documented, and written following good programming principles.
- **Report Completeness**: The report should be comprehensive, clear, and include all the requested items such as graph representation used, paths found, nodes visited, and search status.

## Running the Project
To run the project, execute the `Main` class located in the `src/main/java/com/example/graph` directory. The program will generate the graphs, run the algorithms, and print the results.

## Testing
Unit tests for the graph algorithms are provided in the `GraphAlgorithmsTest` class located in the `src/test/java/com/example/graph` directory. To run the tests, execute the test class using a testing framework like JUnit.

## Important Notes
- When generating random graphs, ensure that the probabilities are applied correctly and that sparse and dense graphs are genuinely different.
- For the IDS algorithm, ensure that you correctly increase the search depth iteratively.