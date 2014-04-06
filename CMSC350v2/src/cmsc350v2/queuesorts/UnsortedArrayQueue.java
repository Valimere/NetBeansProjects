package queuesorts;

class UnsortedArrayQueue<E extends Comparable> implements PriorityQueue<E>
{
    private E[] queue;
    private int back = 0;
    
    public UnsortedArrayQueue(int size)
    {
        queue = (E[]) new Comparable[size];
    }
    
    @Override
    public void enqueue(E element) 
    {
        if (back == queue.length)
            throw new RuntimeException("Queue overflow");
        queue[back++] = element;
    }

    @Override
    public E dequeue() 
    {
        E maxElement = queue[0];
        int maxIndex = 0;
        
        for (int i = 1; i < back; i++)
        {
            if (queue[i].compareTo(maxElement) > 0)
            {
                maxElement = queue[i];
                maxIndex = i;
            }
        }
        queue[maxIndex] = queue[--back];
        return maxElement;
    }

    @Override
    public boolean isEmpty() 
    {
        return back == 0;
    }
    
    @Override
    public String toString()
    {
        return "Priority queue implemented with an unsorted array";
    }
}
