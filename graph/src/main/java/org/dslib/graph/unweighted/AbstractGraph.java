package org.dslib.graph.unweighted;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.*;

/**
 * Node0 : [Node1,Node2]
 * Node1 : [Node2]
 * Node2 : [Node1,Node3]
 * Node3 : [Node3]
 */
public class AbstractGraph<T> implements Graph<T> {

    Map<T, Set<T>> graph = new HashMap<>();

    @Override
    public Map<T, Set<T>> addVertex(T vertex) {
        if (graph.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex already exists");
        }
        graph.put(vertex, new LinkedHashSet<>());
        return graph;
    }

    @Override
    public Map<T, Set<T>> addEdge(T sourceVertex, T targetVertex, Boolean isBidirectional) {
        if (!containsVertex(sourceVertex)) {
            throw new IllegalArgumentException("Source Vertex does not present");
        }
        if (!containsVertex(targetVertex)) {
            throw new IllegalArgumentException("Target Vertex does not present");
        }
        graph.get(sourceVertex).add(targetVertex);
        if (isBidirectional) {
            graph.get(targetVertex).add(sourceVertex);
        }
        return graph;
    }

    @Override
    public Integer getNumOfVertices() {
        return graph.keySet().size();
    }

    @Override
    public Integer getNumberOfEdges() {
        Integer numOfEdges = 0;
        for (Map.Entry<T, Set<T>> entry : graph.entrySet()) {
            numOfEdges = numOfEdges + entry.getValue().size();
        }
        return numOfEdges;
    }

    @Override
    public Set<T> getVertices() {
        return graph.keySet();
    }

    @Override
    public Set<T> getConnectedVertices(T sourceNode) {
        if (graph.containsKey(sourceNode)) {
            return graph.get(sourceNode);
        }
        return new HashSet<>();
    }

    @Override
    public MultiValuedMap<T, T> getAllEdges() {
        MultiValuedMap<T, T> edges = new ArrayListValuedHashMap<>();
        for (Map.Entry<T, Set<T>> entry : graph.entrySet()) {
            for (T edge : entry.getValue()) {
                edges.put(entry.getKey(), edge);
            }
        }
        return edges;
    }

    @Override
    public Boolean containsEdge(T source, T destination) {
        if (graph.containsKey(source) && graph.containsKey(destination)) {
            Set<T> sourceEdges = graph.get(source);
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
    public Set<T> getVerticesInBFSOrder(T sourceNode) {
        Set<T> visitedVertex = new LinkedHashSet<>();
        Queue<T> nodeQueue = new LinkedList<>();
        nodeQueue.add(sourceNode);

        while (nodeQueue.size() > 0) {
            final T peek = nodeQueue.peek();
            Set<T> connectedVertices = getConnectedVertices(peek);
            for (T vertex : connectedVertices) {
                if (!visitedVertex.contains(vertex)) {
                    nodeQueue.add(vertex);
                }
            }
            visitedVertex.add(nodeQueue.poll());
        }
        return visitedVertex;
    }

    @Override
    public Set<T> getVerticesInDFSOrder(T sourceNode) {
        return null;
    }


    @Override
    public String toString() {
        return "AbstractGraphImpl{" +
                "graph=" + graph +
                '}';
    }
}
