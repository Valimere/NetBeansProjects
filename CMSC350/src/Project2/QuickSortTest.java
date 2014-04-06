/**
 * CMSC350
 * Project 2 Quick Sort Optimizations
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE 7/20/2013
 * NetBeans IDE 7.3
 */

package Project2;
import java.util.Arrays;
import java.util.Random;
public class QuickSortTest {
    static long StartTime = System.nanoTime();
    
    public static void main(String[] args) {
        // Outputting name as required for all submitted work
        System.out.println("Stephen Drollinger, CMSC350, Project2 Quick Sort Optimizations \n");

        // Choose execution case true or false
        boolean SHOW = false;

        // the first of two possible executions for this program
        if (SHOW == true){
            // Array SIZE
            int SIZE = 10000;
            int MAXRNG = 999999;
            //System.out.println("nanotime:" + System.nanoTime());
            StartTime = System.nanoTime();
            int[] intArray = randomArray(SIZE, MAXRNG);
            long TimeRandomArrayCreation = System.nanoTime() - StartTime;

            int[] copy = Arrays.copyOf(intArray, intArray.length);
            int[] randomCopy = Arrays.copyOf(intArray, intArray.length);

            //Print original data (intArray)
            System.out.println("The unsorted intArray: \n" + Arrays.toString(intArray));
            System.out.println("time to calculate the random Array " + TimeRandomArrayCreation + " (nanoseconds) with a size of " + SIZE );
            System.out.println();
            
            // Performing QuickSort 
            StartTime = System.nanoTime();
            QuickSort(intArray);
            long TimeQuickSort = System.nanoTime() - StartTime;
            // check the result
            Arrays.sort(copy);
            if (Arrays.equals(intArray, copy)) {

                // showing good data
                System.out.println("QuickSorted Array: \n" + Arrays.toString(intArray));
                System.out.println("time to calculate Quicksort in (nanoseconds) " + TimeQuickSort);
                System.out.println();
            }
            else System.out.println("QuickSort Array is not properly sorted");
            
            // repopulating intArray with random order originally generated
            intArray = randomCopy;
            
            // Performing QuickSortOpt1 
            StartTime = System.nanoTime();
            QuickSortOpt1(intArray);
            long TimeQuickSortOpt1 = System.nanoTime() - StartTime;
            // check the result
            Arrays.sort(copy);
            if (Arrays.equals(intArray, copy)) {
                System.out.println("QuickSortedOpt1 Array: \n" + Arrays.toString(intArray));      
                System.out.println("time to calculate QuicksortOpt1 in (nanoseconds) " + "is: " + TimeQuickSortOpt1);
                System.out.println();
            }
            else System.out.println("QuickSortOpt1 Array is not properly sorted");
            
            // repopulating intArray with random order originally generated
            intArray = randomCopy;
            
            StartTime = System.nanoTime();
            QuickSortOpt2(intArray);
            long TimeQuickSortOpt2 = System.nanoTime() - StartTime;
            // check the result
            Arrays.sort(copy);
            if (Arrays.equals(intArray, copy)) {
                System.out.println("QuickSortedOpt2 Array: \n" + Arrays.toString(intArray));      
                System.out.println("time to calculate QuicksortOpt2 in (nanoseconds) " + "is: " + TimeQuickSortOpt2);
                System.out.println();
            }
            else System.out.println("QuickSortOpt2 Array is not properly sorted");
        } 
        // the second of two possible executions for this program
        else if (SHOW == false){
            // Array SIZE
            int SIZE = 100000;
            int MAXRNG = 999999;
            
            long sum = 0;
            long quickSortAvg = 0;
            long quickSortAvgOpt1 = 0;
            long quickSortAvgOpt2 = 0;
            
            int[] intArray = randomArray(SIZE, MAXRNG);
            
            System.out.println("Algorithm       " + "Measured mean values of the execution time");

            // Performing QuickSort 10x
            for (int i = 0; i < 10; i++ ){
                StartTime = System.nanoTime();
                QuickSort(intArray);
                sum += System.nanoTime() - StartTime;
                
                // repopulating intArray with random numbers
                intArray = randomArray(SIZE, MAXRNG);
                //System.out.println(sum);
            }
            // computing average and printing
            quickSortAvg = sum / 10;
            System.out.println("Quicksort       " + quickSortAvg);
            sum = 0;
      
            // Performing QuickSortOpt1 10x
            for (int i = 0; i < 10; i++ ){
                StartTime = System.nanoTime();
                QuickSortOpt1(intArray);
                sum += System.nanoTime() - StartTime;

                // repopulating intArray with random numbers
                intArray = randomArray(SIZE, MAXRNG);
                //System.out.println(sum);
            }
            // computing average and printing
            quickSortAvgOpt1 = sum / 10;
            System.out.println("QuicksortOpt1   " + quickSortAvgOpt1);
            sum = 0;

            // Performing QuickSortOpt2 10x
            for (int i = 0; i < 10; i++ ){
                StartTime = System.nanoTime();
                QuickSortOpt2(intArray);
                sum += System.nanoTime() - StartTime;

                // repopulating intArray with random numbers
                intArray = randomArray(SIZE, MAXRNG);
                //System.out.println(sum);
            }
            // computing average and printing
            quickSortAvgOpt2 = sum / 10;
            System.out.println("QuicksortOpt2   " + quickSortAvgOpt2);
            sum = 0;

        }
    }

