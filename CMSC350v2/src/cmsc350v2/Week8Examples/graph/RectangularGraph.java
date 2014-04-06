package cmsc350v2.Week8Examples.graph;

import java.util.*;

class RectangularGraph extends Graph<Vertex> 
{
    private ArrayList<String> vertexNames = new ArrayList();
    private DisjointUnion<String> components = new DisjointUnion(); 
    
    public void addEdge(String leftName, String rightName)
    {
        int leftIndex = findAdd(leftName);
        int rightIndex = findAdd(rightName);
        addEdge(leftIndex, rightIndex);
        components.union(leftName, rightName);
    }

    public Set<Set<String>> connectedComponents()
    {
        return components.getEquivalenceClasses();
    }
    
    private int findAdd(String vertexName)
    {
        Vertex vertex = null;
        int index = vertexNames.indexOf(vertexName);
        if (index < 0)
        {
            addVertex(new Vertex(vertexName));
            vertexNames.add(vertexName);
            components.add(vertexName);
            index = vertexNames.size() - 1;
        }
        return index;
    }
}
