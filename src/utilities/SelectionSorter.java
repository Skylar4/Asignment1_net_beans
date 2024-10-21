/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;
import polygons.*;
/**
 * This class implements the selection sort algorithm to sort arrays. 
 * The selection sort method shifts elements one by one until the array is sorted.
 * It provides sorting for any type that implements Comparable and specific sorting 
 * methods for shapes based on volume and area.
 * 
 * @author jones
 */
public class SelectionSorter {
    
/**
 * Sorts an array in ascending order using the selection sort algorithm. 
 * This method can sort any array as long as its elements implement 
 * the Comparable interface.
 *
 * @param <T>   the type of elements in the array, which must implement Comparable
 * @param array the array to be sorted, can be of any type that extends Comparable
 */
    public static <T extends Comparable<T>>  void selectionSort(T[] array){
        int length = array.length;
        //looping through each index in the array except the last one since its hopefully already in the right spot
        for (int i = 0; i < length -1; i++) {
            //small is assuming that the current index is the smallest number
            int small = i;
            //loop through the rest of the array and compare including the last element
            for (int n = i + 1; n  < length; n++) {
                //checking each element to see if it is smallest in the array
                if (array[n].compareTo(array[small]) > 0 ) {
                    small = n;
                }
            }
                T tmp = array[i];
                array[i] = array[small];
                array[small] = tmp;
        }
            
    }

    /**
     * Sorts an array of Shape objects by their volume using the selection sort algorithm.
     *
     * @param array an array of Shape objects to be sorted by volume
     */
    public static  void selectionSortVolume(Shape[] array){
        int length = array.length;
        ShapeComparator volumecomp = new ShapeComparator("v");
        //looping through each index in the array except the last one since its hopefully already in the right spot
        for (int i = 0; i < length -1; i++) {
            //small is assuming that the current index is the smallest number
            int small = i;
            //loop through the rest of the array and compare including the last element
            for (int n = i + 1; n  < length; n++) {
                //checking each element to see if it is smallest in the array
                if (volumecomp.compare(array[n], array[small]) > 0 ) {
                    small = n;
                }

            }
                Shape tmp = array[i];
                array[i] = array[small];
                array[small] = tmp;
        }
            
    }
    /**
     * Sorts an array of Shape objects by their area using the selection sort algorithm.
     *
     * @param array an array of Shape objects to be sorted by area
     */
    public static  void selectionSortArea(Shape[] array){
        int length = array.length;
        ShapeComparator volumecomp = new ShapeComparator("a");
        //looping through each index in the array except the last one since its hopefully already in the right spot
        for (int i = 0; i < length -1; i++) {
            //small is assuming that the current index is the smallest number
            int small = i;
            //loop through the rest of the array and compare including the last element
            for (int n = i + 1; n  < length; n++) {
                //checking each element to see if it is largest in the array
                if (volumecomp.compare(array[n], array[small]) > 0 ) {
                    small = n;
                }
            }
            //swap the largest shape with the current shape 
                Shape tmp = array[i];
                array[i] = array[small];
                array[small] = tmp;
        }
            
    }
}
