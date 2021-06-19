package org.dslib.graph.unweighted;

public class GraphIntegerNodeImpl extends AbstractGraphImpl {

   /* Map<Integer, List<Integer>> graph = new HashMap<>();

    @Override
    public Map<Integer, List<Integer>> addVertex(Integer vertex) {
        if (graph.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex already exists");
        }
        graph.put(vertex, new LinkedList<>());
        return graph;
    }

    @Override
    public Map<Integer, List<Integer>> addEdge(Integer sourceVertex, Integer targetVertex, Boolean isBidirectional) {
        return null;
    }

    @Override
    public Integer getNumOfVertices() {
        return graph.keySet().size();
    }

    @Override
    public Set<Integer> getVertices() {
        return graph.keySet();
    }

    @Override
    public Map<Integer, Integer> getAllEdges() {
        return null;
    }

    @Override
    public Boolean containsEdge(Integer source, Integer destination) {
        if (graph.containsKey(source) && graph.containsKey(destination)) {
            List<Integer> sourceEdges = graph.get(source);
            if (sourceEdges.contains(destination)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean containsVertex(Integer source) {
        if (graph.containsKey(source)) {
            return true;
        }
        return false;
    }

    @Override
    public Set<Integer> getVerticesInBFSOrder() {
        return null;
    }

    @Override
    public Set<Integer> getVerticesInDFSOrder() {
        return null;
    }*/


}
