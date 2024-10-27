package polygons;

import java.text.DecimalFormat;

public class TriangularPrism extends Shape {

    double side;

    public TriangularPrism(double side, double height) {
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
        double area = (Math.pow(this.side, 2) * Math.sqrt(3)) / 4;
        return area;
    }

    public double calcVolume() {
        double volume = this.calcBaseArea() * this.height;
        return volume;
    }

}
