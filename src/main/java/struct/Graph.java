package struct;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;


    public Graph(List<Node> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    /**
     * Finds the shortest path between two Nodes
     *
     * @param source Starting Node
     * @param target Destination Node
     * @return a List of Nodes that represent the shortest path from source to target
     */
    public List<Node> findShortestPath(Node source, Node target) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        source.setDistanceFromSource(0);
        queue.add(source);

        do {
            Node current = queue.poll();
            int id = nodes.indexOf(current);
            double currentDistance = current.getDistanceFromSource();
            List<Edge> paths = getPathsFrom(current);
            for (Edge e : paths) {
                Node n;
                if (e.getSource() == id) {
                    n = nodes.get(e.getTarget());
                } else {
                    n = nodes.get(e.getSource());
                }
                if (n == current.getBestNeighbor()) continue;

                double cost = e.getCost();

                if (currentDistance + cost < n.getDistanceFromSource()) {
                    n.setDistanceFromSource(currentDistance + cost);
                    if (n.getBestNeighbor() == null) {
                        queue.add(n);
                    }
                    n.setBestNeighbor(current);
                }
            }
        } while (!queue.isEmpty() && target.getBestNeighbor() == null);

        List<Node> shortestPath = new ArrayList<>();
        Node n = target;
        shortestPath.add(n);
        do {
            n = n.getBestNeighbor();
            shortestPath.add(0, n);
        } while (n.getBestNeighbor() != null);
        return shortestPath;
    }

    /*
     * Returns als Edges from or to node
     */
    private List<Edge> getPathsFrom(Node node) {
        int id = nodes.indexOf(node);
        return edges.stream()
                .filter(x -> (x.getSource() == id || x.getTarget() == id))
                .collect(Collectors.toList());
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
