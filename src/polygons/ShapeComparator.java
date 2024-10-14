/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polygons;

import java.util.Comparator;

/**
 *
 * @author jones, marian
 */
public class ShapeComparator implements Comparator<Shape> {
    private String compareType;

    public ShapeComparator(String compareType) {
        this.compareType = compareType;
    }
    
    // will have to have some method of comparing by volume, base area, and
   //height can be done in the compareTo in the shape class 
    @Override
    public int compare(Shape s1, Shape s2) {
        switch (compareType) {
            case "a":
                return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
            case "v":
                return Double.compare(s1.calcVolume(), s2.calcVolume());
            default:
                throw new IllegalArgumentException("Invalid compare type: " + compareType);
        }
    }
}

