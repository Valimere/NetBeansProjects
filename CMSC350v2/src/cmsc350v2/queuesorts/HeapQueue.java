package queuesorts;

class HeapQueue<E extends Comparable> implements PriorityQueue<E>
{
    private E[] queue;
    private int length = 1;
    
    public HeapQueue(int size)
    {
        queue = (E[]) new Comparable[size + 1];
    }
    
    @Override
	public void enqueue(E element)
	{
		if (length == queue.length)
            throw new RuntimeException("Queue overflow");
		int node = length++;
		while (node > 1 && queue[node / 2].compareTo(element) < 0)
		{
			queue[node] = queue[node / 2];
			node /= 2;
		}
		queue[node] = element;
	}
	
    @Override
    public E dequeue()
	{
		int node = 1;
		E value = queue[--length];
		E maxValue = queue[node]; 
		node *= 2; 
		while (node <= length)
		{
			if (node < length && queue[node].compareTo(queue[node + 1]) < 0)
				node++;
			if (value.compareTo(queue[node]) >= 0)
				break; 
			queue[node / 2] = queue[node]; node *= 2;
		}
		queue[node / 2] = value;
		return maxValue;
	}
    
    @Override
    public boolean isEmpty() 
    {
        return length == 1;
    }
    
    @Override
    public String toString()
    {
        return "Priority queue implemented with a heap";
    }
}
