package queuesorts;

interface PriorityQueue<E extends Comparable>
{
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
