/**
 * CMSC350
 * Project ?
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE?
 * NetBeans IDE 7.3
 */
package Project3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class TestBST {
public static void main(String[] args) throws FileNotFoundException{    
        // Outputting name as required for all submitted work
        System.out.println("Stephen Drollinger, CMSC350, Project 3 Balancing BST" + "\n");
        
       
        // opening file will convert to user specified file ******
        try { 
            File f = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350\\src\\Project3\\values.txt");
            // Scanning numbers in
            Scanner scan = new Scanner(f);
            scan.useDelimiter(Pattern.compile("(\\n)|;"));
            
            // putting numbers into an array list
            List<String> InputList = new ArrayList<>();
            while (scan.hasNext())
                {
                    InputList.add(scan.next());
                }
            
            // Displaying array to show correct input
            System.out.println("The Input List is" + InputList);

            BST<String> tree = new BST<>();
                for (int i = 0; i < InputList.size(); i++){
                tree.insert(InputList.get(i));
                //System.out.println("Inserting " + InputList.get(i));
                }
                
                        // asking user to make a selection to tell the program what to do
            System.out.println("Please make a selection by inputting the number associated with the operation you want to do:");

            System.out.println("(1) in-order tree traversal");
            System.out.println("(2) calculateASE");
            System.out.println("(3) calculateMinASE");
            System.out.println("(4) calculateMaxASE");
            System.out.println("(5) isBalanced");
            System.out.println("(6) balanceBST");
            System.out.println("(7) exit the program");
            System.out.println("Your selection: ");

            // reading user input
            Scanner uSelect = new Scanner(System.in);
            String userSelection = uSelect.nextLine();
 
            if (userSelection.equals("1"))
            {
                System.out.print("The BST List is:  ");
                tree.inorder();
                System.out.println();
                System.exit(0);
            }
            else if (userSelection.equals("2"))
            {

            }
            else if (userSelection.equals("3"))
            {

            }
            else if (userSelection.equals("4"))
            {

            }
            else if (userSelection.equals("5"))
            {

            }
            else if (userSelection.equals("6"))
            {

            }
            else if (userSelection.equals("7"))
            {
                System.exit(0);
            }
            System.out.println();
            System.out.print("preorder:         ");
            tree.preorder();
            System.out.println();
            System.out.print("postorder:        ");
            tree.postorder();
            System.out.println();
            System.out.print("getsize:          ");
            System.out.println(tree.getSize());

            System.out.println("Calculating Height of Binary Tree :        ");
            System.out.println(tree.heightOfBinaryTree(tree.getRoot()));
            System.out.println("Calculating ASE:        ");
            System.out.println(tree.calculateASE(tree));
            
            System.out.println("finding the path to 6:        ");
            System.out.println(tree.path("6"));
            
            System.out.println("Printing Level and numbers:");
            System.out.println("Node => Level");
            tree.levelAndNumbers(tree.getRoot(), 0);
            
        }// End of Try
            catch (FileNotFoundException fnf) 
            {
            System.out.println(fnf.getMessage());
            } 
    }
}