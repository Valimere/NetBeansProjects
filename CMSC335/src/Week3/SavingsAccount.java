/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Week3;

import java.util.Scanner;

/**
 *
 * @author Valimere
 */
public class SavingsAccount extends Account {
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
        if (requestedAmount < this.getBalance()) {
            this.setBalance(this.getBalance() - requestedAmount);
            System.out.println("Your Remaining Balance is :" + this.getBalance());

        } else {
            System.out.println("Insuffecient Funds");
            System.out.println("Balance: " + this.getBalance());
        }
    }

}