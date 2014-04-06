package comparisonsorts;

class MergeSort extends AbstractSort
{
    @Override
    public void sort(Comparable[] array)
    {
        mergeSort(array, 0, array.length - 1);
    }
    
    public void mergeSort(Comparable[] array, int left, int right)
    {
        if (left < right)
        {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            Comparable[] merged = merge(array, left, middle, right);
            int j = 0;
            for (int i = left; i <= right; i++)
                array[i] = merged[j++];
        }
    }

    private Comparable[] merge(Comparable[] array, int left, int middle, int right)
    {
        Comparable[] merged = new Comparable[right - left + 1];
        int first = left, second = middle + 1, merge = 0;
        while (first <= middle && second <= right)
            if (array[first].compareTo(array[second]) < 0)
                merged[merge++] = array[first++];
            else
                merged[merge++] = array[second++];
        while (first <= middle)
            merged[merge++] = array[first++];
        while (second <= right)
            merged[merge++] = array[second++];
        return merged;
    }

    @Override
    public String toString()
    {
        return "Merge Sort";
    }
}

