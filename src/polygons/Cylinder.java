package polygons;

// import java.text.DecimalFormat; // This import was unused so commented it out.
// but is still here if we need it later.

public class Cylinder extends Shape 
{
    double radius;

    public Cylinder(double radius, double height) 
    {
        super(height);
        this.radius = radius;
    }

    public double getRadius() 
    {
        return radius;
    }

    public void setRadius(double radius) 
    {
        this.radius = radius;
    }

    @Override
    public double calcBaseArea() 
    {
        double basearea = Math.PI * Math.pow(this.radius, 2);
        return basearea;
    }

    @Override
    public double calcVolume() 
    {
        double volume = (Math.PI * Math.pow(this.radius, 2) * this.height);
        return volume;
    }
}
