package org.dslib.graph.unweighted;

import java.util.*;

public class AbstractGraphImpl<T> implements Graph<T> {

    Map<T, List<T>> graph = new HashMap<>();

    @Override
    public Map<T, List<T>> addVertex(T vertex) {
        if (graph.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex already exists");
        }
        graph.put(vertex, new LinkedList<>());
        return graph;
    }

    @Override
    public Map<T, List<T>> addEdge(T sourceVertex, T targetVertex, Boolean isBidirectional) {
        return null;
    }

    @Override
    public Integer getNumOfVertices() {
        return graph.keySet().size();
    }

    @Override
    public Set<T> getVertices() {
        return graph.keySet();
    }

    @Override
    public Map<T, T> getAllEdges() {
        return null;
    }

    @Override
    public Boolean containsEdge(T source, T destination) {
        if (graph.containsKey(source) && graph.containsKey(destination)) {
            List<T> sourceEdges = graph.get(source);
            if (sourceEdges.contains(destination)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean containsVertex(T source) {
        if (graph.containsKey(source)) {
            return true;
        }
        return false;
    }

    @Override
    public Set<T> getVerticesInBFSOrder() {
        return null;
    }

    @Override
    public Set<T> getVerticesInDFSOrder() {
        return null;
    }
}
