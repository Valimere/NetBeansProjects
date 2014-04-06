/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Week3;

public class Circle {

    private double radius;

    public Circle(double radius) {
        radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}

class B extends Circle {

    private double length;

    B(double radius, double length) {
        Circle(radius);
        length = length;
    }

    @Override
    public double getArea() {
        return getArea() * length;
    }
}
}
