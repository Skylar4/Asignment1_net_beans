package polygons;

// import java.text.DecimalFormat; // This import was unused so commented it out.
// but is still here if we need it later.

public class TriangularPrism extends Shape 
{
    double side;

    public TriangularPrism(double side, double height) 
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
        double area = (Math.pow(this.side, 2) * Math.sqrt(3)) / 4;
        return area;
    }

    @Override
    public double calcVolume() 
    {
        double volume = this.calcBaseArea() * this.height;
        return volume;
    }

}
