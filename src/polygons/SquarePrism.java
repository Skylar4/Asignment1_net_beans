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

}
