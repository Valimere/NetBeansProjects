/*
 * CMIS242
 * Project 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * 31 March 2013
 * NetBeans IDE 7.3
 */
package CMIS242Project1;

class Employee 
{
    // Overriding name and monthly salary
    private String name;
    private int monthlySalary;

    
    // making Employee public with inherited values
    public Employee(String name, int monthlySalary)
    {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
    
    // computing annual salary based off of monthly salary
    public double annualSalary()
    {
        return (double) monthlySalary * 12;
    }
    
    // outputting name and annual salary
    @Override
    public String toString()
    {
        return " Name = " + name + " Annual Salary " + annualSalary();
    }
}
