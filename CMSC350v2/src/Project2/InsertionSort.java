/*
 * CMSC350 Project 2 Stephen Drollinger Valimere@gmail.com DATE 11 December 2013
 * NetBeans IDE 7.4
 */

package Project2;

public class InsertionSort implements IntSort {

  /** The method for sorting the numbers */
  public static void insertionSort (int [] list) {
    for (int i = 1; i < list.length; i++) {
      /** insert list[i] into a sorted sublist list[0..i-1] so that
           list[0..i] is sorted. */
      int currentElement = list[i];
      int k;
      for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
        list[k + 1] = list[k];
      }

      // Insert the current element into list[k+1]
      list[k + 1] = currentElement;
    }
  }

    @Override
    public void sort(int[] array, int first, int last) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


