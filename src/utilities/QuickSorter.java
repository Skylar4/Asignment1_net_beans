package utilities;

import java.util.Random;
import polygons.Shape;
import static utilities.ShapeComparator.compareBy;
import static utilities.ShapeComparator.swap;

/**
 * This class sorts the Polygons based on the compareBy type.
 * 
 * @author Marian Estrada
 */
public class QuickSorter<T extends Shape> {
    private String compareType;
    private T[] array;

    /**
     * @param compareType the type of comparison to be used
     * @param array the array of shapes to be sorted
     */
    public QuickSorter(String compareType, T[] array) {
        this.compareType = compareType;
        this.array = array;
    }

    /**
     * @param <T>
     * @param compareType
     * @param shapes
     */
    public static <T extends Shape> void sort(String compareType, T[] shapes) {
        quickSort(shapes, 0, shapes.length - 1, compareType);
    }

    private static <T extends Shape> void quickSort(T[] shapes, int lowIndex, int highIndex, String compareType) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex + 1) + lowIndex;
        T pivot = shapes[pivotIndex];
        swap(shapes, pivotIndex, highIndex);

        int leftPointer = partition(shapes, lowIndex, highIndex, pivot, compareType);

        quickSort(shapes, lowIndex, leftPointer - 1, compareType);
        quickSort(shapes, leftPointer + 1, highIndex, compareType);
    }

    private static <T extends Shape> int partition(T[] shapes, int lowIndex, int highIndex, T pivot, String compareType) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer <= rightPointer) {
            while (leftPointer <= rightPointer && compareBy(shapes[leftPointer], pivot, compareType) >= 0) { // Change to >= for descending order
                leftPointer++;
            }
            while (leftPointer <= rightPointer && compareBy(shapes[rightPointer], pivot, compareType) <= 0) { // Change to <= for descending order
                rightPointer--;
            }
            if (leftPointer < rightPointer) {
                swap(shapes, leftPointer, rightPointer);
            }
        }

        swap(shapes, leftPointer, highIndex);
        return leftPointer;
    }
}
