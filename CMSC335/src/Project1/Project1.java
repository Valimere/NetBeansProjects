/*
 * Stephen Drollinger
 * Course CMSC335
 * Date: 3/29/2014
 * Project: Project 1
 * File: Project1.java
 * Development Enironment Windows 7 Netbeans IDE 7.4 java 1.7.0_45
 */
package Project1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Project1 extends JFrame implements ActionListener {

    // Constants
    private final boolean DEBUGGING = true; // Prints debugging information to console
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;
    static File[] chosenFile;

    //Models
    //Data Structures
    Library<Book> library = new Library<Book>();
    Vector<Vector<String>> rowElement = new Vector<Vector<String>>();

    // Instantiate JFrame window
    public static void main(String[] args) {
        SimpleFileChooser sfc = new SimpleFileChooser();
        sfc.setVisible(true);
        chosenFile = SimpleFileChooser.getFile();
        System.out.println("Chosen File =" + chosenFile);
        new Project1();
    }

    //Constructor for the JFrame
    public Project1() {
        super();
        this.setSize(500, 325);
        this.setContentPane(getJContentPane());
        this.setTitle("Book Library");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());
            jContentPane.add(getBtPanel(), BorderLayout.EAST);
            jContentPane.add(getEntryPanel(), BorderLayout.SOUTH);
            jContentPane.add(getTablePanel(), BorderLayout.WEST);
        }
        return null;
    }

    private JPanel btPanel = null;
    private JPanel entryPanel = null;
    private JPanel tablePanel = null;

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    private JPanel jContentPane = null;

    private Component getBtPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Component getEntryPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Component getTablePanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
