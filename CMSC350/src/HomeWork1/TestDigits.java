/* CMSC350
 * Homework 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * 30 June 2013
 * NetBeans IDE 7.3
 */
package HomeWork1;
import java.util.Scanner;

public class TestDigits {
        public static void main(String[] args)
	{    
            // Outputting name as required for all submitted work
            System.out.println("Stephen Drollinger, CMSC350, HW1 TestDigits");

            System.out.print("Plese input your Integer:"); //asking for users input
            Scanner scanned = new Scanner(System.in); 
            if (scanned.hasNextInt() == true) //checking if input is an Integer
            {
                int integer = scanned.nextInt(); // assigning integer the int value of the scanner
                System.out.println("Your int is " + integer);
                int digitCount = 1;
                int nmbOfDigits = nmbDigits(integer, digitCount);
                System.out.println("The number of digits you entered is: " + nmbOfDigits);
            }
            else //asking for user to input correct input
                System.out.print("A non integer was detected, plese run again and input an Integer:");    
        }
        private static int nmbDigits(int integer, int digitCount) // Calculating number of digits
        {
            //If there are less than 2 digits
            if (integer < 10)
                return digitCount++;
            //recursively dividing by 10 until there are less than 2 digits, and counting number of calls
            else
                integer = integer/10;
                System.out.println("Your int is " + integer + " after dividing by 10");
                digitCount++;
                //System.out.println("actual digit count = " + digitCount);
                return nmbDigits(integer, digitCount++);
        }
}