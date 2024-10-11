package shapes;

public class Cylinder extends Shape
{
        double radius;

    public Cylinder( double radius, double height) {
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
