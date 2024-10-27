package utilities;

import polygons.Shape;
import java.util.Arrays;

public class RadixSorter<T extends Shape> 
{
    private final String compareType;
    private final T[] array;

    public RadixSorter(String compareType, T[] array) 
    {
        this.compareType = compareType;
        this.array = array;
    }
    
    private double getMaximum(T[] arr, int n) {
        double max = arr[0].getComparableValue(compareType);
        for (int i = 1; i < n; i++) {
            double value = arr[i].getComparableValue(compareType);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private void sortCounter(T[] arr, int n, int exp) {
        T[] output = Arrays.copyOf(arr, n);
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            int value = (int)((arr[i].getComparableValue(compareType) * 100) / exp) % 10;
            count[value]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int value = (int)((arr[i].getComparableValue(compareType) * 100) / exp) % 10;
            output[count[value] - 1] = arr[i];
            count[value]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public void radixSort(T[] array) 
    {
        int n = array.length;
        double m = getMaximum(array, n);

        // Convert the maximum double value to an integer by shifting decimal points
        for (int exp = 1; (int)(m * 100) / exp > 0; exp *= 10) {
            sortCounter(array, n, exp);
        }
    }

    public static <T extends Shape> void sort(String compareType, T[] array) 
    {
        RadixSorter<T> sorter = new RadixSorter<>(compareType, array);
        sorter.radixSort(array);
    }
}
