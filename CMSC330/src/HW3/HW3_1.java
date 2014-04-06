/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HW3;

/**
 *
 * @author Valimere
 */
public class HW3_1 { 
          public static void main(String[] args)
          {
                int local = 1;

               Comparable compare = new Comparable ()
                      {
                              public int compareTo(Object value)
                                    {
                                         return (Integer)value - local;
                                    }
                      };
                     System.out.println(compare.compareTo(5));
           }

    
}
