package appDomain;

import polygons.*;
import java.io.File;
import utilities.FileReader;
import utilities.MergeSorter;
import utilities.BubbleSorter;
import utilities.SelectionSorter;
import utilities.InsertionSorter;
import utilities.QuickSorter;

public class AppDriver {

    public static void main(String[] args) {
        Shape[] shapes;
        int interval = 1000; //denominator to display every nth element in the result output

        //Command line arguments
        String fileName = null;
        String compareType = null;
        String sortType = null;

        // Comment out to use command line; for testing only
//        String fileName = "shapes2.txt";
//        String compareType = "a";
//        String sortType = "selection";
        for (String arg : args) {
            if (arg.startsWith("-f") || arg.startsWith("-F")) {
                fileName = arg.substring(2);
            } else if (arg.startsWith("-t") || arg.startsWith("-T")) {
                compareType = arg.substring(2).toLowerCase();
            } else if (arg.startsWith("-s") || arg.startsWith("-S")) {
                sortType = arg.substring(2).toLowerCase();
            }
        }

        System.out.println("Filename " + fileName + "; Compare By " + compareType + "; Sort Type: " + sortType);

        if (fileName == null || compareType == null || sortType == null) {
            System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<compare_type> -s<sort_type>");
            //return;
        }
        //creating the file class to be read
        File txt = new File(fileName);

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
                    MergeSorter.sort(compareType, shapes);
                }
                case "b" -> {
                    System.out.println("Sorting by Bubble Sort algorithm");
                    BubbleSorter.BubbleSorter(shapes);
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
                    QuickSorter.sort(compareType, shapes);
                }
                default -> {
                }
            }
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
            } else if (i % interval == 0) 
            {
                System.out.println(i + "-th element is: " + shape.toString(compareType));
            }
        }

        //End Counter
        endTime = System.currentTimeMillis();

        System.out.println("run time was: " + (endTime - startTime) + " milliseconds");

    }
}
