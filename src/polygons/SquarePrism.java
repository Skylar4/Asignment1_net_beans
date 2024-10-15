package polygons;

import java.text.DecimalFormat;

public class SquarePrism extends Shape {

    double side;

    public SquarePrism(double side, double height) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double calcBaseArea() {
        return Math.pow(this.side, 2);

    }

    public double calcVolume() {
        double volume = (Math.pow(this.side, 2) * this.height);
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
