/**
 * CMSC330 Homework 2 Stephen Drollinger Valimere@gmail.com DATE 28 January 2014
 * NetBeans IDE 7.4
 */
package HW2;

import java.util.Scanner;

public class H2_2 {

    // I iterate's through given input string
    public static int i = 1;
    public static String returned = "";
    public static char a = 'a';
    public static char b = 'b';

    public static void main(String[] args) {
        // Outputting name 
        System.out.println("Stephen Drollinger, CMSC330, Homework 2 Parsing grammar");

        System.out.println();
        System.out.println("Please input the string you wish to parse:");
        Scanner scanned = new Scanner(System.in);
        String inputString = scanned.nextLine(); //Variabalizing user input
        System.out.println("Your String is: " + inputString);

        System.out.println("input length = " + inputString.length());

        for (i = 1; i <= inputString.length(); i++) {
            // loading the current charachter + 1 look ahead into seperate char variables
            a = inputString.charAt(i-1);
            if (i<inputString.length()-1){
            b = inputString.charAt(i);
            }

            if (i == 1) {
                returned = sMethod(a, b);
            }

            if (returned == "S") {
                bMethod(a, b);
                i++;
            }
            if (returned == "B") {
                bMethod(a, b);
                i++;
            }
            if (returned == "C") {
                cMethod(a, b);
                i++;
                i++;
            }
            if (returned == "exit") {
                System.exit(1);
            }
        }

    }

    public static String sMethod(char a, char b) {
        System.out.println("Enter S");
        if (a == 'a') {
            System.out.println("First character is " + a);
            return "B";
        }
        if (a == 'b') {
            return "exit";
        }
        if (a == 'c') {
            System.out.println("First character is " + a);
            return "C";
        } else {
            System.out.println("improper input detected");
            return "exit";
        }
    }

    public static String bMethod(char a, char b) {
        System.out.println("Enter B");
        if (a == 'a') {
            System.out.println("Next character is " + b);
            return "B";
        }
        if (a == 'b') {
            System.out.println("Next character is " + b);
            return "S";
        } else {
            System.out.println("improper input detected");
            return "exit";
        }
    }

    public static String cMethod(char a, char b) {
        System.out.println("Enter C");
        if (a == 'a' && b == 'a') {
            System.out.println("Next character is " + b);
            System.out.println("Next character is " + b);
            return "S";
        }
        if (a == 'b') {
            return "exit";
        }
        if (a == 'c' && b == 'a') {
            System.out.println("Next character is " + b);
            System.out.println("Next character is " + b);
            return "B";
        } else {
            System.out.println("improper input detected");
            return "exit";
        }
    }
}
