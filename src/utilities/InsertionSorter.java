/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import polygons.Shape;
import static utilities.ShapeComparator.compareBy;
import static utilities.ShapeComparator.swap;

/**
 * This class sorts using insertion the Polygons based on the compare type.
 *
 * @author robin
 */
public class InsertionSorter {

    public static <T extends Shape> void sort(T[] array, String compareType) {
        int arraySize = array.length;

        for (int i = 1; i < arraySize; i++) {
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (compareBy(array[index], array[j], compareType) > 0) {
                    swap(array, index, j);
                    index = j;
                }
            }
        }
    }
}
