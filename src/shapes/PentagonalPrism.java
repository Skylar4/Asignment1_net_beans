package shapes;

public class PentagonalPrism extends Shape
{
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
    public double baseArea(){
        double angleInRadians = Math.toRadians(54); 
        double area = (5 * Math.pow(this.side, 2) * Math.tan(angleInRadians)) / 4; 
        return area; 
    }
    public double Volume(){
        double volume = this.baseArea() * this.height;
        return volume;
    }

}
