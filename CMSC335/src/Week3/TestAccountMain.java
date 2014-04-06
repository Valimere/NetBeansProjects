/*
 * Stephen Drollinger
 * 6 April 2014 
 * NetBeans 7.4
 * Homework week3 TestAccount Lianng 9th Ed. Problem 11.3
 */
package Week3;

public class TestAccountMain {

    static Account myAccount = new Account();
    static CheckingAccount CheckingAccount = new CheckingAccount();
    static SavingsAccount SavingsAccount = new SavingsAccount();
    static int userID = 0;
    static double userBalance = 0;
    static double userAIR = 0;

    public static void main(String[] args) {
        //Initializing account
        userID = 1122;
        userBalance = 20000;
        userAIR = 0.045;
        
        // Starting with Savings Account
        SavingsAccount.setID(userID);
        System.out.println("ID: " + SavingsAccount.getID());
        SavingsAccount.setBalance(userBalance);
        System.out.println("Balance: " + SavingsAccount.getBalance());
        SavingsAccount.setAnnualInterestRate(userAIR);
        System.out.println("Annual Interest Rate: " + SavingsAccount.getAnnualInterestRate() * 100 + "%");

        // pre coded to use CLI will put in assigned 2500 withdraw, and 3000 deposit
        SavingsAccount.withdraw();
        SavingsAccount.deposit();

        //Printing Balance + warning not to withraw more than balance 
        System.out.println("Savings account Balance: " + SavingsAccount.getBalance());

        //Printing monthly interest
        System.out.println("Monthly interest: " + SavingsAccount.getMonthlyInterest());

        //Printing account creation date
        System.out.println("Account Creation: " + SavingsAccount.getAccountCreationDate());

        
        
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("Secondary Transaction to test Checking account");
        
        // Checking Account
        CheckingAccount.setID(userID);
        System.out.println("ID: " + CheckingAccount.getID());
        CheckingAccount.setBalance(userBalance);
        System.out.println("Balance: " + CheckingAccount.getBalance());
        CheckingAccount.setAnnualInterestRate(userAIR);
        System.out.println("Annual Interest Rate: " + CheckingAccount.getAnnualInterestRate() * 100 + "%");

        // pre coded to use CLI will put in assigned 2500 withdraw, and 3000 deposit
        CheckingAccount.withdraw();
        CheckingAccount.deposit();

        //Printing Balance
        System.out.println(" Balance                 : " + CheckingAccount.getBalance());
        System.out.println("Overdraft Protection limit:" + CheckingAccount.overdraftLimit);

        //Printing monthly interest
        System.out.println("Monthly interest: " + CheckingAccount.getMonthlyInterest());

        //Printing account creation date
        System.out.println("Account Creation: " + CheckingAccount.getAccountCreationDate());

    }

}
