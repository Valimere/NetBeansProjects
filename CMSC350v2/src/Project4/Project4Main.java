/*
 * CMSC350 Project 4 Stephen Drollinger Valimere@gmail.com DATE 15 December 2013
 * NetBeans IDE 7.4
 */
package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.JFrame;

public class Project4Main extends JFrame{
    
        public Project4Main(GraphView view)
    {
        super("Rectangular Graph");
        setSize(400, 500);
        add(view);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Outputting name 
        System.out.println("Stephen Drollinger, CMSC350, Project4 Graphs");

        

        File inputFile = new File("C:\\Users\\Valimere\\Documents\\NetBeansProjects\\CMSC350v2\\src\\Project4\\input.txt");

        Scanner scan0 = new Scanner(inputFile);
        Scanner scan1 = new Scanner(inputFile);
        Scanner scan2 = new Scanner(inputFile);
        
        //Creating 2D array with the number of Y cooridanates matching the number of lines.
        int linecounter = 0;
        while (scan0.hasNextLine()== true){
            scan0.nextLine();
            linecounter++;
        }
        int[][] edgesIntList= new int[linecounter][2];
        String[] leftVerticesStringList = new String[linecounter];
        String[] rightVerticesStringList = new String[linecounter];
        
        ArrayList<AbstractGraph.Edge> edgelist = new ArrayList<AbstractGraph.Edge>();

        // inputting the names of the vertices into their respective lists
        for (int i = 0;(i<linecounter-1); i++){
            String x,y;
            
            x = scan1.next();
            System.out.println("Left : " + x);
            y = scan1.next();
            System.out.println("Right: " + y);
            leftVerticesStringList[i] = (x);
            rightVerticesStringList[i] = (y);
            scan1.nextLine();
        }
        System.out.println("Left Vertices:" + (leftVerticesStringList));
        System.out.println("Right Vertices:" + (rightVerticesStringList));
        
        //inputting edges into a 2D array
        for (int i = 0;(i<linecounter-1); i++){

            int x,y;
            //System.out.println("Passing Line:" + (scan2));
            scan2.skip("Left");
            x = scan2.nextInt();
            System.out.println("Left" + x);
            scan2.skip(" Right");
            y = scan2.nextInt();
            System.out.println("Right" + y);
            edgesIntList[i][0] = (x);
            edgesIntList[i][1] = (y);
            edgelist.add(new AbstractGraph.Edge(x, y));
            scan2.nextLine();
        }
        
        //creating BipartiteGraph using edges and vertices
        BipartiteGraph graph1 = new BipartiteGraph(edgesIntList, leftVerticesStringList);

        //showing graph works
        System.out.println("The Number of vertices in graph1: " + graph1.getSize());
        System.out.println("The vertex with index 1 is: " + graph1.getVertex(1));
        System.out.println("The Number of vertices in graph1: " + graph1.getIndex("Left3"));
        
        System.out.println("The edgelist is: ");
        graph1.printEdges();
        
        /*
        BipartiteVertex biView = new BipartiteVertex(leftVerticesStringList[0],edgesIntList[0][0], edgesIntList[0][1] );

        for (int i = 0;(i<linecounter-2); i++){
        biView = new BipartiteVertex(leftVerticesStringList[i],edgesIntList[i][0], edgesIntList[i][1] );
        }
        System.out.println("biView is: " + biView);
        */
        
        Project4Main window = new Project4Main(new GraphView (graph1));
        window.setVisible(true);

        //GraphView view = new GraphView(graph1);
        //view.setVisible(true);
        //GraphView view = new GraphView(BipartiteGraph<graph1>)
    }
}
