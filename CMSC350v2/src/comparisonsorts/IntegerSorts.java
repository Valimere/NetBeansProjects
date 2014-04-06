package comparisonsorts;

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
        AbstractSort[] sorts = {new BubbleSort(), new EfficientBubbleSort(),
            new MergeSort(), new QuickSort()};
        for (AbstractSort sort: sorts)
            sortAndDisplay(values, sort);
    }
    private static void sortAndDisplay(ArrayList<Integer> values, AbstractSort sort)
    {
        System.out.println("\n" + sort + "\n");
        Integer[] array = new Integer[values.size()];
        values.toArray(array);
        sort.sort(array);
        for (Integer value: array)
            System.out.println(value);
    }
}
