/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import polygons.Shape;

/**
 * This class sorts the Polygons array using the Bubble Sort algorithm based on
 * the compare type.
 *
 * @author benjaminmellott
 * @param <T> extends Shape Class
 */
public class BubbleSorter<T extends Shape> {

    private final String compareType;
    private final T[] array;

    public BubbleSorter(String compareType, T[] array) {
        this.compareType = compareType;
        this.array = array;
    }

    public void bubbleSort(T[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (ShapeComparator.compareBy(array[j], array[j + 1], compareType) < 0) {
                    ShapeComparator.swap(array, j, j + 1);
                }
            }
        }
    }

    public static <T extends Shape> void sort(String compareType, T[] array) {
        BubbleSorter<T> sorter = new BubbleSorter<>(compareType, array);
        sorter.bubbleSort(array);
    }
}
