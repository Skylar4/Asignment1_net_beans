/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author jones
 */
public class SelectionSorter {
    
    
    
        public static <T extends Comparable<T>>  void selectionSort(T[] array){
        int length = array.length;
        //looping through each index in the array except the last one since its hopefully already in the right spot
        for (int i = 0; i < length -1; i++) {
            //small is assuming that the current index is the smallest number
            int small = i;
            //loop through the rest of the array and compare including the last element
            for (int n = i + 1; n  < length; n++) {
                //checking each element to see if it is smallest in the array
                if (array[n].compareTo(array[small]) < 0 ) {
                    small = n;
                }

            }
                T tmp = array[i];
                array[i] = array[small];
                array[small] = tmp;
        }
        
        
        
    }
}
