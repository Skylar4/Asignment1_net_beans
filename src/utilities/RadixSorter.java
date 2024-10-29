package utilities;

import java.math.BigInteger;
import java.util.Arrays;
import polygons.Shape;

/**
 *
 * @author benjaminmellott
 * @param <T> the type of shapes to be sorted extending from the Shape class
 */
public class RadixSorter<T extends Shape> {

    private final String compareType;
    private final Shape[] array;

    /**
     *
     * @param <T>
     * @param compareType the type of comparison being done (height, volume,
     * area)
     * @param array the array of shapes to be sorted
     */
    public <T extends Shape> RadixSorter(String compareType, T[] array) {
        this.compareType = compareType;
        this.array = array;
    }

    private <T extends Shape> double getMaximum(T[] arr, int n) {

        double max = arr[0].getComparableValue(compareType);
        for (int i = 1; i < n; i++) {
            double value = arr[i].getComparableValue(compareType);
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    private <T extends Shape> void sortCounter(T[] arr, int n, BigInteger exp) {
        Shape[] output = new Shape[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Count occurrences of each digit in the current range
        for (int i = 0; i < n; i++) {
            BigInteger value = BigInteger.valueOf((long) (arr[i].getComparableValue(compareType) * 100));
            int digit = value.divide(exp).mod(BigInteger.TEN).intValue();
            count[digit]++;
        }

        // Modify the count array to accumulate counts from end to beginning for descending order
        for (int i = 8; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // Fill the output array with the actual shapes in descending order
        for (int i = n - 1; i >= 0; i--) {
            BigInteger value = BigInteger.valueOf((long) (arr[i].getComparableValue(compareType) * 100));
            int digit = value.divide(exp).mod(BigInteger.TEN).intValue();
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     *
     * @param <T>
     * @param array the array that is to be sorted
     */
    public <T extends Shape> void radixSort(T[] array) {
        int n = array.length;
        double m = getMaximum(array, n);

        // Perform counting sort for every digit. Note that exp is 10^i where i is the current digit number
        for (BigInteger exp = BigInteger.ONE; BigInteger.valueOf((long) (m * 100)).divide(exp).compareTo(BigInteger.ZERO) > 0; exp = exp.multiply(BigInteger.TEN)) {
            sortCounter(array, n, exp);
        }
    }

    /**
     *
     * @param <T> the data type must extend the Shape class
     * @param compareType the compare type specified by the user (height, area,
     * volume)
     * @param array the array to be sorted
     */
    public static <T extends Shape> void sort(String compareType, T[] array) {
        RadixSorter<T> sorter = new RadixSorter<>(compareType, array);
        sorter.radixSort(array);
    }
}
