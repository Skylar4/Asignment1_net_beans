package shapes;

public class Cone extends Shape
{
    double radius;

    public Cone( double radius, double height) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
