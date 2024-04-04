import java.util.*;

class Edge {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int vertices;
    List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencyList.get(source).add(edge);

        edge = new Edge(destination, source, weight);
        adjacencyList.get(destination).add(edge);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            List<Edge> list = adjacencyList.get(i);
            System.out.print("Wierzchołek " + i + " sąsiaduje z:");
            for (Edge edge : list) {
                System.out.print(" -> " + edge.destination + "(waga: " + edge.weight + ")");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 5);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 3, 6);
        graph.addEdge(3, 4, 1);

        graph.printGraph();
    }
}
