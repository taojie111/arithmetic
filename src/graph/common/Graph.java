package graph.common;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {

    public HashMap<Integer, Vertex> vertexs;
    public HashSet<Edge> edges;

    public Graph() {
        this.vertexs = new HashMap<>();
        this.edges = new HashSet<>();
    }

}
