# Depth-First-Search Java

This is a Java implementation of the Depth-First-Search algorithm. It is a recursive algorithm that traverses a graph in a depthward motion and uses a stack to remember to get the next vertex to start a search, when a dead end occurs in any iteration.

## Usage

To use this algorithm, you need to create a graph and add vertices and edges to it. Then, you need to create a DepthFirstSearch object and pass the graph to it. Finally, you can call the search method to get the result.

## Example

```java
Graph theGraph = new Graph();
theGraph.addVertex('A'); // 0 (start for dfs)
theGraph.addVertex('B'); // 1
theGraph.addVertex('C'); // 2
theGraph.addVertex('D'); // 3
theGraph.addVertex('E'); // 4

theGraph.addEdge(0, 1); // AB
theGraph.addEdge(1, 2); // BC
theGraph.addEdge(0, 3); // AD
theGraph.addEdge(3, 4); // DE

System.out.print("Visits: ");
theGraph.dfs(); // depth-first search
System.out.println();
```

Copyright (c) 2022, Max Base
