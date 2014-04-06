/*
 * CMSC350 Project 2 Stephen Drollinger Valimere@gmail.com DATE 11 December 2013
 * NetBeans IDE 7.4
 */

package Project2;

import java.util.Arrays;
import java.util.Random;

public class Project2 {
    static long StartTime = System.nanoTime();
    
    public static void main(String[] args) {
        // Outputting name as required for all submitted work
        System.out.println("Stephen Drollinger, CMSC350, Project2 Quick Sort Optimizations \n");
        
        /*
        * Choose execution case true or false, true shows inner workings of 1x, 
        * false shows summary of program run at 50x for each and displays the average. 
        */
        boolean SHOW = false;
        // the first of two possible executions for this program
        if (SHOW == true){
            // Array SIZE
            int SIZE = 10000;
            int MAXRNG = 99999;
            //System.out.println("nanotime:" + System.nanoTime());
            StartTime = System.nanoTime();
            int [] intArray = randomArray(SIZE, MAXRNG);
            long TimeRandomArrayCreation = System.nanoTime() - StartTime;

            int [] copy = Arrays.copyOf(intArray, intArray.length);
            int [] randomCopy = Arrays.copyOf(intArray, intArray.length);

            //Print original data (intArray)
            System.out.println("The unsorted intArray: \n" + Arrays.toString(intArray));
            System.out.println("time to calculate the random Array " + TimeRandomArrayCreation + " (nanoseconds) with a size of " + SIZE );
            System.out.println();
            
            // Performing QuickSort 
            StartTime = System.nanoTime();
            QuickSort.quickSort(intArray);
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
            
            // Performing InsertionSort 
            StartTime = System.nanoTime();
            InsertionSort.insertionSort(intArray);
            long TimeInsertionSort = System.nanoTime() - StartTime;
            // check the result
            Arrays.sort(copy);
            if (Arrays.equals(intArray, copy)) {
                System.out.println("QuickSortedOpt1 Array: \n" + Arrays.toString(intArray));      
                System.out.println("time to calculate InsertionSort in (nanoseconds) " + "is: " + TimeInsertionSort);
                System.out.println();
            }
            else System.out.println("InsertionSort Array is not properly sorted");
            
            // repopulating intArray with random order originally generated
            intArray = randomCopy;
            
            StartTime = System.nanoTime();
            BubbleSort.bubbleSort(intArray);
            long TimeBubbleSort = System.nanoTime() - StartTime;
            // check the result
            Arrays.sort(copy);
            if (Arrays.equals(intArray, copy)) {
                System.out.println("QuickSortedOpt2 Array: \n" + Arrays.toString(intArray));      
                System.out.println("time to calculate BubbleSort in (nanoseconds) " + "is: " + TimeBubbleSort);
                System.out.println();
            }
            else System.out.println("BubbleSort Array is not properly sorted");
        }
        
        // the second of two possible executions for this program if false is selected it displays only the essential information
        else if (SHOW == false){
            // Array SIZE
            int SIZE = 10000;
            int MAXRNG = 99999;
            
            long sum = 0;
            long quickSortAvg = 0;
            long computeInsertionSortTime = 0;
            long computeBubbleSortTime = 0;
            
            int [] intArray = randomArray(SIZE, MAXRNG);
            
            System.out.println("Algorithm       " + "Measured mean values of the execution time in nanoseconds = 1/1,000,000,000 of a second");

            // Performing QuickSort 50x
            for (int i = 0; i < 50; i++ ){
                StartTime = System.nanoTime();
                QuickSort.quickSort(intArray);
                sum += System.nanoTime() - StartTime;
                
                // repopulating intArray with random numbers
                intArray = randomArray(SIZE, MAXRNG);
                //System.out.println(sum);
            }
            // computing average and printing
            quickSortAvg = sum / 50;
            System.out.println("Quicksort       " + quickSortAvg);
            sum = 0;
      
            // Performing InsertionSort 10x
            for (int i = 0; i < 50; i++ ){
                StartTime = System.nanoTime();
                InsertionSort.insertionSort(intArray);
                sum += System.nanoTime() - StartTime;

                // repopulating intArray with random numbers
                intArray = randomArray(SIZE, MAXRNG);
                //System.out.println(sum);
            }
            // computing average and printing
            computeInsertionSortTime = sum / 50;
            System.out.println("InsertionSort   " + computeInsertionSortTime);
            sum = 0;

            // Performing BubbleSort 50x
            for (int i = 0; i < 50; i++ ){
                StartTime = System.nanoTime();
                BubbleSort.bubbleSort(intArray);
                sum += System.nanoTime() - StartTime;

                // repopulating intArray with random numbers
                intArray = randomArray(SIZE, MAXRNG);
                //System.out.println(sum);
            }
            // computing average and printing
            computeBubbleSortTime = sum / 50;
            System.out.println("BubbleSort      " + computeBubbleSortTime);
            sum = 0;

        }
    }
    	private static final Random random = new Random();
	private static int [] randomArray(int SIZE, int MAXRNG) {
 
		// Randomize data (intArray)
		final int [] intArray = new int[SIZE];
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = random.nextInt(MAXRNG);
		}
		return intArray;
	}
}
