package polygons;

import java.text.DecimalFormat;

public class OctagonalPrism extends Shape {

    double side;

    public OctagonalPrism(double side, double height) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double calcBaseArea() {
        double area = 2 * (1 + Math.sqrt(2)) * Math.pow(this.side, 2);
        return area;
    }

    @Override
    public double calcVolume() {
        double volume = this.calcBaseArea() * this.height;
        return volume;
    }

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
