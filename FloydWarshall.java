// La clase que implementa el algoritmo de Floyd-Warshall
public class FloydWarshall {
    private Graph graph;

    public FloydWarshall(Graph graph) {
        this.graph = graph;
    }

    // el metodo para calcular los caminos más cortos
    public int[][] calculateShortestPaths() {
        int vertices = graph.getNumberOfVertices();
        int[][] dist = new int[vertices][vertices];

        // copiar la matriz de adyacencia a la matriz de distancias
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                dist[i][j] = graph.getAdjacencyMatrix()[i][j];
            }
        }

        // aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        return dist; // devolver la matriz 
    }

    // método para imprimir las distancias desde la capital
    public void printShortestPathsFromCapital(int[][] shortestPaths) {
        int capitalIndex = 0; // index de la ciudad capital A
        System.out.println("Distancias desde la Ciudad de Guatemala (Capital):");
        for (int i = 0; i < shortestPaths.length; i++) {
            if (shortestPaths[capitalIndex][i] == Integer.MAX_VALUE) {
                System.out.println("A la estación " + (char)('A' + i) + ": Infinito (no hay ruta)");
            } else {
                System.out.println("A la estación " + (char)('A' + i) + ": " + shortestPaths[capitalIndex][i] + " km");
            }
        }
    }
}
