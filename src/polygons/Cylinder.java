package polygons;

import java.text.DecimalFormat;

public class Cylinder extends Shape {

    double radius;

    public Cylinder(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcBaseArea() {
        double basearea = Math.PI * Math.pow(this.radius, 2);
        return basearea;
    }

    @Override
    public double calcVolume() {
        double volume = (Math.PI * Math.pow(this.radius, 2) * this.height);
        return volume;
    }

    @Override
    public String toString(String comparetype) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        if (comparetype == "v") {
            return "The " + getClass().getName() + " has a Volume of: " + decimalFormat.format(calcVolume());
        } else if (comparetype == "h") {
            return "The " + getClass().getName() + " has a Height of: " + getHeight();
        } else {
            return "The " + getClass().getName() + " has a Base Area of: " + decimalFormat.format(calcBaseArea());
        }

    }
}
