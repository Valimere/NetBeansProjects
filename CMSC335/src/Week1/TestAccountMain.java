/*
 * Stephen Drollinger
 * 23 Mar 2014 
 * NetBeans 7.4
 * Homework week1 Test account main Lianng 9th Ed. Problem 8.7
 */
package Week1;

public class TestAccountMain {

    static Account myAccount = new Account();
    static int userID = 0;
    static double userBalance = 0;
    static double userAIR = 0;

    public static void main(String[] args) {
        // was going to ask via CLI for input, but hard coding sense there is
        // only one set of options for the book issued problem.
        //System.out.println("Please input account ID: ");
        //Scanner scanInID = new Scanner(System.in);
        //userID = scanInID.nextInt();

        // Problem defined paramaters
        userID = 1122;
        userBalance = 20000;
        userAIR = 0.045;

        // passing inital values
        myAccount.setID(userID);
        System.out.println("ID: " + myAccount.getID());
        myAccount.setBalance(userBalance);
        System.out.println("Balance: " + myAccount.getBalance());
        myAccount.setAnnualInterestRate(userAIR);
        System.out.println("Annual Interest Rate: " + myAccount.getAnnualInterestRate() * 100 + "%");

        // pre coded to use CLI will put in assigned 2500 withdraw, and 3000 deposit
        myAccount.withdraw();
        myAccount.deposit();

        //Printing Balance
        System.out.println(" Balance: " + myAccount.getBalance());

        //Printing monthly interest
        System.out.println("Monthly interest: " + myAccount.getMonthlyInterest());

        //Printing account creation date
        System.out.println("Account Creation: " + myAccount.getAccountCreationDate());

    }

}
