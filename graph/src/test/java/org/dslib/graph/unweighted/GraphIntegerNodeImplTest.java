package org.dslib.graph.unweighted;

import org.apache.commons.collections4.MultiValuedMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class GraphIntegerNodeImplTest {

    @Test
    public void addVertexTest() {
        Graph<Integer> integerGraph = new GraphIntegerNodeImpl();
        integerGraph.addVertex(1);
        integerGraph.addVertex(2);
        integerGraph.addVertex(3);
        Integer numOfVertices = integerGraph.getNumOfVertices();

        Assertions.assertEquals(3, numOfVertices);
        Assertions.assertTrue(integerGraph.containsVertex(1));


    }

    @Test
    public void addEdgeTest() {
        Graph<Integer> integerGraph = new GraphIntegerNodeImpl();

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

        MultiValuedMap<Integer, Integer> allEdges = integerGraph.getAllEdges();
        final Collection<Integer> edgesFromNode0 = allEdges.get(0);
        Assertions.assertEquals(2, edgesFromNode0.size());


        Integer numberOfEdges = integerGraph.getNumberOfEdges();
        Assertions.assertEquals(6, numberOfEdges);

    }
}
