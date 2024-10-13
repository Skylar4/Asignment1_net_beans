package shapes;

public class SquarePrism extends Shape
{
        double side;

    public SquarePrism(double side, double height) {
        super(height);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public double basearea(){
        return Math.pow(this.side, 2 );
        
    }
     public double Volume(){
        double volume = (Math.pow(this.side, 2 ) * this.height) ;
        return volume;   
}

}
