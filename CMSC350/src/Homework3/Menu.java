/**
 * CMSC350
 * Homework 3 Menu
 * Stephen Drollinger
 * Valimere@gmail.com
 * 28 July 2013
 * NetBeans IDE 7.3
 */
package Homework3;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Menu {
public static void main(String[] args) throws FileNotFoundException
	{    
            int fileLineCount = 0;
            // Outputting name as required for all submitted work
            System.out.println("Stephen Drollinger, CMSC350, Homework 3 Menu" + "\n");
            
            //List<String> MainMenuStringList = new LinkedList<>();
            // Creating LinkedList of the menu items
            
            try { 
                File f = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\Homework3\\Menu.txt");
                File a = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\Homework3\\MenuAdd.txt");
                Scanner scan = new Scanner(f);
                List<String> MainMenuList = new LinkedList<>();
                while (scan.hasNextLine() == true)
                {// creating list of Strings for the Main menu to use them as the name of the linked lists, and count the number
                    int stop = 0;
                    String temp = new String(scan.next());
                    //System.out.println("Temp: " + temp);
                    stop = temp.indexOf(";", 0);
                    temp = temp.substring(0, stop);
                    //MainMenuStringList.add(temp);
                    MainMenuList.add(temp);
                    //scan.useDelimiter(";").nextLine();
                    //System.out.println("MainMenuString: " + MainMenuStringList);
                    fileLineCount++;
                }
                //System.out.println("MainMenuString: " + MainMenuStringList);
                //System.out.println("Number of Main menu items = " + fileLineCount);

                // Resetting Scanner to beginning of file
                scan = new Scanner(f);
                scan.useDelimiter(Pattern.compile("(\\n)|;"));
                
                // Resetting Scanner to beginning of file
                scan = new Scanner(f);

                //scanning first line to be turned into linked list
                //System.out.println("MainMenuList: " + MainMenuList);
                List<String> SubMenuList = new LinkedList<>();
                
                // iterating through the inputfile lines and assigning each line to a linked list
                while (scan.hasNextLine() == true){
                    int i = 0;
                    int count = 0;
                    String temp = new String(scan.next());

                    // adding an additional count because there is the number of ; +1 menu items
                    count++;
                    //System.out.println("count: " + count);  
                    SubMenuList.add(temp);
                    count = 0;
                    i++;
                }
                System.out.println("Using Iterator for Main Menu:");
                for(Iterator it = MainMenuList.iterator(); it.hasNext();) {
                    System.out.print(it.next() + ";");
                }
                System.out.println( "\n");
                System.out.println("Using Iterator for Sub Menu:");
                for(Iterator it = SubMenuList.iterator(); it.hasNext();) {
                    System.out.println(it.next() + ";");
                }
                System.out.println();
                
                // Scanning MenuAdd file to insert into the menu's
                scan = new Scanner(a);
                // Reading where to place the insert
                String insertMeAfter = scan.next();
                System.out.println(insertMeAfter);
                
                // Finding where in the Linked list to place 
                int placeMeHere = MainMenuList.indexOf(insertMeAfter);
                //Iterating to be placed after
                placeMeHere++;
                System.out.println(placeMeHere);
                
                //Skipping whitespace
                scan.skip(("\\n|\\s"));
                scan.useDelimiter(Pattern.compile("(\\n)|;"));
                
                // Adding Main Menu Item and re printing menu
                MainMenuList.add(placeMeHere, scan.next());
                System.out.println("Using Iterator for Main Menu:" + MainMenuList);
                for(Iterator it = MainMenuList.iterator(); it.hasNext();) {
                    System.out.print(it.next() + ";");
                }
                
                // Adding Sub Menu Items
                while (scan.hasNextLine() == true){
                    String temp = new String(scan.next());
                    SubMenuList.add(placeMeHere, temp);
                }
                
                // Re Printing Sub Menu
                System.out.println( "\n");
                System.out.println("Using Iterator for Sub Menu:");
                for(Iterator it = SubMenuList.iterator(); it.hasNext();) {
                    System.out.println(it.next() + ";");
                }
                System.out.println();
                
            }// End of Try
            catch (FileNotFoundException fnf) 
            {
            System.out.println(fnf.getMessage());
            }
        }
}
