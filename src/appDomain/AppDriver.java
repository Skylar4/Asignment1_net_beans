package appDomain;

import polygons.*;
import java.io.File;
<<<<<<< Updated upstream
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import sortClasses.bubbleSorter;
import utilities.Merge;
=======
import utilities.FileReader;
import utilities.mergeSorter;
import utilities.bubbleSorter;
import utilities.SelectionSorter;
import utilities.InsertionSorter;
import utilities.quickSorter;
>>>>>>> Stashed changes

public class AppDriver {

    public static void main(String[] args) {
        Shape[] shapes = null;

        //Command line arguments
//        String fileName = null;
//        String compareType = null;
//        String sortType = null;
        // Comment out to use command line; for testing only
<<<<<<< Updated upstream
        String fileName = "shapes3.txt";
        String compareType = "h";
        String sortType = "bubble";

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-f") || args[i].startsWith("-F")) {
                fileName = args[i].substring(2);
            } else if (args[i].startsWith("-t") || args[i].startsWith("-T")) {
                compareType = args[i].substring(2).toLowerCase();
            } else if (args[i].startsWith("-s") || args[i].startsWith("-S")) {
                sortType = args[i].substring(2).toLowerCase();
=======
        String fileName = "shapes4.txt";
        String compareType = "b";
        String sortType = "b";
        for (String arg : args) {
            if (arg.startsWith("-f") || arg.startsWith("-F")) {
                fileName = arg.substring(2);
            } else if (arg.startsWith("-t") || arg.startsWith("-T")) {
                compareType = arg.substring(2).toLowerCase();
            } else if (arg.startsWith("-s") || arg.startsWith("-S")) {
                sortType = arg.substring(2).toLowerCase();
>>>>>>> Stashed changes
            }
        }

        if (fileName == null || compareType == null || sortType == null) {
            System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<compare_type> -s<sort_type>");
            //return;
        }

<<<<<<< Updated upstream
        try {
            //creating the file class to be read
            int size;
            File txt = new File(fileName);
            //creatng the scanner to read the file
            Scanner scanner = new Scanner(txt);
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                size = Integer.parseInt(firstLine.trim());
                shapes = new Shape[size];
=======
        FileReader fr = new FileReader(txt);

        shapes = fr.CreateShapes();

        // Start counter
        long startTime, endTime;

        startTime = System.currentTimeMillis();

        if (null != sortType) // mergeSorter elements based on the compareBy type
        {
            switch (sortType) {
                case "m" -> {
                    System.out.println("Sorting by Merge Sort algorithm");
                    mergeSorter.sort(compareType, shapes);
                }
                case "b" -> {
                    System.out.println("Sorting by Bubble Sort algorithm");
                    bubbleSorter.sort(compareType, shapes);
                }
                case "s" -> {
                    System.out.println("Sorting by Selection Sort algorithm");
                    SelectionSorter.Sort(shapes, compareType);
                }
                case "i" -> {
                    System.out.println("Sorting by Insertion Sort algorithm");
                    InsertionSorter.insertionSort(shapes);
                }
                case "q" -> {
                    System.out.println("Sorting by Quick Sort algorithm");
                    quickSorter.sort(compareType, shapes);
                }
                default -> {
                }
>>>>>>> Stashed changes
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

        // Start counter
        long startTime = System.currentTimeMillis();

        // Merge elements based on the compare type 
        Shape[] sortedShape = null;
        if (sortType == "m") {
            Merge.mergeSort(compareType, shapes, 0, shapes.length - 1);
        }
        else if (sortType == "bubble")
        {
            bubbleSorter.bubbleSort(shapes);
        }

        // TODO: add more sorting algorithms here
        //End Counter
        long endTime = System.currentTimeMillis();

        System.out.println("");
        // print the elements
        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            if (i == 0) {
                System.out.println("First Element is: " + shape.toString(compareType));
            } else if (i == shapes.length - 2) {
                System.out.println("Second Last element is: " + shape.toString(compareType));
            } else if (i == shapes.length - 1) {
                System.out.println("Last element is: " + shape.toString(compareType));
            } else if (i % 1000 == 0) // update this for bigger test data; current using 10 for testing
            {
                System.out.println(i + "-th element is: " + shape.toString(compareType));
            }
        }

        System.out.println("b run time was: " + (endTime - startTime) + " milliseconds");

    }
}
