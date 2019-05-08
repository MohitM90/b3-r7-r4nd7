package struct;

public class Node implements Comparable<Node> {
    private String label;

    private transient double distanceFromSource;
    private transient Node bestNeighbor;

    public Node() {
        this.distanceFromSource = Double.MAX_VALUE;
    }


    public String getLabel() {
        return label;
    }

    public double getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(double distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }

    public Node getBestNeighbor() {
        return bestNeighbor;
    }

    public void setBestNeighbor(Node bestNeighbor) {
        this.bestNeighbor = bestNeighbor;
    }


    @Override
    public int compareTo(Node o) {
        return Double.compare(this.getDistanceFromSource(), o.getDistanceFromSource());
    }
}
