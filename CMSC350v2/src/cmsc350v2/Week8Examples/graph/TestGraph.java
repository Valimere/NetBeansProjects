package cmsc350v2.Week8Examples.graph;

import java.io.*;
import java.util.*;
import javax.swing.*;

class TestGraph extends JFrame
{
    public TestGraph(GraphView view)
    {
        super("Rectangular Graph");
        setSize(500, 500);
        add(view);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner stdin = new Scanner(System.in);
        RectangularGraph graph = new RectangularGraph();
        System.out.print("Enter file name: ");
        String fileName = stdin.nextLine();
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextLine())
        {
            String edgeString = input.nextLine();
            String[] edge = edgeString.split(" ");
            graph.addEdge(edge[0], edge[1]);
        }
        TestGraph window = new TestGraph(new GraphView(graph));
        window.setVisible(true);
        System.out.println("Depth first: " + graph.depthFirst(0));
        System.out.println("Breadth first: " + graph.breadthFirst(0));
        System.out.println("Connected is " + graph.isConnected());
        System.out.println("Has cycles is " + graph.hasCycles());
        System.out.println("Connected components = " + graph.connectedComponents());
    }
}