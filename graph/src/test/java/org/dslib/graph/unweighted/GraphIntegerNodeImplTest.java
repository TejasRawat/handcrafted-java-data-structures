package org.dslib.graph.unweighted;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphIntegerNodeImplTest {

    @Test
    public void addVertexTest() {
        Graph<Integer> integerGraph = new GraphIntegerNodeImpl();
        integerGraph.addVertex(1);
        integerGraph.addVertex(2);
        integerGraph.addVertex(3);
        Integer numOfVertices = integerGraph.getNumOfVertices();

        Assertions.assertEquals(3, numOfVertices);

    }
}
