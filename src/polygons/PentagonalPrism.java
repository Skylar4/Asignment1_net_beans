package polygons;

public class PentagonalPrism extends Shape {

    double side;

    public PentagonalPrism(double side, double height) {
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
        double angleInRadians = Math.toRadians(54);
        double area = (5 * Math.pow(this.side, 2) * Math.tan(angleInRadians)) / 4;
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
