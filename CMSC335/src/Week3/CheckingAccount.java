/*
 * Stephen Drollinger
 * 6 April 2014 
 * NetBeans 7.4
 * Homework week3 CheckingAccount Lianng 9th Ed. Problem 11.3
 */
package Week3;

import java.util.Scanner;

/**
 *
 * @author Valimere
 */
public class CheckingAccount extends Account {

    double overdraftLimit = 500;
    double requestedAmount;

    // withraw user specified amound to balance
    @Override
    public void withdraw() {
        // requesting amount to withdraw
        Scanner scanIn = new Scanner(System.in);
        System.out.print("Amount to withraw: ");
        System.out.println();
        requestedAmount = scanIn.nextDouble();
        
        //checking if there is sufficient funds + overdraft limit
        if (requestedAmount < overdraftLimit + this.getBalance()) {
            this.setBalance(this.getBalance() - requestedAmount);
            System.out.println("Your Remaining Balance is :" + this.getBalance());

        } else {
            System.out.println("Insuffecient Funds");
            System.out.println("Balance:                 " + this.getBalance());
            System.out.println("Overdraft Protection of :" + overdraftLimit);
        }
    }

}
