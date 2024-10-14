package polygons;

public class Cone extends Shape {

    double radius;

    public Cone(double radius, double height) {
        super(height);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double baseArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double Volume() {
        double volume = (Math.PI * Math.pow(this.radius, 2) * this.height) / 3;
        return volume;
    }

    @Override
    public String toString(String comparetype) {
        if (comparetype == "v") {
            return "The " + getClass().getName() + " has a Volume of: " + Volume();
        } else if (comparetype == "h") {
            return "The " + getClass().getName() + " has a Height of: " + getHeight();
        } else {
            return "The " + getClass().getName() + " has a Base Area of: " + baseArea();
        }

    }
}
