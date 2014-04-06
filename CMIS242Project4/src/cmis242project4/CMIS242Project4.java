/*
 * CMIS242
 * Project 2
 * Stephen Drollinger
 * Valimere@gmail.com
 * 12 May 2013
 * NetBeans IDE 7.3
 */
package cmis242project4;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;

public class CMIS242Project4 extends JFrame implements ActionListener
{
    // Declaring RadioButtons and text field
        private JRadioButton selectBlack = new JRadioButton("Black");
        private JRadioButton selectNavy = new JRadioButton("Navy");
        private JRadioButton selectBlue = new JRadioButton("Blue");
        private JRadioButton selectGreen = new JRadioButton("Green");
        private JRadioButton selectOlive = new JRadioButton("Olive");
        private JRadioButton selectRed = new JRadioButton("Red");
        private JRadioButton selectWheat = new JRadioButton("Wheat");
        private JRadioButton selectYellow = new JRadioButton("Yellow");
        private JTextField outputHex = new JTextField(20);
        int count = 0;
     
    public CMIS242Project4()
	{
            //setting up the Javaframe, Populating, and passing proper layout
		setSize(300, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2,10,10));
		add(new JLabel("          ")); add (selectBlack);
                add(new JLabel("          ")); add (selectNavy);
                add(new JLabel("          ")); add (selectBlue);
                add(new JLabel("          ")); add (selectGreen);
                add(new JLabel("          ")); add (selectOlive);
                add(new JLabel("          ")); add (selectRed);
                add(new JLabel("          ")); add (selectWheat);
                add(new JLabel("          ")); add (selectYellow);
		add(new JLabel("Hex Value    ")); add (outputHex);
		outputHex.setEditable(false);
		selectBlack.addActionListener(this);
                selectNavy.addActionListener(this);
                selectBlue.addActionListener(this);
                selectGreen.addActionListener(this);
                selectOlive.addActionListener(this);
                selectRed.addActionListener(this);
                selectWheat.addActionListener(this);
                selectYellow.addActionListener(this);
       
        // Grouping the radio buttons 
        ButtonGroup group = new ButtonGroup();
        group.add(selectBlack);
        group.add(selectNavy);
        group.add(selectBlue);
        group.add(selectGreen);
        group.add(selectOlive);
        group.add(selectRed);
        group.add(selectWheat);
        group.add(selectYellow);     
        }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
            // Outputting name as required for all Projects
            System.out.println("Stephen Drollinger");
            
            // making window visiable
            CMIS242Project4 frame = new CMIS242Project4();
            frame.setVisible(true);
                
             HashMap<String, String> map = new HashMap<String, String>();
                map.put("Black","#000000");
                map.put( "Navy", "#000080" );
                map.put( "Blue", "#0000FF" );
                map.put( "Green", "#008000" );
                map.put( "Olive", "#808000" );
                map.put( "Red", "#FF0000" );
                map.put( "Wheat", "#F5DEB3" );
                map.put( "Yellow", "#FFFF00" );
                
                //Printing map to prove i set it up 
                System.out.println( "map = " + map );
                
                // i can reference the value of "Black" here and it outputs, but i can't
                // seem to pass it to the action event
                System.out.println("Does HashMap contains 21 as key: " + map.get("Black"));            
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Was trying to get the hashmap to be referenced here and put <Key>  
        //instead of the hex but i couldn't get it to work so i used the hex to make the program work.
                 if (selectBlack.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#000000"));
                     outputHex.setText("#000000");
                 }
                 if (selectNavy.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#000080"));
                    outputHex.setText("#000080");
                 }
                 if (selectBlue.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#0000FF"));
                     outputHex.setText("#0000FF");
                 }
                 if (selectGreen.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#008000"));
                     outputHex.setText("#008000");
                 }
                 if (selectOlive.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#808000"));
                     outputHex.setText("#808000");
                 }
                 if (selectRed.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#FF0000"));
                     outputHex.setText("#FF0000");
                 }
                 if (selectWheat.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#F5DEB3"));
                     outputHex.setText("#F5DEB3");
                 }
                 if (selectYellow.isSelected())
                 {
                     getContentPane().setBackground(java.awt.Color.decode("#FFFFE0"));
                     outputHex.setText("#FFFFE0");
                 }
    }
    
}
