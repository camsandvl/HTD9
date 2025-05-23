// Clase que calcula el centro del grafo
public class GraphCenter {
    private int[][] shortestPaths; // matriz de los caminos más cortos
    private int numberOfVertices;

    public GraphCenter(int[][] shortestPaths, int vertices) {
        this.shortestPaths = shortestPaths;
        this.numberOfVertices = vertices;
    }

    // Método para el calculo del centro 
    public int calculateCenter() {
        int center = -1;
        int minMaxDistance = Integer.MAX_VALUE;

        for (int i = 0; i < numberOfVertices; i++) {
            int maxDistance = 0;
            for (int j = 0; j < numberOfVertices; j++) {
                int distance = shortestPaths[i][j];
                if (distance != Integer.MAX_VALUE) {
                    maxDistance = Math.max(maxDistance, distance);
                }
            }
            if (maxDistance < minMaxDistance) {
                minMaxDistance = maxDistance;
                center = i; 
            }
        }
        return center; // devuelve el centro
    }
}
