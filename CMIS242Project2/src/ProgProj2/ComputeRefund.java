/*
 * CMIS242
 * Project 2
 * Stephen Drollinger
 * Valimere@gmail.com
 * 14 April 2013
 * NetBeans IDE 7.3
 */
package ProgProj2;

public class ComputeRefund extends StateIncomeCalcMain
{
    // Overriding name and monthly salary
    private int inputSalaryIncome;
    private int inputInterestIncome;
    private int inputItemizedDeductions;
    private int inputExemptions;
    private int inputTaxWitheld;
    
    private int exemptionAmount = 2700;
    
    // making ComputeRefund public with inherited values
    public ComputeRefund(int SalaryIncome, int InterestIncome
            , int ItemizedDeductions, int Exemptions, int TaxWitheld)
    {
        this.inputSalaryIncome = inputSalaryIncome;
        this.inputInterestIncome = inputInterestIncome;
        this.inputItemizedDeductions = inputItemizedDeductions;
        this.inputExemptions = inputExemptions;
        this.inputTaxWitheld = inputTaxWitheld;
        
        System.out.println(inputSalaryIncome);
        System.out.println(inputInterestIncome);
        System.out.println(inputItemizedDeductions);
        System.out.println(inputExemptions);
        System.out.println(inputTaxWitheld);
        
    }
    
    // computing gross income
    private int totalGrossIncome = inputSalaryIncome + inputInterestIncome;
    
    // computing taxable income
    private int taxableIncome = totalGrossIncome - inputItemizedDeductions
            - (inputExemptions * exemptionAmount);
    
    //computing Taxes owed
    private double taxesOwed()
    {
        if (taxableIncome <= 50000)
            return (taxableIncome * .05);
        
        if (taxableIncome <= 100000)
            return (((taxableIncome - 50000)* .07) + 2500);
        
        return (((taxableIncome - 100000)* .09) + 6000);
    }
    
    // calculating refund
    private double refund =  Math.round(inputTaxWitheld - taxesOwed());
    //public static double parseDouble (stringRefund refund);
    public String stringRefund = Double.toString(refund);

    
    // outputting refund
    @Override
    public String toString()
    {
        return "Your Refund $" + stringRefund;
    }
    
    }
    /*
    @Override
    public String toString()
    {
        return " Name = " + name + " Annual Salary " + annualSalary();
    }
    */ 


