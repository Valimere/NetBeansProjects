/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HW4;

import java.awt.*;

class PointParameters
{
          public static void main(String [] args)
         {
                int x = 1, y = 1;
                Point p = new Point(x, y), q = new Point(x, y);
               doubleScale(x, y, p, q);
               System.out.println( "(x,y) = " + new Point(x, y) +
               " p = " + p + " q = " + q);
           }

         private static void doubleScale(int x, int y, Point p, Point q)
          {
              System.out.println( "x = " + x);
                 x *= 2;
                System.out.println( "x = " + x);
                System.out.println( "y = " + y);
                 y *= 2;
                 System.out.println( "y = " + y);
                 System.out.println( "p.x = " + p.x);
                p.x *= 2;
                System.out.println( "p.x = " + p.x);
                System.out.println( "p.y = " + p.y);
                p.y *= 2;
                System.out.println( "p.y = " + p.y);
               q = new Point(x, y);
               System.out.println( "q Point(x,y) = " + q);
          }
}
