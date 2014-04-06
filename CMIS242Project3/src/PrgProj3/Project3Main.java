/*
 * CMIS242
 * Project 2
 * Stephen Drollinger
 * Valimere@gmail.com
 * 28 April 2013
 * NetBeans IDE 7.3
 */
package PrgProj3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;


 class Project3Main extends JFrame implements ActionListener
{
        private JRadioButton selectIterative = new JRadioButton("Iterative", true);
        private JRadioButton selectRecursive = new JRadioButton("Recursive");
        private JTextField inputNIterations = new JTextField(20);
	private JButton action = new JButton("Compute");
        private JTextField outputResult = new JTextField(20);
        private JTextField outputEfficiency = new JTextField(20);
        
        JPanel jpRadioButtons = new JPanel();
        jpRadioButtons.setLayout(new GridLayout(3, 2));
        
        
// Grouping Radio Buttons
     private void groupButton() 
        {
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(selectIterative);
        bgroup.add(selectRecursive);
        selectIterative.addItemListener(new SelectItemListener());
        selectRecursive.addItemListener(new SelectItemListener());
        }
        class SelectItemListener implements ItemListener {
		public void itemStateChanged(final ItemEvent e) {
			// get object
			final AbstractButton sel = (AbstractButton) e.getItemSelectable();
			// checkbox select or not
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (sel.getText().equals(true)) {
                                    iterativeFibonacci(numberOfRuns);
					//Project3Main.this.tf.setText(Project3Main.data1);
				} else if (sel.getText().equals(true)) {
                                    recursiveFibonacci(numberOfRuns);
					//Project3Main.this.tf.setText(Project3Main.data2);
				}
			}
		}

        
        }
        

        //setting up window
	public Project3Main()
	{
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
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int numberOfRuns = Integer.parseInt(inputNIterations.getText());
        private void iterativeFibonacci() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private int recursiveFibonacci(int numberOfRuns) {

	{
		int previous = 0, current = 1, next;
		for (int i = 1; i <= numberOfRuns; i++)
		{
			next = previous + current;
			previous = current;
			current = next;
		}
		return previous;
	}
        }
    }
    
    public static void main(String[] args)
	{
            // Outputting name as required for all Projects
            System.out.println("Stephen Drollinger");
            
            // making window visiable
		Project3Main frame = new Project3Main();
		frame.setVisible(true);
	}

                //public void itemStateChanged(ItemEvent ie) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //}
 }
