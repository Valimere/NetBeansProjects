/*
 * CMIS242
 * Project 2
 * Stephen Drollinger
 * Valimere@gmail.com
 * 14 April 2013
 * NetBeans IDE 7.3
 */
package ProgProj2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// initalizing text fields up window
class StateIncomeCalcMain extends JFrame implements ActionListener
{
	public JTextField inputSalaryIncome = new JTextField(20); 
        private JTextField inputInterestIncome = new JTextField(20);
        private JTextField inputItemizedDeductions = new JTextField(20);
        private JTextField inputExemptions = new JTextField(20);
        private JTextField inputTaxWitheld = new JTextField(20);
	private JButton action = new JButton("Compute Refund");
        private JTextField outputRefund = new JTextField(20);
	
        //setting up window
	public StateIncomeCalcMain()
	{
		//super("Prject 2");
		setSize(500, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2,10,10));
		add(new JLabel("Salary Income:      ")); add (inputSalaryIncome);
                add(new JLabel("Interest Income:    ")); add (inputInterestIncome);
                add(new JLabel("Itemized Deductions:")); add (inputItemizedDeductions);
                add(new JLabel("Exemptions:         ")); add (inputExemptions);
                add(new JLabel("Tax Witheld:        ")); add (inputTaxWitheld);
                add(new JLabel("                    ")); add (action);
		add(new JLabel("Refund              ")); add (outputRefund);
		outputRefund.setEditable(false);		
		action.addActionListener(this);
	}	
        
        // setting up action on key click to include print outs for testing
	 public void actionPerformed(ActionEvent event)
 {
            int salaryIncome = Integer.parseInt(inputSalaryIncome.getText());
            int interestIncome= Integer.parseInt(inputInterestIncome.getText());
            int itemizedDeductions= Integer.parseInt(inputItemizedDeductions.getText());
            int exemptions= Integer.parseInt(inputExemptions.getText());
            int taxWitheld = Integer.parseInt(inputTaxWitheld.getText());
           
           double refund = outputRefund(salaryIncome,interestIncome,itemizedDeductions,
                    exemptions,taxWitheld);
            
           outputRefund.setText(""+Math.round(refund)); 
 }
        
	public static void main(String[] args)
	{
            // Outputting name as required for all Projects
            System.out.println("Stephen Drollinger");
            
            // making window visiable
		StateIncomeCalcMain frame = new StateIncomeCalcMain();
		frame.setVisible(true);
	}

    private double outputRefund(int salaryIncome, int interestIncome, 
            int itemizedDeductions, int exemptions, int taxWitheld) 
    {    
         int exemptionAmount = 2700;
         double taxesOwed = 0;
        // computing gross income
         int totalGrossIncome = salaryIncome + interestIncome;
                 System.out.println("total Gross Income " + totalGrossIncome);

    
        // computing taxable income
         int taxableIncome = totalGrossIncome - itemizedDeductions
            - (exemptions * exemptionAmount);
         System.out.println("total taxable Income " + taxableIncome);
         
            // computing taxes owed
            if (taxableIncome <= 50000)
            {
                taxesOwed = (taxableIncome*.05);
                System.out.println("taxes owed .05 Bracket " + taxesOwed); 
            }
        
            else if (taxableIncome <= 100000)
            {
               taxesOwed = ((taxableIncome - 50000)* .07) + 2500;
               System.out.println("taxes owed .07 Bracket " + taxesOwed); 
            }
        
            else
            {
               taxesOwed = ((taxableIncome - 100000)* .09) + 6000;
               System.out.println("taxes owed .09 Bracket " + taxesOwed); 
            }
            return ((taxWitheld-taxesOwed));
  
    }
}
