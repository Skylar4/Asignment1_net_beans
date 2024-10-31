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
        double value1 = 0;
        double value2 = 0;

        switch (compareType) {
            case "a":
                value1 = s1.calcBaseArea();
                value2 = s2.calcBaseArea();

            case "v":
                value1 = s1.calcVolume();
                value2 = s2.calcVolume();
        }

        return Double.compare(value1, value2);
    }

    public static <T extends Shape> void swap(T[] shapes, int index1, int index2) {
        T temp = shapes[index1];
        shapes[index1] = shapes[index2];
        shapes[index2] = temp;
    }

    public static <T extends Shape> int compareBy(T shape1, T shape2, String compareType) {
        int comparisonResult;
        if ("h".equals(compareType.toLowerCase())) {
            comparisonResult = shape1.compareTo(shape2);
        } else {
            ShapeComparator comparator = new ShapeComparator(compareType.toLowerCase());
            comparisonResult = comparator.compare(shape1, shape2);
        }
        return comparisonResult;
    }
}
