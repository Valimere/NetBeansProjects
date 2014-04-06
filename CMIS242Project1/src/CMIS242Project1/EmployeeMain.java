/*
 * CMIS242
 * Project 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * 31 March 2013
 * NetBeans IDE 7.3
 */
package CMIS242Project1;

class EmployeeMain 
{
    public static void main(String[] args)
	{
            // Outputting name as required for all Projects
            System.out.println("Stephen Drollinger");
            
            // Creating an array of all employees include sub employees (Salesman, Executive)
            // and passing paramaters
            Employee[] employees = {new Employee ("Steve Doe",10000)
                ,new Salesman("John Doe",9000)
                ,new Executive("Mary Jane",8000)};
              
            //Printing array of employees
            for (Employee employee: employees)
		{
                    //employee.annualSalary();
                    System.out.println(employee.toString());                    
		}
	}
}
