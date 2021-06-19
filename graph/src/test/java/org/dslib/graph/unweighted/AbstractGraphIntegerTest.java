package org.dslib.graph.unweighted;

import org.apache.commons.collections4.MultiValuedMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class AbstractGraphIntegerTest {

    Graph<Integer> integerGraph;

    @BeforeEach
    public void init() {
        integerGraph = new AbstractGraph();
        integerGraph.addVertex(0);
        integerGraph.addVertex(1);
        integerGraph.addVertex(2);
        integerGraph.addVertex(3);

        integerGraph.addEdge(0, 1, false);
        integerGraph.addEdge(0, 2, false);
        integerGraph.addEdge(1, 2, false);
        integerGraph.addEdge(2, 3, false);
        integerGraph.addEdge(2, 0, false);
        integerGraph.addEdge(3, 3, false);
    }

    @Test
    public void deleteEdgeTest() {
        integerGraph.deleteEdge(1, 2, false);
        Set<Integer> connectedVertices = integerGraph.getConnectedVertices(1);
        for (Integer vertex : connectedVertices) {
            Assertions.assertNotEquals(vertex, 2);
        }
    }

    @Test
    public void addVertexTest() {
        Integer numOfVertices = integerGraph.getNumOfVertices();
        Assertions.assertEquals(4, numOfVertices);
        Assertions.assertTrue(integerGraph.containsVertex(1));

        Set<Integer> vertices = integerGraph.getVertices();
        Assertions.assertTrue(vertices.contains(1));
    }

    @Test
    public void addEdgeTest() {
        MultiValuedMap<Integer, Integer> allEdges = integerGraph.getAllEdges();
        final Collection<Integer> edgesFromNode0 = allEdges.get(0);
        Assertions.assertEquals(2, edgesFromNode0.size());

        Integer numberOfEdges = integerGraph.getNumberOfEdges();
        Assertions.assertEquals(6, numberOfEdges);
        Assertions.assertEquals(integerGraph.containsEdge(0, 1), true);
        Assertions.assertEquals(integerGraph.containsEdge(0, 3), false);

    }

    @Test
    public void getVerticesInBFSOrderTest() {
        final Set<Integer> verticesInBFSOrder = integerGraph.getVerticesInBFSOrder(0);
        Integer a[] = {0, 1, 2, 3};
        int count = 0;
        for (Integer vertex : verticesInBFSOrder) {
            Assertions.assertEquals(vertex, a[count]);
            count++;
        }
    }

    @Test
    public void getVerticesInDFAOrderTest() {
        integerGraph = new AbstractGraph<>();
        integerGraph.addVertex(1);
        integerGraph.addVertex(2);
        integerGraph.addVertex(3);
        integerGraph.addVertex(4);
        integerGraph.addVertex(5);

        integerGraph.addEdge(1, 3, false);
        integerGraph.addEdge(1, 2, false);
        integerGraph.addEdge(2, 5, false);
        integerGraph.addEdge(2, 4, false);

        final Set<Integer> verticesInDFSOrder = integerGraph.getVerticesInDFSOrder(1);
        Integer a[] = {1, 2, 4, 5, 3};
        int count = 0;
        for (Integer vertex : verticesInDFSOrder) {
            Assertions.assertEquals(vertex, a[count]);
            count++;
        }
    }

    @Test
    public void getNodesWithLevelTest() {
        integerGraph = new AbstractGraph<>();
        integerGraph.addVertex(1);
        integerGraph.addVertex(2);
        integerGraph.addVertex(3);
        integerGraph.addVertex(4);
        integerGraph.addVertex(5);

        integerGraph.addEdge(1, 3, false);
        integerGraph.addEdge(1, 2, false);
        integerGraph.addEdge(2, 5, false);
        integerGraph.addEdge(2, 4, false);

        Map<Integer, Integer> nodesWithLevel = integerGraph.getNodesWithLevel(1);
        System.out.println(nodesWithLevel);
    }

}
