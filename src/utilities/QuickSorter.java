package utilities;

import java.util.Random;
import polygons.Shape;
import static utilities.ShapeComparator.compareBy;
import static utilities.ShapeComparator.swap;

/**
 * This class sorts the Polygons based on the compareBy type using Quick Sort algorithm.
 * 
 * @param <T> extends Shape Class
 */
public class QuickSorter<T extends Shape> {
    private final String compareType;
    private final T[] array;

    /**
     * @param compareType the type of comparison to be used
     * @param array the array of shapes to be sorted
     */
    public QuickSorter(String compareType, T[] array) {
        this.compareType = compareType;
        this.array = array;
    }

    /**
     * Sorts the array using quick sort algorithm.
     */
    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex + 1) + lowIndex;
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(lowIndex, highIndex, pivot);

        quickSort(lowIndex, leftPointer - 1);
        quickSort(leftPointer + 1, highIndex);
    }

    private int partition(int lowIndex, int highIndex, T pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer <= rightPointer) {
            while (leftPointer <= rightPointer && compareBy(array[leftPointer], pivot, compareType) >= 0) { // Change to >= for descending order
                leftPointer++;
            }
            while (leftPointer <= rightPointer && compareBy(array[rightPointer], pivot, compareType) <= 0) { // Change to <= for descending order
                rightPointer--;
            }
            if (leftPointer < rightPointer) {
                swap(array, leftPointer, rightPointer);
            }
        }

        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    /**
     * Static method to sort an array of shapes using quick sort.
     * 
     * @param <T> extends Shape
     * @param compareType the type of comparison to be used
     * @param array the array of shapes to be sorted
     */
    public static <T extends Shape> void sort(String compareType, T[] array) {
        QuickSorter<T> sorter = new QuickSorter<>(compareType, array);
        sorter.quickSort();
    }
}