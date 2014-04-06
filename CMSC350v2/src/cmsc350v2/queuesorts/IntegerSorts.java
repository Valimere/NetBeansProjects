package queuesorts;

import java.io.*;
import java.util.*;

class IntegerSorts 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Integer> values = new ArrayList();
        Scanner input = new Scanner(new File("ints.txt"));
        while (input.hasNextInt())
        {
            Integer value = input.nextInt();
            values.add(value);
        }
        PriorityQueue[] queues = {new SortedArrayQueue(values.size()),
            new UnsortedArrayQueue(values.size()), new HeapQueue(values.size())};
        for (PriorityQueue queue: queues)
            sortAndDisplay(values, queue);
    }
    private static void sortAndDisplay(ArrayList<Integer> values, PriorityQueue<Integer> queue)
    {
        System.out.println("\n" + queue + "\n");
        for (Integer value: values)
            queue.enqueue(value);
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }
}
