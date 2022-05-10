package graph.common;

import java.util.ArrayList;

public class Vertex {

    public int value;
    public int in;
    public int out;
    public ArrayList<Vertex> nexts;
    public ArrayList<Edge> edges;

    public Vertex(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

}
