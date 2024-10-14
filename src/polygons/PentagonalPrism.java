package polygons;

import java.text.DecimalFormat;

public class PentagonalPrism extends Shape {

    double side;

    public PentagonalPrism(double side, double height) {
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
        double angleInRadians = Math.toRadians(54);
        double area = (5 * Math.pow(this.side, 2) * Math.tan(angleInRadians)) / 4;
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
