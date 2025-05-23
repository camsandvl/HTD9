import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FloydTest {
    private Graph graph;
    private FloydWarshall fw;

    @BeforeEach
    public void setUp() {
        // Inicializar el grafo con 5 vértices
        graph = new Graph(5);
    
        
        // Agregar algunos arcos para las pruebas
        graph.addEdge(0, 1, 3); // A -> B
        graph.addEdge(1, 2, 1); // B -> C
        graph.addEdge(2, 3, 2); // C -> D
        graph.addEdge(0, 3, 7); // A -> D

        fw = new FloydWarshall(graph);
    }

    @Test
    public void testAddEdge() {
        // Verificar que el arco se haya agregado correctamente
        assertEquals(3, graph.getAdjacencyMatrix()[0][1]); // A -> B
        assertEquals(1, graph.getAdjacencyMatrix()[1][2]); // B -> C
    }

    @Test
    public void testRemoveEdge() {
        // Agregar un arco y luego simular su eliminación
        graph.addEdge(1, 3, 5); // B -> D
        assertEquals(5, graph.getAdjacencyMatrix()[1][3]); // B -> D
        
        // Simular eliminación de arco
        graph.addEdge(1, 3, Integer.MAX_VALUE); // B -> D eliminado
        
        // Verificar que el arco se haya "eliminado"
        assertEquals(Integer.MAX_VALUE, graph.getAdjacencyMatrix()[1][3]); // B -> D
    }

    @Test
    public void testFloydWarshall() {
        // Calcular los caminos más cortos
        int[][] shortestPaths = fw.calculateShortestPaths();
        
        // Verificar distancias
        assertEquals(3, shortestPaths[0][1]); // A -> B
        assertEquals(4, shortestPaths[0][2]); // A -> C (A -> B -> C)
        assertEquals(6, shortestPaths[0][3]); // A -> D (A -> B -> C -> D)
    }

    @Test
    public void testNoPath() {
        // Calcular los caminos más cortos
        int[][] shortestPaths = fw.calculateShortestPaths();
        
        // Verificar que no hay camino entre A y E (no existe)
        assertEquals(Integer.MAX_VALUE, shortestPaths[0][4]); // A -> E
    }
}
