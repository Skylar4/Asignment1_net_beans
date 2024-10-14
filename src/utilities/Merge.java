/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import polygons.Shape;
import polygons.ShapeComparator;
import java.util.Arrays;
import java.util.Comparator;

public class Merge {

    public static <T extends Shape> void mergeSort(String compareType, T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(compareType, array, left, mid);
            mergeSort(compareType, array, mid + 1, right);

            //mrege the sorted subarray
            merge(compareType, array, left, mid, right);
        }
    }

    private static <T extends Shape> void merge(String compareType, T[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            int comparisonResult;
            
            if ("h".equals(compareType)) {
                comparisonResult = leftArray[i].compareTo(rightArray[j]);
            } else {
                ShapeComparator comparator = new ShapeComparator(compareType);
                comparisonResult = comparator.compare(leftArray[i], rightArray[j]);
            }

            // Compare the result to 0 to determine the order
            if (comparisonResult <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from leftArray
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements from rightArray
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
