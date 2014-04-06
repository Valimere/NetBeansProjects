package radix;

import java.io.*;
import java.util.*;

class RadixSort
{
    private static final int BASE = 10, DIGITS = 4;

    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Integer> values = new ArrayList();
        Scanner input = new Scanner(new File("ints.txt"));
        while (input.hasNextInt())
        {
            Integer value = input.nextInt();
            values.add(value);
        }
        int[] array = new int[values.size()];
        int i = 0;
        for (int value: values)
             array[i++] = value;
        radixSort(array);
        for (int value: array)
            System.out.println(value);
    }

    private static void radixSort(int[] values)
    {
        int index, bin, length = values.length;
        int[][] bins = new int[BASE][length];
        int[] indexes = new int[BASE];

        for (int digit = 1; digit <= DIGITS; digit++)
        {
            for (int i = 0; i < BASE; i++)
                indexes[i] = 0;

            // Sort into bins according to digit
            for (int i = 0; i < length; i++)
            {
                bin = getDigit(values[i], digit);
                bins[bin][indexes[bin]++] = values[i];
            }

            // Reassemble them
            index = 0;
            for (bin = 0; bin < BASE; bin++)
                for (int i = 0; i < indexes[bin]; i++)
                    values[index++] = bins[bin][i];
        }
    }

    // Returns the digit specified counting right to left, digit 1 is the least significant
    private static int getDigit(int number, int whichDigit)
    {
        while (whichDigit-- > 1)
            number /= BASE;
        return number % BASE;
    }
}
