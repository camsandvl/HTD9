
public class Main {
    public static void main(String[] args) {
        // crea un grafo con los 5 vértices
        Graph graph = new Graph(5);
        
        // agrega arcos según la tabla
        graph.addEdge(0, 1, 3); // A > B
        graph.addEdge(1, 2, 1); // B > C
        graph.addEdge(1, 4, 8); // B > E
        graph.addEdge(2, 3, 2); // C > D
        graph.addEdge(3, 4, 3); // D > E
        graph.addEdge(0, 3, 7); // A > D
        graph.addEdge(4, 0, 4); // E > A

        // crear el objeto de Floyd-Warshall
        FloydWarshall fw = new FloydWarshall(graph);
        int[][] shortestPaths = fw.calculateShortestPaths(); // Calcular caminos más cortos

        // para imprimir las distancias desde la ciudad 
        fw.printShortestPathsFromCapital(shortestPaths);

        // calculo del centro del grafo
        GraphCenter centerCalculator = new GraphCenter(shortestPaths, graph.getNumberOfVertices());
        int center = centerCalculator.calculateCenter();
        
        // imprimir el centro
        System.out.println("El centro del grafo es el vértice: " + center);
    }
}
