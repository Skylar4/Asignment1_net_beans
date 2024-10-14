/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.util.Arrays;
import java.util.Comparator;
import polygons.Shape;

/**
 *
 * @author Marian Estrada
 */
public abstract class Sort {

    public static <T extends Shape> Shape[] mergeSort(String comparetype, Shape[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(comparetype, array, left, mid);
            mergeSort(comparetype, array, mid + 1, right);
            merge(comparetype, array, left, mid, right);
        }

        return array;
    }

    private static <T extends Shape> void merge(String compareType, T[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArray = (T[]) new Shape[n1];
        T[] rightArray = (T[]) new Shape[n2];

        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);

        Comparator<Shape> comparator = getComparator(compareType);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static Comparator<Shape> getComparator(String compareType) {
        switch (compareType) {
            case "h":
                return Comparator.comparingDouble(Shape::getHeight);
            case "a":
                return Comparator.comparingDouble(Shape::calcBaseArea);
            case "v":
                return Comparator.comparingDouble(Shape::calcVolume);
            default:
                throw new IllegalArgumentException("Invalid compare type: " + compareType);
        }
    }
}
