/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortClasses;
import polygons.Shape;

/**
 *
 * @author benjaminmellott
 */

public class bubbleSorter 
{
    public static Shape[] bubbleSort(Shape[] shapesList)
    {
        int length = shapesList.length;
        for (int i = 0; i < length - 1; i++)
        {
            for (int j = 0; j < length - i - 1; j++)
            {
                if(shapesList[j].compareTo(shapesList[j + 1]) == 1)
                {
                    Shape temp = shapesList[j];
                    shapesList[j] = shapesList[j+1];
                    shapesList[j+1] = temp;
                }
            }
        }       
        return shapesList;
    }
    
}
