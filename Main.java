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
                System.out.print(" " + edge.destination + "(waga: " + edge.weight + ")");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę wierzchołków: ");
        int vertices = scanner.nextInt();
        Graph graph = new Graph(vertices);

        char choice;
        do {
            System.out.print("Podaj początek połączenia: ");
            int source = scanner.nextInt();
            System.out.print("Podaj koniec połączenia: ");
            int destination = scanner.nextInt();
            System.out.print("Podaj wagę połączenia: ");
            int weight = scanner.nextInt();
            graph.addEdge(source, destination, weight);

            System.out.print("Czy chcesz dodać kolejne połączenie? (T/N): ");
            choice = scanner.next().charAt(0);
        } while (choice == 'T' || choice == 't');

        graph.printGraph();
    }
}
