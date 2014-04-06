/**
 * CMSC350
 * Final Project
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE 16 Aug 2013
 * NetBeans IDE 7.3
 */

package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class TestSocialGraph<V> extends SocialGraph<V>{
    public TestSocialGraph(int[][] edges, V[] vertices) {
        super(edges, vertices);
    }
    public static void main (String[] args) throws FileNotFoundException{
        int selection = 0;
        int u = 0;
        int v = 0;
        List<String> vertices = new ArrayList<>();  
        List<Integer> edges = new ArrayList<>();
        // Grabbing inputs for the array lists
        Inputs();
        
        try { 
            // opening file will convert to user specified file ******
            File f = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\FinalProject\\values.txt");
            // Scanning numbers in
            Scanner scan = new Scanner(f);
            scan.useDelimiter(Pattern.compile("#| "));
                        // putting names into an array list

            while (scan.hasNext()){
             //Adding the names into the array   
                if (scan.hasNext("#")){
                    // skipping the # and anything after it in that line
                    //scan.skip("#");
                    scan.nextLine();
                    if (scan.hasNextInt()){ 
                        // adding edges, first int = u every int therafter is what its connected to = v
                        u = scan.nextInt();
                        while (scan.hasNextInt())
                        {
                            v = scan.nextInt();
                            edges.add(u, v);
                        }
                    }
                }
             else vertices.add(scan.next()); 
            }    
            
            System.out.println(vertices);  
            
            
            
            
        }// End of Try
            catch (FileNotFoundException fnf) 
            {
            System.out.println(fnf.getMessage());
            }
        
        System.out.println("Please make your selection by typing the number corrisponding to what you want to do");
        System.out.println("(1) isConnected");
        System.out.println("(2) normalizedDegreeOfCentrality");
        System.out.println("(3) numberOfTrianglesIncidentToVertex");
        System.out.println("(4) listOfTrianglesIncidentToVertex");
        System.out.println("(5) clusterIndividual");
        System.out.println("(6) averageClustering");
        System.out.println("(7) breadthFirstSearch");
        System.out.println("(8) depthFirstSearch");
        System.out.println("(9) exit");
        System.out.println("Console Input: ");
        
        Scanner scanned = new Scanner(System.in); 
        if (scanned.hasNextInt() == true) //checking if input is an Integer
            {
                selection = scanned.nextInt(); // assigning integer the int value of the scanner
                System.out.println("Your selection is: " + selection);
            }
            else //asking for user to input correct input
                System.out.println("A non integer was detected, plese run again and input an Integer:");
        
        if (selection == 1){
            isConnecteed ();
        }
        else if (selection == 2){
            int nDOC = SocialGraph.normalizedDegreeOfCentrality(edges, vertices);
            System.out.println(nDOC);
        }
        else if (selection == 3){
            SocialGraph.numberOfTrianglesIncidentToVertex();
        }
        else if (selection == 4){
            
        }
        else if (selection == 5){
            
        }
        else if (selection == 6){
            
        }
        else if (selection == 7){
            
        }
        else if (selection == 8){
            
        }
        else if (selection == 9){
            System.out.println("Closing the program");
            System.exit(0);
        }
        
    }// End of Main
    
    
public static void Inputs(){
    try {
    // Scans the file into a string
    String text = new Scanner( new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\FinalProject\\values.txt") ).useDelimiter("\\A").next();
    // takes everything before the pound
    String beforePound = text.substring(0, text.indexOf("#"));
    // takes everything after the pound
    String afterPound = text.substring(text.indexOf("#")+1, text.length());
    // takes the string and splits it (on the ;) into a list of strings;
    String[] beforePoundList = beforePound.split(";");
    //prints out the string of all names
    System.out.println("before "+beforePound);
    // interates thought the list of strings printing out each index of the list
    int i =0;
        for (String s : beforePoundList){
        System.out.println("Name: "+s +" @ index "+i);
        i++;
        }
    } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
 
}

    
}
