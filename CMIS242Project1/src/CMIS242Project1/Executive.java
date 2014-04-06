/*
 * CMIS242
 * Project 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * 31 March 2013
 * NetBeans IDE 7.3
 */
package CMIS242Project1;

public class Executive extends Employee
{
    private static final double SHARE_PRICE = 51;
    private String name;
    private int monthlySalary;
    
    public Executive(String name, int monthlySalary)
    {
        super(name, monthlySalary);
        this.monthlySalary = monthlySalary;
    }
    
    // Calculating bonus if shares are higher 
    // than $50 giving $30000 bonus.
    private double bonus()
    {
        if (SHARE_PRICE > 50)
            return 30000;
        return 0;
    }
    // returning calculated annual salary
    @Override
    public double annualSalary()
    {
        return (double) (monthlySalary * 12) + bonus(); 
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
