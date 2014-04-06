/*
 * CMIS242
 * Project 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * 31 March 2013
 * NetBeans IDE 7.3
 */
package CMIS242Project1;

public class Salesman extends Employee
{
    private static final int ANNUAL_SALES = 250000;
    private String name;
    private int monthlySalary;
    
    public Salesman(String name, int monthlySalary)
    {
        super(name, monthlySalary);
        this.monthlySalary = monthlySalary;
    }
    
    // calculating commission based off of .02 of annual sales
    // with a maximum of 20000 commission
    private double commission()
    {
        if (ANNUAL_SALES >= 1000000)
            return 20000;
        return ANNUAL_SALES * .02; 
    }
    
    // returning calculated annual salary
    @Override
    public double annualSalary()
    {
        return (double) monthlySalary * 12 + commission(); 
    }
    
    @Override
    public String toString()
    {
        return super.toString();
    }
}
