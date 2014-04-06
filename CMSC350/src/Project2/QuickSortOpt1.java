/**
 * CMSC350
 * Project ?
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE?
 * NetBeans IDE 7.3
 */
package Project2;
import java.util.Arrays;
import java.util.Random;

public class QuickSortOpt1 {
	static long StartTime = System.nanoTime();
 
	private static final Random random = new Random();
 
	private static int[] randomArray(int SIZE, int MAXRNG) {
 
		// Randomize data (intArray)
		final int[] intArray = new int[SIZE];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = random.nextInt(MAXRNG);
		}
		return intArray;
	}
 
	// Sort
	private static void QuickSortOpt1(int[] intArray) {
		if (intArray.length > 0)
			sortInPlace(intArray, 0, intArray.length - 1);
 
		insertionSort(intArray, 0, intArray.length - 1);
	}
 
	private static void sortInPlace(int[] intArray, int left, int right) {
 
		// OptQSort1:
		int SIZE = right - left + 1;
		if (SIZE < 10)
			insertionSort(intArray, left, right);
 
		if (left >= right)
			return; // sorted
 
		final int range = right - left + 1;
		int pivot = random.nextInt(range) + left;
 
		int newPivot = partition(intArray, left, right, pivot);
 
		sortInPlace(intArray, left, newPivot - 1);
		sortInPlace(intArray, newPivot + 1, right);
 
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
 
	static long FinishTime = System.nanoTime();
	static long TotalTime = FinishTime - StartTime;
 
	public static void main(String[] args) {
 
            boolean SHOW = true;
            
            if (SHOW == true){
                // Array SIZE
                int SIZE = 100000;
                int MAXRNG = 999999;
                int[] intArray = randomArray(SIZE, MAXRNG);

                int[] copy = Arrays.copyOf(intArray, intArray.length);

                // Print original data (intArray)
                System.out.println("The starting unsorted intArray: \n" + Arrays.toString(intArray));
                // Performing QuickSortOpt1                
                QuickSortOpt1(intArray);

                // check the result
                Arrays.sort(copy);
                if (Arrays.equals(intArray, copy)) {
                        System.out.println("The ending sorted intArray: \n" + Arrays.toString(intArray));      
                        FinishTime = System.nanoTime();
                        TotalTime = FinishTime - StartTime;
                        System.out.println("Total elapsed time (nanoseconds) " + "is: " + TotalTime);
                                        
                }
            } 
            else if (SHOW == false){
                // Array SIZE
                int SIZE = 100000;
                int MAXRNG = 999999;
                int[] intArray = randomArray(SIZE, MAXRNG);
                int[] copy = Arrays.copyOf(intArray, intArray.length);

                // Print original data (intArray)
                System.out.println("The starting unsorted intArray: \n" + Arrays.toString(intArray));
                                
                QuickSortOpt1(intArray);

                // check the result
                Arrays.sort(copy);
                if (Arrays.equals(intArray, copy)) {
                        System.out.println("The ending sorted intArray: \n" + Arrays.toString(intArray));
                        FinishTime = System.nanoTime();
                        TotalTime = FinishTime - StartTime;
                        System.out.println("Total elapsed time (nanoseconds) " + "is: "
                                        + TotalTime);
                }
            }
	}
}
