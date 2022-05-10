package util;

import graph.common.Edge;
import graph.common.Graph;
import graph.common.Vertex;

/**
 * @author taojie
 */
public class GraphUtil {

    public static Graph createGraph(Integer[][] martrix) {
        Graph graph = new Graph();
        for (int i = 0; i < martrix.length; i++) {
            Integer from = martrix[i][0];
            Integer to = martrix[i][1];
            Integer weight = martrix[i][2];
            if (!graph.vertexs.containsKey(from)) {
                graph.vertexs.put(from, new Vertex(from));
            }
            if (!graph.vertexs.containsKey(to)) {
                graph.vertexs.put(to, new Vertex(to));
            }
            Vertex fromVertex = graph.vertexs.get(from);
            Vertex toVertex = graph.vertexs.get(to);
            Edge newEdge = new Edge(weight,fromVertex,toVertex);
            fromVertex.nexts.add(toVertex);
            fromVertex.out++;
            toVertex.in++;
            fromVertex.edges.add(newEdge);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
