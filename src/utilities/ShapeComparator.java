/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.Comparator;
import polygons.Shape;

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
                double baseArea1 = s1.calcBaseArea();
                double baseArea2 = s2.calcBaseArea();
                return Double.compare(baseArea1, baseArea2);
            case "v":
                double volume1 = s1.calcVolume();
                double volume2 = s2.calcVolume();
                return Double.compare(volume1, volume2);
            default:
                return 0;
        }
    }

    public static <T extends Shape> int compareBy(T shape1, T shape2, String compareType) {
        int comparisonResult;
        if ("h".equals(compareType)) {
            comparisonResult = shape1.compareTo(shape2);
        } else {
            ShapeComparator comparator = new ShapeComparator(compareType);
            comparisonResult = comparator.compare(shape1, shape2);
        }
        return comparisonResult;
    }
}
