/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polygons;

import java.text.DecimalFormat;

/**
 *
 * @author jones
 */
public abstract class Shape implements Comparable<Shape> {

    double height;

    public Shape(double height) {
        this.height = height;
    }

    public abstract double calcVolume();

    public abstract double calcBaseArea();

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public int compareTo(Shape shape2) {
        if (this.getHeight() > shape2.getHeight()) {
            return 1;
        } else if (this.getHeight() < shape2.getHeight()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString(String comparetype) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        if (null == comparetype) {
            return "The " + getClass().getName() + " has a Base Area of: " + decimalFormat.format(calcBaseArea());
        } else return switch (comparetype) {
            case "v" -> "The " + getClass().getName() + " has a Volume of: " + decimalFormat.format(calcVolume());
            case "h" -> "The " + getClass().getName() + " has a Height of: " + getHeight();
            default -> "The " + getClass().getName() + " has a Base Area of: " + decimalFormat.format(calcBaseArea());
        };
    }

}
