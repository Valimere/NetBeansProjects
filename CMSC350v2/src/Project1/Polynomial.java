/**
 * CMSC350 Project 1 Stephen Drollinger Valimere@gmail.com DATE 2 November 2013
 * NetBeans IDE 7.3
 */
package Project1;

import java.io.*;
import java.util.*;

public class Polynomial implements Comparable {

    public static ArrayList<Integer> input(String scan) {
        Scanner reScanned = new Scanner(scan);
        ArrayList<Integer> polyArray = new ArrayList();
        ArrayList<Integer> formattedPolyArray = new ArrayList();
        int count = 0;

        // zeroSeeker looks for skipped powers to have 0 input as placeholders
        int zeroSeeker = 0;

        // putting given string into an array list to work with temporarily
        while (reScanned.hasNextInt()) {
            polyArray.add(reScanned.nextInt());
        }
        System.out.println(polyArray + "Was brought into the method");
        //System.out.println(polyArray.get(1) + " zeroSeekers's count");

        zeroSeeker = polyArray.get(1);
        System.out.println(polyArray.size() + " = polyArray.size");
        for (int i = 1; i <= polyArray.size() - 1; i += 2) {
            //inputting zeros
            System.out.println("i is at position = " + i);
            System.out.println("zeroSeeker       = " + zeroSeeker);
            System.out.println("the exponent is  = " + polyArray.get(i));

            if ((polyArray.get(i) == zeroSeeker) == false) {
                System.out.println("looks like a number was skipped inserting a zero");
                zeroSeeker--;
                formattedPolyArray.add(0);
                System.out.println(" Added a 0 at posiiton " + (i - 1));
                // letting the i catch up to zer seeker
                i -= 2;
                //zeroSeeker--;
            } else {
                formattedPolyArray.add(polyArray.get(i - 1));
                System.out.println("getting " + polyArray.set(i - 1, 0) + " and placing it into formattedPoly");
                zeroSeeker--;
            }
            System.out.println("test");
            System.out.println("last statement of getting " + formattedPolyArray.get(formattedPolyArray.size() - 1));
            if ((zeroSeeker == 1) && (formattedPolyArray.get(formattedPolyArray.size() - 1) == 1) == true) {
                System.out.println("last statement of getting " + formattedPolyArray.get(formattedPolyArray.size() - 1));
                //formattedPolyArray.remove(formattedPolyArray.size()-1);
                formattedPolyArray.add(polyArray.get(i+1));

            }

        }
        System.out.println(formattedPolyArray + " = formattedPoly array");
        System.out.println();
        return formattedPolyArray;
    }

    public static String toString(ArrayList<Integer> givenPoly) {
        String formattedPoly = new String();
        List<Integer> uPollyIntList = new ArrayList<>();
        int countA = 0;
        int countB = 1;
        int countExponent = givenPoly.get(1);
        int givenPolySize = givenPoly.size();
        int count = givenPoly.size() - 1;

        //System.out.println("testing after sending arraylist to toString from inside method");
        System.out.println("givenPolySize = " + givenPolySize);
        //concatenating the List of integers with appropriate formatting
        while (countB >= 0) {
            // formatting for polynomials with an exponent of 0
            if (countExponent == 0) {
                formattedPoly += " " + givenPoly.get(countA);
                countA++;
                countB++;
            } // formatting for polynomials with an exponent of 1
            else if (countExponent == 1) {
                formattedPoly = formattedPoly + " " + givenPoly.get(countA) + "X";
                countA++;
                countA++;
                countB++;
                countB++;
            }// formatting for regular polynomials
            else if (countExponent > 1) {
                formattedPoly += givenPoly.get(countA) + "X^" + givenPoly.get(countB) + " +";
                countA++;
                countA++;
                countB++;
                countB++;
            }
            count -= 2;
            //count--;
            System.out.println("count = " + count);
        }

        return formattedPoly;
    }

    //@Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
