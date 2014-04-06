/*
 * CMIS242
 * Project 2
 * Stephen Drollinger
 * Valimere@gmail.com
 * 28 April 2013
 * NetBeans IDE 7.3
 */
package ProgramProject3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project3 extends JFrame implements ActionListener
{
    // Declaring Buttons and text fields
        private JRadioButton selectIterative = new JRadioButton("Iterative", true);
        private JRadioButton selectRecursive = new JRadioButton("Recursive");
        private JTextField inputNIterations = new JTextField(20);
	private JButton action = new JButton("Compute");
        private JTextField outputResult = new JTextField(20);
        private JTextField outputEfficiency = new JTextField(20);
        int count = 0;
     
    public Project3()
	{
            //setting up the Javaframe, Populating, and passing proper layout
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2,10,10));
		add(new JLabel("          ")); add (selectIterative);
                add(new JLabel("          ")); add (selectRecursive);
                add(new JLabel("Enter n:  ")); add (inputNIterations);
                add(new JLabel("          ")); add (action);
		add(new JLabel("Result    ")); add (outputResult);
                add(new JLabel("Efficiency")); add (outputEfficiency);
		outputResult.setEditable(false);
                outputEfficiency.setEditable(false);
		action.addActionListener(this);    
       
        // Grouping the radio buttons 
        ButtonGroup group = new ButtonGroup();
        group.add(selectIterative);
        group.add(selectRecursive);
        }
    
    public static void main(String[] args)
	{
            // Outputting name as required for all Projects
            System.out.println("Stephen Drollinger");
            
            // making window visiable
		Project3 frame = new Project3();
		frame.setVisible(true);
	}    

    //    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // passing input for # of runs to n
        int n = Integer.parseInt(inputNIterations.getText());
        count = 0;
        selectIterative.addActionListener(this);
        
        // choosing which method to use
        if (selectIterative.isSelected())
                {
                //passing n variable to method getting result and displaying for Iterative
                int iterativeFibonacciResult = iterativeFibonacci(n);
                outputResult.setText(Integer.toString(iterativeFibonacciResult));
                outputEfficiency.setText(Integer.toString(count));
                }
        else{
            //passing n variable to method getting result and displaying for Recursive
            selectRecursive.addActionListener(this);
            int recursiveFibonacciResult = recursiveFibonacci(n);
            outputResult.setText(Integer.toString(recursiveFibonacciResult));
            outputEfficiency.setText(Integer.toString(count));
        }
    }

    //implimenting iterative Fibonacci method
    public int iterativeFibonacci(int n)
	{
		int previous = 0, current = 1, next;
		for (int i = 1; i <= n; i++)
		{
			next = previous + current;
			previous = current;
			current = next;
                        count++;
		}
                System.out.println("Iterative used");
		return previous;              
	}
    
    //implimenting recursive Fibonacci method
    public int recursiveFibonacci(int n)
	{
		if (n <= 1)
                    return n;
                count++;
                System.out.println("Recursive used");
		return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    
}
