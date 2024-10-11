/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import java.util.Comparator;

/**
 *
 * @author jones
 */
public class ShapeComparator implements Comparator<Shape> {
    
    @ Override
    // will have to have some method of comparing by volume, base area, and
   //height can be done in the compareTo in the shape class 
    public int compare( Shape shape1 ,Shape shape2 ){
        return 1;       
    }
    
}
