// Clase que va a representar el grafo
public class Graph {
    private int[][] adjacencyMatrix; // Matriz de adyacencia
    private int numberOfVertices; // Número de vértices

    public Graph(int vertices) {
        this.numberOfVertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0; // Distancia a sí mismo es 0
                } else {
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE; // Inicialmente infinito
                }
            }
        }
    }

    // Método para agregar un edge
    public void addEdge(int start, int end, int weight) {
        adjacencyMatrix[start][end] = weight; // Agrega peso
    }

    // Método para la matriz de adyacencia
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    // Método para el número de vértices
    public int getNumberOfVertices() {
        return numberOfVertices;
    }
}
