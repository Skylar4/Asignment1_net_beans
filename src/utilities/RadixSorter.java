package utilities;

import polygons.Shape;
import java.util.Arrays;

/**
 *
 * @author  benjaminmellott
 * @param <T> the type of shapes to be sorted extending from the Shape class 
 */
public class RadixSorter<T extends Shape> 
{
    private final String compareType;
    private final T[] array;

    /**
     *
     * @param compareType the type of comparison being done ( height , volume, area)
     * @param array the array of shapes to be sorted
     */
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

    private <T extends Shape> void sortCounter(T[] arr, int n, int exp) {
        Shape[] output = new Shape[n];
        //creates an array to hold the digits 0-9
        int[] count = new int[10];
        //fills the array with 0's
        Arrays.fill(count, 0);
        
        //count occurances of each digit in the current range, 1's ,10;s ,100s etc
        for (int i = 0; i < n; i++) {
            //getting the value of the digit
            int value = (int) (arr[i].getComparableValue(compareType) / exp) % 10;
            // increases the count of the specified digit by 1 
            count[value]++;
        }
        //counting the total number from end to begining
        for (int i = 8; i >= 0; i--) 
        {
            count[i] += count[i + 1];
        }
        
        //filling the output array with the actual shapes in the spots indicated by the count array
        for (int i = n - 1; i >= 0; i--) {
            //again getting the number at the current digit
            int value = (int)((arr[i].getComparableValue(compareType)) / exp) % 10;
            //put the shape into the output array at the spots indicated by the count array
            output[count[value] - 1] = arr[i];
            //deceease the value to ensure the next shape is placed next to it
            count[value]--;
        }
        // copy the output array to the origional array 
        System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     *
     * @param array  the array that is to be sorted 
     */
    public void radixSort(T[] array) 
    {
        int n = array.length;
        double m = getMaximum(array, n);

        // Convert the maximum double value to an integer by shifting decimal points
        for (int exp = 1; (int)(m * 100) / exp > 0; exp *= 10) {
            sortCounter(array, n, exp);
        }
    }

    /**
     *
     * @param <T> the data type must extend the Shape class 
     * @param compareType the compare type specified by the user (height, area, volume
     * @param array the array to be sorted 
     */
    public static <T extends Shape> void sort(String compareType, T[] array) 
    {
        RadixSorter<T> sorter = new RadixSorter<>(compareType, array);
        sorter.radixSort(array);
    }
}
