package comparisonsorts;

class QuickSort extends AbstractSort
{
    @Override
    public void sort(Comparable[] array)
    {
        quickSort(array, 0, array.length - 1);
    }
    
    public void quickSort(Comparable[] array, int left, int right)
    {
        if (left < right)
        {
            int pivot = findPivot(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private int findPivot(Comparable[] array, int left, int right)
    {
        int first = left++;
        while (left <= right)
        {
            while (left <= right && array[first].compareTo(array[left]) > 0)
                left++;
            while (left <= right && array[first].compareTo(array[right]) < 0)
                right--;
            if (left < right)
                swap(array, left++, right--);
        }
        swap(array, first, right);
        return right;
    }
    
    @Override
    public String toString()
    {
        return "Quick Sort";
    }
}
