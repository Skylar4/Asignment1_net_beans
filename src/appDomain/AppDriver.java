package appDomain;

import polygons.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import utilities.FileReader;
import utilities.mergeSorter;
import utilities.bubbleSorter;
import utilities.SelectionSorter;
import utilities.insertionSort;
import utilities.quickSorter;

public class AppDriver {

    public static void main(String[] args) {
        Shape[] shapes = null;

        //Command line arguments
        String fileName ="shapes2.txt";
        String compareType = "h";
        String sortType = "selection";
        
        // Comment out to use command line; for testing only
//        String fileName = "shapes3.txt";
//        String compareType = "m";
//        String sortType = "insertion";

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-f") || args[i].startsWith("-F")) {
                fileName = args[i].substring(2);
            } else if (args[i].startsWith("-t") || args[i].startsWith("-T")) {
                compareType = args[i].substring(2).toLowerCase();
            } else if (args[i].startsWith("-s") || args[i].startsWith("-S")) {
                sortType = args[i].substring(2).toLowerCase();
            }
        }

        if (fileName == null || compareType == null || sortType == null) {
            System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<compare_type> -s<sort_type>");
            //return;
        }
            //creating the file class to be read
            int size;
            
            File txt = new File(fileName);
            //creatng the scanner to read the file
            
            FileReader fr = new FileReader(txt);
            
            shapes = fr.CreateShapes();

            

        // Start counter
        long startTime, endTime;

        startTime = System.currentTimeMillis();

        // mergeSorter elements based on the compareBy type 

        if (sortType == "m") {
            mergeSorter.sort(compareType, shapes);
        } else if (sortType == "bubble") {
            bubbleSorter.bubbleSort(shapes);
        } else if (sortType == "selection") {   
            SelectionSorter.Sort(shapes, compareType);
        } else if (sortType == "insertion") {
            insertionSort.insertionSort(shapes);
        } else if (sortType == "q") {
            quickSorter.sort(compareType, shapes);
        }

        
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

        //End Counter
        endTime = System.currentTimeMillis();

        System.out.println("run time was: " + (endTime - startTime) + " milliseconds");

    }
}
