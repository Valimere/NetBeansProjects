package cmsc350v2.Week8Examples.graph;

import java.util.*;

class Graph<V>
{
    private List<V> vertices = new ArrayList();
    private List<List<Integer>> edges = new ArrayList();
    private boolean[] marked, onBranch;
    private boolean cycle;

    public V getVertex(int i)
    {
        return vertices.get(i);
    }

    public int getIndex(Vertex vertex)
    {
        return vertices.indexOf(vertex);
    }

    public List<V> getVertices()
    {
        return vertices;
    }

    public List<Integer> getNeighbors(int i)
    {
        return edges.get(i);
    }

    public int getSize()
    {
        return vertices.size();
    }

    public void addVertex(V vertex)
    {
        vertices.add(vertex);
        edges.add(new ArrayList());
    }

    public void addEdge(int left, int right)
    {
        edges.get(left).add(right);
        edges.get(right).add(left);
    }

    public ArrayList<V> depthFirst(int start)
    {
        ArrayList<V> list = new ArrayList();
        marked = new boolean[getSize()];
        onBranch = new boolean[getSize()];
        cycle = false;
        dfs(start, start, list);
        return list;
    }

    private void dfs(int previous, int current, ArrayList<V> list)
    {
        if (onBranch[current])
            cycle = true;
        if (marked[current])
            return;
        marked[current] = onBranch[current] = true;
        list.add(vertices.get(current));
        for (int next = 0; next < getSize(); next++)
            if (next != previous && edges.get(current).contains(next))
                dfs(current, next, list);
        onBranch[current] = false;
    }

    public ArrayList<V> breadthFirst(int start)
    {
        ArrayList<V> list = new ArrayList();
        Queue<Integer> queue = new LinkedList<Integer>();
        int current = start;
        for (int i = 0; i < getSize(); i++)
            marked[i] = false;
        queue.offer(start);
        while (!queue.isEmpty())
        {
            current = queue.remove();
            marked[current] = true;
            list.add(vertices.get(current));
            for (int next = 0; next < getSize(); next++)
                if (edges.get(current).contains(next) && !marked[next])
                    queue.offer(next);
        }
        return list;
    }

    public boolean isConnected()
    {
        depthFirst(0);
        for (boolean mark : marked)
            if (!mark)
                return false;
        return true;
    }

    boolean hasCycles()
    {
        for (int vertex = 0; vertex < getSize(); vertex++)
        {
            depthFirst(vertex);
            if (cycle)
                return true;
        }
        return false;
    }
}
