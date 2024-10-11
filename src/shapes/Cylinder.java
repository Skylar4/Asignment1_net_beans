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
    public double basearea(){
        return Math.PI *  Math.pow(this.radius, 2 );
    }
    public double Volume(){
        double volume = (Math.PI *  Math.pow(this.radius, 2 ) * this.height);
        return volume;
    }
}
