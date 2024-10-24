/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import polygons.*;

/**
 *
 * @author jones
 */
public class FileReader {
    
    private File file = null;

    public FileReader(File file) {
        this.file = file;
        
    }
    
    public  Shape[] CreateShapes(){
           Shape[] shapes = null;
           try {
           Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
               int size = Integer.parseInt(firstLine.trim());
                shapes = new Shape[size];
            }
                 int index = 0;
                while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                //setting the delimter to be a space
                String delim = "[ ]";
                String[] shape = data.split(delim);
                //getting the first digit to know what kind of appliance to make. 
                String shapeType = shape[0];
                switch (shapeType) {
                    //for each shape type have the constructors, simmilar to the appliance assignment. 
                    case "Cone":
                        double coneheight = Double.parseDouble(shape[1]);
                        double coneradius = Double.parseDouble(shape[2]);
                        Cone cone = new Cone(coneradius, coneheight);
                        shapes[index] = cone;
                        break;

                    case "Cylinder":
                        double CylHeight = Double.parseDouble(shape[1]);
                        double CylRadius = Double.parseDouble(shape[2]);
                        Cylinder cylinder = new Cylinder(CylRadius, CylHeight);
                        shapes[index] = cylinder;
                        break;

                    case "Pyramid":
                        double pyrHeight = Double.parseDouble(shape[1]);
                        double PyrSide = Double.parseDouble(shape[2]);
                        Pyramid pyramid = new Pyramid(PyrSide, pyrHeight);
                        shapes[index] = pyramid;
                        break;

                    case "OctagonalPrism":
                        double OctHeight = Double.parseDouble(shape[1]);
                        double OctSide = Double.parseDouble(shape[2]);
                        OctagonalPrism octogonalPrism = new OctagonalPrism(OctSide, OctHeight);
                        shapes[index] = octogonalPrism;
                        break;

                    case "SquarePrism":
                        double squareHeight = Double.parseDouble(shape[1]);
                        double squareSide = Double.parseDouble(shape[2]);
                        SquarePrism squarePrism = new SquarePrism(squareSide, squareHeight);
                        shapes[index] = squarePrism;

                        break;

                    case "TriangularPrism":
                        double triangleBaseLength = Double.parseDouble(shape[1]);
                        double triangleHeight = Double.parseDouble(shape[2]);
                        TriangularPrism triangularPrism = new TriangularPrism(triangleBaseLength, triangleHeight);
                        shapes[index] = triangularPrism;

                        break;

                    case "PentagonalPrism":
                        double pentagonBaseLength = Double.parseDouble(shape[1]);
                        double pentagonHeight = Double.parseDouble(shape[2]);
                        PentagonalPrism pentagonalPrism = new PentagonalPrism(pentagonBaseLength, pentagonHeight);
                        shapes[index] = pentagonalPrism;
                        break;
                    default:
                        System.out.println("Unrecognized shape type: " + shapeType);
                        break;
                }
                index++;

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return shapes;
        
    }
    
    
}
