/* CMSC350
 * Homework 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * 30 June 2013
 * NetBeans IDE 7.3
 */
package HomeWork1;
import java.io.*;
import java.util.Scanner;

public class TestMeanVal 
{
    //public TestMeanVal(){}

        public static void main(String[] args) throws FileNotFoundException
	{    
            // Outputting name as required for all submitted work
            System.out.println("Stephen Drollinger, CMSC350, HW1 TestMeanVal");          
            try { //reading file in and putting it into an array
                File f = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\HomeWork1\\values.txt");
                Scanner scan = new Scanner(f);
                int[] intArry = new int[20];
                int i = 0;
                int s = 19;

                while (scan.hasNextInt()) 
                {
                    intArry[i] = scan.nextInt();
                    System.out.println("Printing Array of Integers: " + intArry[i]);
                    i++;
                }
             meanIter(intArry);
             meanRec(intArry, s);
            } catch (FileNotFoundException fnf) 
            {
            System.out.println(fnf.getMessage());
            }
        }
        private static double meanIter(int[] intArry) // Calculating the mean using Iterations
        {
            System.out.println("beginning of meanIter");
            int sum = 0;
            int listSize = 0;
            double mean = 0.0;
            for (int i = 0; i<=19; i++)
            {
            //System.out.println(intArry[i]);
            // Adding all integers in the Array
            sum += intArry[i];
            // finding out the size of passed array
            listSize++;
            //System.out.println(sum);
            }
            //printing the sum of the array
            System.out.println("Using meanIter the sum is: " + sum);
            //Calculating Mean and printing the mean
            mean = (sum/listSize);
            System.out.println("The calculated mean using Iteration is: " + mean);
            return mean;
        }
        private static double meanRec(int[] intArry, int s) // Calculating the mean using Recursion
        {
            //System.out.println("beginning of meanRec");
            System.out.println(s);
            int sum = 0;
            int count = 0;
            double mean = 0.0;

            while(s >= 1)
            {
                System.out.println(intArry[s]);
                mean = ((mean*count)+intArry[s])/(count+1);
                s--;
            }
            System.out.println(mean);
            return mean;
            /* 
            if (s <= 1)
            {
                System.out.println("if statement sum" + sum);
                return s;
            }
            else
                sum += intArry[s];
                s--;
                System.out.println(sum);
                return meanRec(intArry, s);
             */
        }
}
