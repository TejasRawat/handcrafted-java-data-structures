package org.dslib.graph.unweighted;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Graph<T> {

    Map<T, List<T>> addVertex(T vertex);

    Map<T, List<T>> addEdge(T sourceVertex, T targetVertex, Boolean isBidirectional);

    Integer getNumOfVertices();

    Set<T> getVertices();

    Map<T, T> getAllEdges();

    Boolean containsEdge(T source, T destination);

    Boolean containsVertex(T source);

    Set<T> getVerticesInBFSOrder();

    Set<T> getVerticesInDFSOrder();

}
