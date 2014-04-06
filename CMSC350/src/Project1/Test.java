/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * CMSC350
 * Project ?
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE?
 * NetBeans IDE 7.3
 */
public class Test {
public static void main(String[] args) throws FileNotFoundException
	{    
            int fileLineCount = 0;
            // Outputting name as required for all submitted work
            System.out.println("Stephen Drollinger, CMSC350, Project1 PolynomialProcessing");
            // Creating arraylist of the names of each user named polynomial
            List<String> pollyNameList = new ArrayList<>();
            List<Integer> pollyIntList = new ArrayList<>();

            try { 
                File f = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\Project1\\values.txt");
                Scanner scan = new Scanner(f);
                
                // Creating Hashmap of input file
                Map<String, List <Integer>> hashMap = new HashMap<>();
                {
                    while (scan.hasNextLine() == true)
                    {
                        String name = scan.next();
                        // Scanning for and adding first token into the array list
                        pollyNameList.add(name);
                        System.out.println("Name of Line: " + name);
                        scan.skip(" = ");
                        while (scan.hasNextInt())
                        {
                        pollyIntList.add(scan.nextInt());
                        }
                        hashMap.put(name, pollyIntList);
                        //pollyIntList.
                        fileLineCount++;

                        System.out.println("Printing pollyIntList: " + hashMap.entrySet());
                    }
                    
                        //hashMap.put(pollyNameList, pollyIntList);
                        System.out.println("Printing next after loop: " + pollyIntList);
                        System.out.println("Printing Hash Map: " + hashMap);
                    
                    System.out.println("There are " + fileLineCount + " lines in the file with the names: " + pollyNameList);
                    for (int i = 0; i<=fileLineCount+1; i++)
                    {

                        String arrayName = String.valueOf(fileLineCount);

                        System.out.println("Printing Array: " + pollyNameList);
                        System.out.println("Printing Array Name: " + arrayName);
                        //
                        fileLineCount--;
                    }
                }
             //meanIter(intArry);
             //meanRec(intArry, s);
            } catch (FileNotFoundException fnf) 
            {
            System.out.println(fnf.getMessage());
            }
        }
}

