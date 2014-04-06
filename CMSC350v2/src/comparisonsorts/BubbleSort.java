package comparisonsorts;

class BubbleSort extends AbstractSort
{
    @Override
    public void sort(Comparable[] array)
    {
        for (int i = 0; i < array.length; i++)
            for (int j = array.length - 1; j > i; j--)
                if (array[j].compareTo(array[j - 1]) < 0)
                    swap(array, j, j - 1);
    }
    
    @Override
    public String toString()
    {
        return "Bubble Sort";
    }
}
