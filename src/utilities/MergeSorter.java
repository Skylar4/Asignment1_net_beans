package utilities;

import polygons.Shape;
import static utilities.ShapeComparator.compareBy;
import java.util.Arrays;

/**
 * This class sorts the Polygons based on the compare type.
 * 
 * @param <T> extends Shape Class
 */
public class MergeSorter<T extends Shape> {
    private final String compareType;
    private final T[] array;

    /**
     * @param compareType the type of comparison to be used
     * @param array the array of shapes to be sorted
     */
    public MergeSorter(String compareType, T[] array) {
        this.compareType = compareType;
        this.array = array;
    }

    /**
     * Sorts the array using merge sort algorithm.
     */
    public void mergeSort() {
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        T[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (compareBy(leftArray[i], rightArray[j], compareType) >= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * Static method to sort an array of shapes using merge sort.
     * 
     * @param <T> extends Shape
     * @param compareType the type of comparison to be used
     * @param array the array of shapes to be sorted
     */
    public static <T extends Shape> void sort(String compareType, T[] array) {
        MergeSorter<T> sorter = new MergeSorter<>(compareType, array);
        sorter.mergeSort();
    }
}