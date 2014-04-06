/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ProgramProject3;

/**
 * CMSC350
 * Project ?
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE?
 * NetBeans IDE 7.3
 */
import java.io.*;

public class useint 
{
    public static void main (String args[])
    throws IOException 
    {
        BufferedReader b = new BufferedReader
        (new InputStreamReader(System.in));
        String string;
        int i;
        int sum = 0;
        System.out.println("Please input numbers:");
        System.out.println("Type 0 to exit");

        do{
        string = b.readLine();
        try{
        i = Integer.parseInt(string);
        } catch(NumberFormatException NFE){
        System.out.println("Please try again");
        i = 0;
        }

        sum = sum + 1;
        System.out.println("Count = " + sum);
        } while(i != 0);
    }
}
