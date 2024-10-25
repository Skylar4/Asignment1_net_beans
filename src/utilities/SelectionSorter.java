/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import polygons.*;
import static utilities.ShapeComparator.compareBy;

/**
 * This class implements the selection sort algorithm to sort arrays. The
 * selection sort method shifts elements one by one until the array is sorted.
 * It provides sorting for any type that implements Comparable and specific
 * sorting methods for shapes based on volume and area.
 *
 * @author jones
 */
public class SelectionSorter <T extends Comparable<T>> {

    Shape[] array;
    String Comparetype;

    public SelectionSorter(Shape[] array) {
        this.array = array;
        this.Comparetype = null;

    }

    public SelectionSorter(Shape[] array, String Comparetype) {
        this.array = array;
        this.Comparetype = Comparetype;
    }

    /**
     * Sorts an array in ascending order using the selection sort algorithm.
     * This method can sort any array as long as its elements implement the
     * Comparable interface.
     *
     * @param <T> the type of elements in the array, which must implement
     * Comparable
     * @param array the array to be sorted, can be of any type that extends
     * Comparable
     */
    public static <T extends Comparable<T>> void Sort(Shape[] data, String comparetype) {
        SelectionSorter ss = new SelectionSorter(data, comparetype);
        ss.selectionSort();
    }

    /**
     * Sorts an array of Shape objects by their volume using the selection sort
     * algorithm.
     *
     * @param array an array of Shape objects to be sorted by volume
     */
    public void selectionSort() {
        int length = array.length;
        if (Comparetype.equals("h") || Comparetype == null) {
            for (int i = 0; i < length - 1; i++) {
                //large is assuming that the current index is the largest number
                int large = i;
                //loop through the rest of the array and compare including the last element
                for (int n = i + 1; n < length; n++) {
                    //checking each element to see if it is largest  in the array
                    if (array[n].compareTo(array[large]) > 0) {
                        large = n;
                    }
                }
                   Shape temp = array[i];
                   array[i] = array[large];
                   array[large] = temp;
                
            }
        }
        else 
        {
                        for (int i = 0; i < length - 1; i++) {
                //large is assuming that the current index is the largest number
                int large= i;
                //loop through the rest of the array and compare including the last element
                for (int n = i + 1; n < length; n++) {
                    //checking each element to see if it is largest in the array
                    if (compareBy(array[n],array[large], Comparetype)  > 0) {
                        large = n;
                    }
                }
                   Shape temp = array[i];
                   array[i] = array[large];
                   array[large] = temp;
                
            }
        
        
        }
    }
}
