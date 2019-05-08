import com.google.gson.Gson;
import struct.Graph;
import struct.Node;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
            Graph g = gson.fromJson(new FileReader("generatedGraph.json"), Graph.class);
            Node earth = g.getNodes().get(18);
            Node b3r7r4nd7 = g.getNodes().get(246);

            List<Node> result = g.findShortestPath(earth, b3r7r4nd7);

            System.out.println("Path:");
            System.out.println(result.stream().map(Node::getLabel).collect(Collectors.joining(" -> ")));
            System.out.println();
            System.out.println("Total cost: ");
            System.out.println(result.get(result.size()-1).getDistanceFromSource());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
