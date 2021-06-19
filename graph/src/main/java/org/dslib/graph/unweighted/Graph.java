package org.dslib.graph.unweighted;

import org.apache.commons.collections4.MultiValuedMap;

import java.util.Map;
import java.util.Set;

public interface Graph<T> {

    Map<T, Set<T>> addVertex(T vertex);

    Map<T, Set<T>> addEdge(T sourceVertex, T targetVertex, Boolean isBidirectional);

    Map<T, Set<T>> deleteEdge(T sourceVertex, T targetVertex, Boolean isBidirectional);

    Map<T, Integer> getNodesWithLevel(T sourceVertex);

    Integer getNumOfVertices();

    Integer getNumberOfEdges();

    Set<T> getVertices();

    Set<T> getConnectedVertices(T sourceNode);

    MultiValuedMap<T, T> getAllEdges();

    Boolean containsEdge(T source, T destination);

    Boolean containsVertex(T source);

    Set<T> getVerticesInBFSOrder(T sourceNode);

    Set<T> getVerticesInDFSOrder(T sourceNode);

}
