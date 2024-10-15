package appDomain;
import shapes.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import utilities.*;


public class AppDriver {

    public static void main(String[] args) {
        Shape[] shapes = null;
        try {
            //creating the file class to be read
            int size;
            File txt = new File("shapes2.txt");
            //creatng the scanner to read the file
            Scanner scanner = new Scanner(txt);
                if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                size = Integer.parseInt(firstLine.trim()); 
                shapes = new Shape[size];
            }

                int index = 0;
            while (index < shapes.length && scanner.hasNextLine()) {
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
                        Cone cone = new Cone(coneradius,coneheight);
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
        for (Shape shap : shapes){
                        System.out.println(shap.getHeight());
        }
        SelectionSorter sorter = new SelectionSorter();
        sorter.selectionSort(shapes);

                for (Shape shap : shapes){
                        System.out.println(shap.getHeight());
        }

    }
}
