package shapes;

public class Pyramid extends Shape
{
        double side;

    public Pyramid(double side, double height) {
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
        return Math.pow(this.side, 2 );
    }
     public double Volume(){
        double volume = (Math.pow(this.side, 2 ) * this.height) / 3;
        return volume;   
     }
}
