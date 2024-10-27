/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import polygons.Shape;

/**
 * This class sorts the Polygons array using the 
 * Bubble Sort algorithm based on the compare type.
 * 
 * @author benjaminmellott
 */

public class BubbleSorter<T extends Shape>
{
    private final String compareType;
    private final T[] array;
    
    public BubbleSorter(String compareType, T[] array)
    {
        this.compareType = compareType;
        this.array = array;
    }
    
    public void bubbleSort(T[] array)
    {
        int length = array.length;
        for (int i = 0; i < length - 1; i++)
        {
            for (int j = 0; j < length - i - 1; j++)
            {
                if(array[j].compareTo(array[j + 1]) == 1)
                {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    
    public static <T extends Shape> void sort(String compareType, T[] array)
    {
        BubbleSorter<T> sorter = new BubbleSorter<>(compareType, array);
        sorter.bubbleSort(array);
    }
    
    
}
