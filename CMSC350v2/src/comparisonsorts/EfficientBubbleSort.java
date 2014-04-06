package comparisonsorts;

class EfficientBubbleSort extends AbstractSort
{
    @Override
    public void sort(Comparable[] array)
    {
        int i = 0;
        boolean sorted = false;
        while (i < array.length && !sorted)
        {
            sorted = true;
            for (int j = array.length - 1; j > i; j--)
                if (array[j].compareTo(array[j - 1]) < 0)
                {
                    swap(array, j, j - 1);
                    sorted = false;
                }
            i++;
        }
    }
    
    @Override
    public String toString()
    {
        return "Efficient Bubble Sort";
    }
}
