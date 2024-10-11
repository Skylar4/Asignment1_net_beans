package shapes;

public class TriangularPrism extends Shape
{
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
}
