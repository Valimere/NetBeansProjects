/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW6;

/**
 *
 * @author Valimere
 */
public class Circle {

    public static void main(String[] args) {
	Circle circle1 = new Circle(100.0);
	Circle circle2 = new Circle(200.0);
	ColoredCircle redCircle = new ColoredCircle(300, "red");
	ColoredCircle blueCircle = new ColoredCircle(400.0, "blue");
   circle1 = redCircle;
   circle2 = blueCircle;
   circle1.put();
	System.out.print("\n");
	circle2.put();
	System.out.print("\n");
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public void put() {
        System.out.print("Radius = " + radius);
    }
    private double radius;
}

class ColoredCircle extends Circle {
    public ColoredCircle(double radius, String color) {
        super(radius);
        this.color = color;
    }
    @Override
    public void put() {
        super.put();
        System.out.print(" Color = " + color);
    }
    private String color;
}
