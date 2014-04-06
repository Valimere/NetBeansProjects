
package HomeWork2;

/**
 * CMSC350
 * Homework 2
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE 7/14/2013
 * NetBeans IDE 7.3
 */
import java.util.*;
public class TestPolyVal {
    public static void main(String[] args){
        List<Double> coeffs = new ArrayList<>();
        coeffs.add(-19.0);
        coeffs.add(7.0);
        coeffs.add(-4.0);
        coeffs.add(6.0);
        System.out.println(polyEval(coeffs, 3));
        
        calculateBruteForce();
        
        List<Double> x = new ArrayList<>();
        calculateHorner(coeffs, x);
}
public static double calculateBruteForce(List<Integer> list, int n){
    Collections.reverse(list); 
    double val = list.get(0);
    double polyVal = 0.00;
            
            double power = 0;
            for (int i = 0; i < n-1;i++)
            {
                double pow =0.00;
                for (int j = 0; j < n; j++){
                pow *= val;
                }
                
                polyVal += n * list(val, i);
            }
            double answer = 0.00;
            return polyVal;
            
        }


public class Horner {

    
 
    public double calculateHorner(List<Double> coefficients, double x) {
        Collections.reverse(coefficients);
        Double accumulator = coefficients.get(0);
        for (int i = 1; i < coefficients.size(); i++) {
            accumulator = (accumulator * x) + (Double) coefficients.get(i);
        }
        return accumulator;
    }
}
}
