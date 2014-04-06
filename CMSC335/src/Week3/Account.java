/*
 * Stephen Drollinger
 * 23 Mar 2014 
 * NetBeans 7.4
 * Homework week1 Account Lianng 9th Ed. Problem 8.7
 */
package Week3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Valimere
 */
public class Account {

    private static int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private String dateCreated = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    // creating no arg constructor for account
    //Account myAccount = new Account();
    //Account idAccount = new Account();
    public static void setID(int userID) {
        id = userID;
    }

    public int getID() {
        return id;
    }

    public void setBalance(double userBalance) {
        balance = userBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAnnualInterestRate(double userAIR) {
        annualInterestRate = userAIR;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public String getAccountCreationDate() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    // deposit user specified amound to balance
    public void deposit() {
        System.out.print("Amount to deposit: ");
        Scanner scanIn = new Scanner(System.in);
        System.out.println();
        balance += scanIn.nextDouble();
    }

    // withraw user specified amound to balance
    public void withdraw() {
        System.out.print("Amount to withraw: ");
        Scanner scanIn = new Scanner(System.in);
        System.out.println();
        balance -= scanIn.nextDouble();
    }

}
