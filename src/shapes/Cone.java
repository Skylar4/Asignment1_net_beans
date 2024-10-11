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
        public double basearea(){
        return Math.PI *  Math.pow(this.radius, 2 );
    }
    public double Volume(){
        double volume = (Math.PI *  Math.pow(this.radius, 2 ) * this.height) / 3;
        return volume;
    }

}
