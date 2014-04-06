/**
 * CMSC350 Project 1 Stephen Drollinger Valimere@gmail.com DATE 2 November 2013
 * NetBeans IDE 7.3
 */
package Project1;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Project1 {

    public static void main(String[] args) throws FileNotFoundException, FileUnsorted {
        // Outputting name 
        System.out.println("Stephen Drollinger, CMSC350, Project1 PolynomialMerge");

        ArrayList<ArrayList<Integer>> file1List = new ArrayList();
        ArrayList<ArrayList<Integer>> file2List = new ArrayList();

        try {

            //change filepath to point at the Polynomial files
            File f1 = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350v2\\src\\Project1\\file1.txt");
            File f2 = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350v2\\src\\Project1\\file2.txt");

            //Setting up new scanners so there's no question if they are reset
            Scanner scan1 = new Scanner(f1);
            Scanner scan2 = new Scanner(f2);
            Scanner scan3 = new Scanner(f1);
            Scanner scan4 = new Scanner(f2);

            // sends the scanned line to input to be converted to an ArrayList<Integer> and added to ArrayList
            while (scan1.hasNextLine() == true) {
                //System.out.println("Passing Line:" + (Polynomial.input(scan1.nextLine()));
                file1List.add(Polynomial.input(scan1.nextLine()));
            }
            System.out.println("The first file contains: ");
            System.out.println(file1List);
            System.out.println();

            while (scan2.hasNextLine() == true) {
                //System.out.println("Passing Line:" + (Polynomial.input(scan2.nextLine()));
                file2List.add(Polynomial.input(scan2.nextLine()));
            }
            System.out.println("The second file contains: ");
            System.out.println(file2List);
            System.out.println();

            //sending file lists to checkSorted method to check if they are in sorted order.
            if (checkSorted(file1List) == true) {
                System.out.println("File 1 is sorted: ");
                System.out.println();

                if (checkSorted(file2List) == true) {
                    System.out.println("File 2 is sorted: ");
                } else {
                    throw new FileNotFoundException();
                }
                System.out.println();
            } else {
                throw new FileNotFoundException();
            }

            for (int i = 0; i <= file1List.size(); i++) {
                System.out.println("inside outer loop");
                //ArrayList tempArray = new ArrayList();
                //tempArray.add(file1List.get(i));
                System.out.println("output before conversion = " + file1List.get(i));
                System.out.println("output after conversion  = " + Polynomial.toString(file1List.get(i)));
                System.out.println("testing after sending arraylist to toString");
            }

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage() + " File not found message");
        }
    }

    //checking if given polynomial arraylist exponents are in descending order
    public static boolean checkSorted(List<ArrayList<Integer>> givenFileList) throws FileUnsorted {

        int countA = 0;
        int countB = 1;

        for (int i = givenFileList.size()-1; i > 0; i--) {
            System.out.println("testing 1");
            int arrayOne = 0;
            int arrayTwo = 0;
            System.out.println(givenFileList.get(countA).size());
            for (int x = 0; x <= givenFileList.get(countA).size()-1; x++) {
                arrayOne = arrayOne*10 + givenFileList.get(countA).get(x);
            }
            for (int x = 0; x <= givenFileList.get(countB).size()-1; x++) {
                arrayTwo = arrayTwo*10 + givenFileList.get(countB).get(x);
            }
            System.out.println(arrayOne);
            System.out.println(arrayTwo);
            if ((arrayOne - arrayTwo) > 0){
                System.out.println(" arrayOne - arrayTwo = " + (arrayOne - arrayTwo));
                throw new FileUnsorted();
            }
            countA++;
            countB++;
        }

       
        //iterating count for outer loop
        //count++;
        return true;
    }
}
