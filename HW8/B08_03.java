package Home.HW8;

import java.util.*;

public class B08_03<T> {

    // Список суміжності: вершина -> список суміжних вершин
    private HashMap<T, List<T>> adjacencyList;

    public B08_03() {
        adjacencyList = new HashMap<>();
    }

    // верщини
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) return;

        // Видаляємо всі ребра до цієї вершини
        for (T neighbor : adjacencyList.get(vertex)) {
            adjacencyList.get(neighbor).remove(vertex);
        }

        adjacencyList.remove(vertex);
    }

    // ребра
    public void addEdge(T v1, T v2) {
        addVertex(v1);
        addVertex(v2);

        adjacencyList.get(v1).add(v2);
        adjacencyList.get(v2).add(v1); // неорієнтований граф
    }

    public void removeEdge(T v1, T v2) {
        if (adjacencyList.containsKey(v1)) {
            adjacencyList.get(v1).remove(v2);
        }
        if (adjacencyList.containsKey(v2)) {
            adjacencyList.get(v2).remove(v1);
        }
    }

    //суміжні вершини
    public List<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    // друкуємо граф
    public void printGraph() {
        for (T vertex : adjacencyList.keySet()) {
            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }


    public static void main(String[] args) {
        B08_03<String> graph = new B08_03<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        System.out.println("Граф після додавання вершин і ребер:");
        graph.printGraph();

        graph.removeEdge("A", "C");
        System.out.println("\nПісля видалення ребра A-C:");
        graph.printGraph();

        graph.removeVertex("B");
        System.out.println("\nПісля видалення вершини B:");
        graph.printGraph();
    }
}