	private static final Random random = new Random();
	private static int[] randomArray(int SIZE, int MAXRNG) {
 
		// Randomize data (intArray)
		final int[] intArray = new int[SIZE];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = random.nextInt(MAXRNG);
		}
		return intArray;
	}
 	// Sorting with Quicksort
	private static void QuickSort(int[] intArray) {
            if (intArray.length > 0)
                quickSort(intArray, 0, intArray.length - 1);
	}
 
	private static void quickSort(int[] intArray, int left, int right) {
            // QSort
            if (left >= right)
                    return; // sorted

            final int range = right - left + 1;
            int pivot = random.nextInt(range) + left;

            int newPivot = partition(intArray, left, right, pivot);

            quickSort(intArray, left, newPivot - 1);
            quickSort(intArray, newPivot + 1, right);
	}
        
	// Sorting with QuicksortOpt1
	private static void QuickSortOpt1(int[] intArray) {
		if (intArray.length > 10)
                    sortInPlaceOpt1(intArray, 0, intArray.length - 1);
 
                    insertionSort(intArray, 0, intArray.length - 1);
	}
 
	private static void sortInPlaceOpt1(int[] intArray, int left, int right) {
 
		// OptQSort1:
		int SIZE = right - left + 1;
		if (SIZE <= 10)
                    insertionSort(intArray, left, right);
 
		if (left >= right)
			return; // sorted
 
		final int range = right - left + 1;
		int pivot = random.nextInt(range) + left;
 
		int newPivot = partition(intArray, left, right, pivot);
 
		sortInPlaceOpt1(intArray, left, newPivot - 1);
		sortInPlaceOpt1(intArray, newPivot + 1, right);
 
	}
        	// Sorting with QuicksortOpt2
	private static void QuickSortOpt2(int[] intArray) {
		if (intArray.length > 10)
                    sortInPlaceOpt2(intArray, 0, intArray.length - 1);
 
                    insertionSort(intArray, 0, intArray.length - 1);
	}
 
	private static void sortInPlaceOpt2(int[] intArray, int left, int right) {
 
		// OptQSort2:
		int SIZE = right - left + 1;
		if (SIZE <= 10)
                    insertionSort(intArray, left, right);
 
		if (left >= right)
			return; // sorted
 
		final int range = right - left + 1;
		int pivot = random.nextInt(range) + left;
 
		int newPivot = partitionOpt2(intArray, left, right, pivot);
 
		sortInPlaceOpt1(intArray, left, newPivot - 1);
		sortInPlaceOpt1(intArray, newPivot + 1, right);
                insertionSort(intArray, left, right);
	}
 
	private static int partition(int[] intArray, int left, int right, int pivot) {
 
		int pivotVal = intArray[pivot];
		swapArrayVals(intArray, pivot, right);
 
		int storeIndex = left;
		for (int i = left; i <= (right - 1); i++) {
			if (intArray[i] < pivotVal) {
				swapArrayVals(intArray, i, storeIndex);
				storeIndex++;
			}
		}
 
		swapArrayVals(intArray, storeIndex, right);
 
		return storeIndex;
	}
 
        // Partition 2 being 
        private static int partitionOpt2(int[] intArray, int left, int right, int pivot) {
 
		int pivotVal = intArray[pivot];
		swapArrayVals(intArray, pivot, right);
                int storeIndex = left;
                    for (int i = left; i <= (right + 9); i++) {
                            if (intArray[i] < pivotVal) {
                                    swapArrayVals(intArray, i, storeIndex);
                                    storeIndex++;
                            }else break;
                    }
                    swapArrayVals(intArray, storeIndex, right);

		return storeIndex;
	}
	private static void swapArrayVals(int[] intArray, int from, int to) {
		int fromVal = intArray[from];
		int toVal = intArray[to];
		intArray[from] = toVal;
		intArray[to] = fromVal;
	}
 
	public static void insertionSort(int[] intArray, int left, int right) {
		int in, out;
 
		for (out = left + 1; out <= right; out++) {
			int temp = intArray[out];
			in = out;
 
			while (in > left && intArray[in - 1] >= temp) {
				intArray[in] = intArray[in - 1];
				--in;
			}
			intArray[in] = temp;
		}
	}
}
