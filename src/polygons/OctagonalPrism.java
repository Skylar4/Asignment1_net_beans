package polygons;

public class OctagonalPrism extends Shape {

    double side;

    public OctagonalPrism(double side, double height) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double baseArea() {
        double area = 2 * (1 + Math.sqrt(2)) * Math.pow(this.side, 2);
        return area;
    }

    public double Volume() {
        double volume = this.baseArea() * this.height;
        return volume;
    }

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
