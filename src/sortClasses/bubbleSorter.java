/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortClasses;
import polygons.Shape;

import polygons.Shape;
import static utilities.ShapeComparator.compareBy;
import java.util.Arrays;

/**
 *
 * @author benjaminmellott
 */

<<<<<<< Updated upstream:src/sortClasses/bubbleSorter.java
public class bubbleSorter 
{
    public static Shape[] bubbleSort(Shape[] shapesList)
=======
public class bubbleSorter<T extends Shape>
{
    public String compareType;
    private T[] array;
    
    public bubbleSorter(String compareType, T[] array)
>>>>>>> Stashed changes:src/utilities/bubbleSorter.java
    {
        this.compareType = compareType;
        this.array = array;
    }
    
    public T[] bubbleSort(T[] array)
    {
        int length = array.length;
        for (int i = 0; i < length - 1; i++)
        {
            for (int j = 0; j < length - i - 1; j++)
            {
                if(array[j].compareTo(array[j + 1]) == 1)
                {
<<<<<<< Updated upstream:src/sortClasses/bubbleSorter.java
                    Shape temp = shapesList[j];
                    shapesList[j] = shapesList[j+1];
                    shapesList[j+1] = temp;
                }
            }
        }       
        return shapesList;
=======
                    ShapeComparator.swap(array, j, j+1);
                }
            }
        }
        return array;
>>>>>>> Stashed changes:src/utilities/bubbleSorter.java
    }
    
    public static <T extends Shape> void sort(String compareType, T[] array)
    {
        bubbleSorter<T> sorter = new bubbleSorter<T>(compareType, array);
        sorter.bubbleSort(array);
    }
    
//    public static <T extends Comparable<T>>  void bubbleSort(String compareType, T[] shapesList)
//    {
//        int length = shapesList.length;
//        for (int i = 0; i < length - 1; i++)
//        {
//            for (int j = 0; j < length - i - 1; j++)
//            {
//                if(shapesList[j].compareTo(shapesList[j + 1]) == 1)
//                {
//                    ShapeComparator.swap(shapesList, j, j+1);
//                }
//            }
//        }       
//    }
    
}
