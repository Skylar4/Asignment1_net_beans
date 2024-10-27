/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import polygons.Shape;

/**
 * This class sorts using insertion the Polygons based on the compare type.
 * 
 * @author robin
 */
public class InsertionSorter {
       
            
    public static <T extends Shape> void sort(T[] array){
        
        int arraySize = array.length;
        
        for (int i = 1; i < arraySize; i++){
                int index = i ;
                for (int j = i -1; j >= 0; j--){
                    if (array[index].compareTo(array[j])<0){
                    T temp = array[index];
                    array[index] = array[j];
                    array[j] = temp;
                    index = j;
                    }else{
                        break;
                    }
                }
        
    }
    }     
}
