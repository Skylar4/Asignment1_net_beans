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

    public double calcVolume() {
        return 0.00;
    }

    public double calcBaseArea() {
        return 0.00;
    }

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

<<<<<<< Updated upstream
        if (comparetype == "v") {
            return "The " + getClass().getName() + " has a Volume of: " + decimalFormat.format(calcVolume());
        } else if (comparetype == "h") {
            return "The " + getClass().getName() + " has a Height of: " + getHeight();
        } else {
            return "The " + getClass().getName() + " has a Base Area of: " + decimalFormat.format(calcBaseArea());
        }

=======
        if (null == comparetype) {
            return "This is not a valid compare type. Please try again with a valid compare type";
        } else return switch (comparetype) {
            case "v" -> "The " + getClass().getName() + " has a Volume of: " + decimalFormat.format(calcVolume());
            case "h" -> "The " + getClass().getName() + " has a Height of: " + getHeight();
            case "a" -> "The " + getClass().getName() + " has a Base Are of: " + decimalFormat.format(calcBaseArea());
            default -> "This is not a valid compare type. Please try again with a valid compare type"
                   + "\nV --> Volume"
                   + "\nH --> Height"
                   + "\nA --> Base Area";
        };
>>>>>>> Stashed changes
    }

}
