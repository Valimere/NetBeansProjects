/**
 * CMSC350
 * Project ?
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE?
 * NetBeans IDE 7.3
 */
package Project2;
import java.util.*;
public class QuickSort {
static long StartTime = System.nanoTime();
 
	private static final Random random = new Random();
	private static final int RANDOM_INT_RANGE = 9999;
 
	private static int[] randomArray(int SIZE) {
 
		// Randomize data (intArray)
		final int[] intArray = new int[SIZE];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = random.nextInt(RANDOM_INT_RANGE);
		}
		return intArray;
	}
 
	// Sorting with Quicksort
	private static void sort(int[] intArray) {
		if (intArray.length > 0)
			sortInPlace(intArray, 0, intArray.length - 1);
	}
 
	private static void sortInPlace(int[] intArray, int left, int right) {
 
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
 
	static long FinishTime = System.nanoTime();
	static long TotalTime = FinishTime - StartTime;
 
	private static void swapArrayVals(int[] intArray, int from, int to) {
		int fromVal = intArray[from];
		int toVal = intArray[to];
		intArray[from] = toVal;
		intArray[to] = fromVal;
	}
 
	public static void main(String[] args) {
 
		// Array SIZE
		int[] intArray = randomArray(1000);
		int[] copy = Arrays.copyOf(intArray, intArray.length);
 
		// Print original data (intArray)
		System.out.println("The starting unsorted intArray: \n"
				+ Arrays.toString(intArray));
 
		sort(intArray);
 
		// check the result
		Arrays.sort(copy);
		if (Arrays.equals(intArray, copy)) {
			System.out.println("The ending sorted intArray: \n"
					+ Arrays.toString(intArray));
			System.out.println("Total elapsed time (nanoseconds) " + "is: "
					+ TotalTime);
 
		}
 
	}
}
