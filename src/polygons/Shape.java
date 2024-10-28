/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polygons;

import java.text.DecimalFormat;

/**
 *
 * @author jones
 */
public abstract class Shape implements Comparable<Shape> 
{
    double height;

    public Shape(double height) 
    {
        this.height = height;
    }

    public abstract double calcVolume();

    public abstract double calcBaseArea();

    public double getHeight() 
    {
        return height;
    }

    public void setHeight(double height) 
    {
        this.height = height;
    }
    
    public double getComparableValue(String compareType) 
    {
        switch (compareType.toLowerCase()) 
        {
            case "a" -> 
            {
                return this.calcBaseArea();
            }
            case "v" -> 
            {
                return this.calcVolume();
            }
            case "h" -> 
            {
                return this.height;
            }
            default -> throw new IllegalArgumentException("Invalid compare type: " + compareType);
        }
    }
    
    public int Compare2 (Shape shape, String compareType)
    {
        switch (compareType.toLowerCase()) 
        {
            case "a" -> 
            {
                if (this.calcBaseArea() > shape.calcBaseArea()) 
                {
                    return 1;
                } 
                else if (this.calcBaseArea() < shape.calcBaseArea()) 
                {
                    return -1;
                } 
                else 
                {
                    return 0;
                }
            }
            case "v" -> 
            {
                if (this.calcVolume() > shape.calcVolume()) 
                {
                    return 1;
                } 
                else if (this.calcVolume() < shape.calcVolume()) 
                {
                    return -1;
                } 
                else 
                {
                    return 0;
                }
            }
            case "h" -> 
            {
                if (this.getHeight() > shape.getHeight()) 
                {
                    return 1;
                } 
                else if (this.getHeight() < shape.getHeight()) 
                {
                    return -1;
                } 
                else 
                {
                    return 0;
                }
            }
            default -> throw new IllegalArgumentException("Invalid compare type: " + compareType);
        }
    }

    @Override
    public int compareTo(Shape shape2) 
    {
        if (this.getHeight() > shape2.getHeight()) 
        {
            return 1;
        } 
        else if (this.getHeight() < shape2.getHeight()) 
        {
            return -1;
        } 
        else 
        {
            return 0;
        }
    }

    public String toString(String comparetype) 
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        if (null == comparetype) 
        {
            return "This is not a valid parameter to sort by, Please try again!";
        } 
        else return switch (comparetype) 
        {
            case "v" -> "The " + getClass().getName() + " has a Volume of: " + decimalFormat.format(calcVolume());
            case "h" -> "The " + getClass().getName() + " has a Height of: " + getHeight();
            case "a" -> "The " + getClass().getName() + " has a Base Area of: " + decimalFormat.format(calcBaseArea());
            default -> "This is not a valid parameter to sort by, Please try again!";
        };
    }
}
