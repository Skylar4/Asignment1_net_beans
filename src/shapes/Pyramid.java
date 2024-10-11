package shapes;

public class Pyramid extends Shape
{
        double side;

    public Pyramid(double side, double height) {
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
