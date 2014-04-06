package queuesorts;

class SortedArrayQueue<E extends Comparable> implements PriorityQueue<E>
{
    private E[] queue;
    private int back = 0;
    
    public SortedArrayQueue(int size)
    {
        queue = (E[]) new Comparable[size];
    }
    
    @Override
    public void enqueue(E element) 
    {
        if (back == queue.length)
            throw new RuntimeException("Queue overflow");
        int i = back - 1;
        while (i >= 0 && element.compareTo(queue[i]) < 0)
        {
            queue[i + 1] = queue[i];
            i--;
        }
        queue[i + 1] = element;
        back++;   
    }

    @Override
    public E dequeue() 
    {
        return queue[--back];
    }

    @Override
    public boolean isEmpty() 
    {
        return back == 0;
    }
    
    @Override
    public String toString()
    {
        return "Priority queue implemented with a sorted array";
    }
}
