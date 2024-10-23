package utilities;

import polygons.Shape;
import static utilities.ShapeComparator.compareBy;
import java.util.Arrays;

/**
 * This class sorts the Polygons based on the compare type.
 * 
 * @author Marian Estrada
 */
public class mergeSorter<T extends Shape> {

    private String compareType;
    private T[] array;

    /**
     *
     * @param compareType the type of comparison to be used
     * @param array the array of shapes to be sorted
     */
    public mergeSorter(String compareType, T[] array) {
        this.compareType = compareType;
        this.array = array;
    }

    /**
     *
     * @param left
     * @param right
     */
    public void mergeSort(int left, int right) {
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

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            int comparisonResult = compareBy(leftArray[i], rightArray[j], compareType);

            if (comparisonResult <= 0) {
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

    /**
     *
     * @param <T>
     * @param compareType
     * @param array
     */
    public static <T extends Shape> void sort(String compareType, T[] array) {
        mergeSorter<T> sorter = new mergeSorter<>(compareType, array);
        sorter.mergeSort(0, array.length - 1);
    }
}
