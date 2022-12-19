class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;
    
    public StackX()
    {
        st = new int[SIZE];
        top = -1;
    }
    
    public void push(int j)
    {
        st[++top] = j;
    }
    
    public int pop()
    {
        return st[top--];
    }
    
    public int peek()
    {
        return st[top];
    }
    
    public boolean isEmpty()
    {
        return (top == -1);
    }
}

class Vertex {
    public char label;
    public boolean wasVisited;
    
    public Vertex(char lab)
    {
        label = lab;
        wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // List of vertices
    private int adjMat[][]; // Adjacency matrix
    private int nVerts; // Current number of vertices
    private StackX theStack;

    public Graph()
    {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // Set adjacency
            for (int k = 0; k < MAX_VERTS; k++) // Matrix to 0
                adjMat[j][k] = 0;
        theStack = new StackX();
    }

    // Add vertex to vertex list
    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // Add edge to edge matrix
    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    // Display vertex
    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }

    // Depth-first search
    public void dfs()
    {
        if (nVerts == 0) {
            System.out.println("No vertices in graph");
            return;
        }

        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        theStack.push(0); // push it

        // Until stack empty,
        while (!theStack.isEmpty()) {
            // Get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) // if no such vertex,
                theStack.pop();
            else { // if it exists
                vertexList[v].wasVisited = true; // mark it
                displayVertex(v); // display it
                theStack.push(v); // push it
            }
        }

        // Stack is empty, so we're done
        for (int j = 0; j < nVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }
}

public class DepthFirstSearch {
    public static void main(String[] args)
    {
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
    }
}
