/*
 * CMSC350 Project 4 Stephen Drollinger Valimere@gmail.com DATE 15 December 2013
 * NetBeans IDE 7.4
 */
package Project4;

import java.util.*;
import javax.swing.JFrame;

public class BipartiteGraph<V> extends Project4.AbstractGraph<V> {

    // Construct an empty graph
    public BipartiteGraph() {
    }

    // Construct a graph from edges and vertices stored in a Arrays
    public BipartiteGraph(int[][] edges, V[] vertices) {
        super(edges, vertices);
    }

    // Construct a graph from edges and vertices stored in List 
    public BipartiteGraph(List<Edge> edges, List<V> vertices) {
        super(edges, vertices);
    }

    // Construct a graph for integer vertices 0, 1, 2 and edge list 
    public BipartiteGraph(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    // Construct a graph from integer vertices 0, 1, and edge array
    public BipartiteGraph(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

}
