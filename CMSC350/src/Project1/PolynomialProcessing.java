/**
 * CMSC350
 * Project 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE 7/7/2013
 * NetBeans IDE 7.3
 */

package Project1;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class PolynomialProcessing {
public static void main(String[] args) throws FileNotFoundException
	{    
            int fileLineCount = 0;
            // Outputting name as required for all submitted work
            System.out.println("Stephen Drollinger, CMSC350, Project1 PolynomialProcessing");

            // Creating arraylist of the names of each user named polynomial
            List<String> pollyNameList = new ArrayList<>();
            try { 
                File f = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\Project1\\values.txt");
                Scanner scan = new Scanner(f);
                
                
                
                // Creating Hashmap of input file
                Map<String, List <Integer>> hashMap = new HashMap<>();
                {
                    while (scan.hasNextLine() == true)
                    {   // creating list of integers to be put 0as polynomial values for each name
                        List<Integer> pollyIntList = new ArrayList<>();
                        pollyIntList.clear();
                        String name = scan.next();
                        // Scanning for and adding first token into the array list
                        pollyNameList.add(name);
                        //System.out.println("Name of Line: " + name);
                        scan.skip(" = ");
                        while (scan.hasNextInt())
                        {
                            pollyIntList.add(scan.nextInt());
                        }
                        hashMap.put(name, pollyIntList);
                        fileLineCount++;
                    }
                    //System.out.println("Printing Hash Map: " + hashMap);
                    //System.out.println("There are " + fileLineCount + " lines in the file with the names: " + pollyNameList);
                    for (int i = 0; i<=fileLineCount+1; i++)
                    {
                        String arrayName = String.valueOf(fileLineCount);
                        fileLineCount--;
                    }
                }

            // Asking for user for first polynomial
            System.out.println("Polynomials names read in to chose from = " + pollyNameList);
            
            String fScanP = "a";
            //System.out.println("fScanP1 = " + fScanP);
            System.out.println("Please enter the first polynomial operand: ");
            Scanner firstScanP = new Scanner(System.in);
            fScanP = firstScanP.nextLine();

            //System.out.println("fScanP = " + fScanP);
            while (pollyNameList.contains(fScanP) == false)
            {
                System.out.println(fScanP);
                System.out.println("An incorrect Polynomial name was detected");
                System.out.println("Please make your seleciton from" + pollyNameList);
                System.out.println("Please enter the first polynomial operand: ");
                fScanP = firstScanP.nextLine();
            }

            // Asking for user for second polynomial
            String sScanP = "b";
            System.out.println("Please enter the second polynomial operand: ");
            Scanner secondScanP = new Scanner(System.in);
            sScanP = secondScanP.nextLine();

            //System.out.println("sScanP = " + sScanP);
            while (pollyNameList.contains(sScanP) == false)
            {
                System.out.println(sScanP);
                System.out.println("An incorrect Polynomial name was detected");
                System.out.println("Please make your seleciton from" + pollyNameList);
                System.out.println("Please enter the second polynomial operand: ");
                sScanP = secondScanP.nextLine();
            }

            // Asking user for + or - opration to be performed
            String oScan= "*";
            System.out.println("Please enter the operation: ");
            Scanner operationScan = new Scanner(System.in);
            oScan = operationScan.nextLine();
            while ((oScan.equals("+") || oScan.equals("-")) == false)
            {
                System.out.println("An incorrect operation name was detected");
                System.out.println("Please enter + or -");
                System.out.println("Please enter the operation: ");
                oScan = operationScan.nextLine();
            }
            // Asking user for name of third polynomial
            String userSpecifiedP = "Poly";
            //System.out.println("userSpecifiedP = " + userSpecifiedP);
            System.out.println("Please enter the name of the new polynomial: ");
            Scanner uSpecifiedPScan = new Scanner(System.in);
            userSpecifiedP = uSpecifiedPScan.nextLine();
            //System.out.println("userSpecifiedP = " + userSpecifiedP);
            pollyNameList.add(userSpecifiedP);
            System.out.println("Updated list" + pollyNameList);
                
                //Initalizing arrays to do computations on
                List<Integer> fPollyIntList = new ArrayList<>();
                List<Integer> sPollyIntList = new ArrayList<>();
                List<Integer> uPollyIntList = new ArrayList<>();
                //Assigning hash map'd arrays to temp arrays for math manipulation 
                fPollyIntList = hashMap.get(fScanP);
                sPollyIntList = hashMap.get(sScanP);
                // Initalizing variables for adding or subtracting the polynomials
                int expA = 0;
                int expB = 0;
                int coEffA = 0;
                int coEffB = 0;
                //computing legth of longest array to know how many iterations of adding and subtracting to do
                int sizeArrayA = fPollyIntList.size();
                int sizeArrayB = sPollyIntList.size();
                int biggerArray = 0;
                if (sizeArrayA >= sizeArrayB)
                    biggerArray = sizeArrayA;
                else biggerArray = sizeArrayB;

                // displaying what math is going to be done
                System.out.println(fScanP + " " + oScan + " " + sScanP + " was selected");
                System.out.println("Executing the operation ...");
                System.out.println("Polynomial 1   " + hashMap.get(fScanP));
                System.out.println("Polynomial 2 " + oScan + " " + hashMap.get(sScanP));
                
                //creating counters to iterate throught the two arrays
                int a = 0;
                int b = 0;
            //computing + operation    
            if (oScan.equals("+"))
            {
                //System.out.println("biggerArray = " + biggerArray);
                while (biggerArray >= 0)
                {
                    //System.out.println("biggerArray = " + biggerArray);
                    expA = fPollyIntList.get(a);
                    //System.out.println("expA = " + expA);
                    expB = sPollyIntList.get(b);
                    //System.out.println("expB = " + expB);
                    a++;
                    coEffA = fPollyIntList.get(a);
                    //System.out.println("coEffA = " + coEffA);
                    b++;
                    coEffB = sPollyIntList.get(b);
                    //System.out.println("coEffB = " + coEffB);

                    // If expnonents are equal, adding the two coefficients and assaigning to list
                    if (expA == expB)
                    {
                        //System.out.println("Exponents are equal adding the two coefficients");
                        uPollyIntList.add((expA + expB) / 2);
                        uPollyIntList.add(coEffA + coEffB);
                        a++;
                        b++;
                        //System.out.println("Computed Polynomial so far = " + uPollyIntList);
                    }
                    // If exponent A is greater copying exponent A and coefficient A to the list
                    else if (expA > expB)
                    {
                        //System.out.println("Exponent A > Exponent B");
                        while (expA > expB)
                        {
                            //System.out.println("Appending the greater exponent's ExponentA " + expA + " CoEffA " + coEffA);
                            uPollyIntList.add(expA);
                            uPollyIntList.add(coEffA);
                            //System.out.println("Computed Polynomial so far = " + uPollyIntList);
                            a++;
                            expA = fPollyIntList.get(a);
                            a++;
                            coEffA = fPollyIntList.get(a);

                            //counteracting above while's increments
                            a--;
                            b--;
                        }
                    }
                    // If exponent B is greater copying exponent B and coefficient B to the list
                    else if (expB > expA)
                    {
                        //System.out.println("Exponent B > Exponent A");
                        while (expB > expA)
                        {
                            //System.out.println("Appending the greater exponent's ExponentB " + expB + " CoEfficientB " + coEffB);
                            uPollyIntList.add(expB);
                            uPollyIntList.add(coEffB);
                            //System.out.println("Computed Polynomial so far = " + uPollyIntList);
                            //System.out.println("b = " + b);
                            b++;
                            expB = sPollyIntList.get(b);
                            b++;
                            coEffB = sPollyIntList.get(b);

                            //counteracting above while's increments
                            a--;
                            b--;
                        }
                    }
                    else 
                        break;
                    // Decrementing while loop twice for the increments by 2
                    biggerArray--;
                    biggerArray--;
                }//closing while loop
            }//closing if +
            //System.out.println("END of + if");
            //computing - operation 
            if (oScan.equals("-"))
            {
                while (biggerArray >= 0 )
                {
                    expA = fPollyIntList.get(a);
                    //System.out.println("expA = " + expA);
                    expB = sPollyIntList.get(b);
                    //System.out.println("expB = " + expB);
                    a++;
                    coEffA = fPollyIntList.get(a);
                    //System.out.println("coEffA = " + coEffA);
                    b++;
                    coEffB = sPollyIntList.get(b);
                    //System.out.println("coEffB = " + coEffB);

                    // If expnonents are equal, adding the two coefficients and assaigning to list
                    if (expA == expB)
                    {
                        //System.out.println("Exponents are equal adding the two coefficients");
                        uPollyIntList.add((expA + expB) / 2);
                        uPollyIntList.add(coEffA - coEffB);
                        a++;
                        b++;
                        //System.out.println("Computed Polynomial so far = " + uPollyIntList);
                    }
                    // If exponent A is greater copying exponent A and coefficient A to the list
                    else if (expA > expB)
                    {
                        //System.out.println("Exponent A > Exponent B");
                        while (expA > expB)
                        {
                            //System.out.println("Appending the greater exponent's ExponentA " + expA + " CoEffA " + coEffA);
                            uPollyIntList.add(expA);
                            uPollyIntList.add(coEffA);
                            //System.out.println("Computed Polynomial so far = " + uPollyIntList);
                            a++;
                            expA = fPollyIntList.get(a);
                            a++;
                            coEffA = fPollyIntList.get(a);

                            //counteracting above while's increments
                            a--;
                            b--;
                        }
                    }
                    // If exponent B is greater copying exponent B and coefficient B to the list
                    else if (expB > expA)
                    {
                        //System.out.println("Exponent B > Exponent A");
                        while (expB > expA)
                        {
                            //System.out.println("Appending the greater exponent's ExponentB " + expB + " CoEfficientB " + coEffB);
                            uPollyIntList.add(expB);
                            uPollyIntList.add(coEffB);
                            //System.out.println("Computed Polynomial so far = " + uPollyIntList);
                            //System.out.println("b = " + b);
                            b++;
                            expB = sPollyIntList.get(b);
                            b++;
                            coEffB = sPollyIntList.get(b);

                            //counteracting above while's increments
                            a--;
                            b--;
                        }
                    }
                // Decrementing while loop twice for the increments by 2
                biggerArray--;
                biggerArray--;
                }//closing while loop
            } //closing if - 
            //System.out.println("END of - if");
            //System.out.println("Unformated Polynomial = " + uPollyIntList);
            
            a = uPollyIntList.size();
            String formattedP =  "";
            int intA = 0;
            String strA = "";
            int countA = 0;
            int countB = 1;
            // printing user defined polynomial name
            System.out.print(userSpecifiedP + " = ");
            
            
            // printing first Polynomial which doesn't have a + symbol
            if (uPollyIntList.get(countB)>= 0)
            System.out.print(uPollyIntList.get(countB) + "x");
            System.out.print("^" + uPollyIntList.get(countA));
            countA++;
            countA++;
            countB++;
            countB++;
            //iterating through the rest of the polynomials
            while (a > 2)
            {
                // formatting for polynomials with an exponent of 0
                if (uPollyIntList.get(countA) == 0)
                {
                    if (uPollyIntList.get(countB) >= 0)
                    System.out.print(" +" + uPollyIntList.get(countB) + "");
                    else //(uPollyIntList.get(countB) < 0)
                    System.out.print(" " + uPollyIntList.get(countB) + "");
                }
                // formatting for polynomials with an exponent of 1
                else if (uPollyIntList.get(countA) == 1)
                {
                    if (uPollyIntList.get(countB) >= 0)
                    System.out.print(" +" + uPollyIntList.get(countB) + "x");
                    else //(uPollyIntList.get(countB) < 0)
                    System.out.print(" " + uPollyIntList.get(countB) + "x");
                }
                // formatting for regular polynomials
                else if (uPollyIntList.get(countB) < 0)
                {
                    System.out.print(" " + uPollyIntList.get(countB) + "x");
                    System.out.print("^" + uPollyIntList.get(countA));
                }
                else 
                {
                    System.out.print(" +" + uPollyIntList.get(countB) + "x");
                    System.out.print("^" + uPollyIntList.get(countA));
                }
                //decrementing the while loop
                a--;
                a--;
                //incrementing positions with in the polynomial that was computed
                countA++;
                countA++;
                countB++;
                countB++;
            }
            System.out.println("");
            /*try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\Project1\\values.txt", true)));
            out.println();
            out.print(userSpecifiedP + " = " + uPollyIntList);
            out.close();
            } catch (IOException e) 
            {
                //woops
            }*/
            // prompting user if they want to rerun program.
            System.out.println("Do you want to continue (Y or N)? ");
            Scanner answerS = new Scanner(System.in);
            String answer = answerS.nextLine();
            if (answer.contains("y") || answer.contains("Y"))
                main(args);
            //formatPolynomials(pollyNameList);
            }// closing try
            catch (FileNotFoundException fnf) 
            {
            System.out.println(fnf.getMessage());
            }
    }
}
