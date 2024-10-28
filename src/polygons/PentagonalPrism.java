package polygons;

// import java.text.DecimalFormat; // This import was unused so commented it out.
// but is still here if we need it later.

public class PentagonalPrism extends Shape 
{
    double side;

    public PentagonalPrism(double side, double height) 
    {
        super(height);
        this.side = side;
    }

    public double getSide() 
    {
        return side;
    }

    public void setSide(double side) 
    {
        this.side = side;
    }

    @Override
    public double calcBaseArea() 
    {
        double angleInRadians = Math.toRadians(54);
        double area = (5 * Math.pow(this.side, 2) * Math.tan(angleInRadians)) / 4;
        return area;
    }

    @Override
    public double calcVolume() 
    {
        double volume = this.calcBaseArea() * this.height;
        return volume;
    }
}
