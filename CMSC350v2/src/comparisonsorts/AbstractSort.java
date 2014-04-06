package comparisonsorts;

abstract class AbstractSort
{
    abstract public void sort(Comparable[] array);
    
    protected void swap(Comparable[] array, int i, int j)
    {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
