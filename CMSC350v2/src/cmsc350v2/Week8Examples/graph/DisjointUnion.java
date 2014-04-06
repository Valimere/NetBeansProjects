package cmsc350v2.Week8Examples.graph;

import java.util.*;

public class DisjointUnion<E> 
{
    private Map<E, Set<E>> disjointUnion = new HashMap();

    public boolean add(E element)
    {
        if (disjointUnion.containsKey(element))
            return false;
        Set<E> singleton = new HashSet();
        singleton.add(element);
        disjointUnion.put(element, singleton);
        return true;
    }
    public boolean union(E element1, E element2)
    {
        if (!disjointUnion.containsKey(element1) || !disjointUnion.containsKey(element2))
            return false;
        Set<E> set1 = disjointUnion.get(element1), set2 = disjointUnion.get(element2);
        set1.addAll(set2);
        for (E element: set1)
            disjointUnion.put(element, set1);
        return true;
    }
    public Set<E> find(E element)
    {
        return disjointUnion.get(element);
    }
    
    public Set<Set<E>> getEquivalenceClasses()
    {
        Set<Set<E>> classes = new HashSet();
        
        Set<E> keys = disjointUnion.keySet();
        for (E key: keys)
            classes.add(disjointUnion.get(key));
        return classes;
    }
}
