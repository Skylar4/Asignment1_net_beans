package polygons;

// import java.text.DecimalFormat; // This import was unused so commented it out.
// but is still here if we need it later.

public class SquarePrism extends Shape 
{
    double side;

    public SquarePrism(double side, double height) 
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
        return Math.pow(this.side, 2);

    }

    @Override
    public double calcVolume() 
    {
        double volume = (Math.pow(this.side, 2) * this.height);
        return volume;
    }

}
