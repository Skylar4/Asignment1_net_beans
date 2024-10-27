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

    private static final String FILE_PREFIX = "-f";
    private static final String COMPARE_PREFIX = "-t";
    private static final String SORT_PREFIX = "-s";
    private static final int INTERVAL = 1000;

    public static void main(String[] args) {
        String fileName = null;
        String compareType = null;
        String sortType = null;

        // Comment out to use command line; for testing only
//        fileName = "shapes2.txt";
//        compareType = "a";
//        sortType = "selection";

        String[] parsedArgs = parseArguments(args);
        fileName = parsedArgs[0];
        compareType = parsedArgs[1];
        sortType = parsedArgs[2];

        System.out.println("Filename " + fileName + "; Compare By " + compareType + "; Sort Type: " + sortType);

        if (fileName == null || compareType == null || sortType == null) {
            System.out.println("Usage: java -jar Sort.jar -f<file_name> -t<compare_type> -s<sort_type>");
            return;
        }

        File txt = new File(fileName);
        FileReader fr = new FileReader(txt);
        Shape[] shapes = fr.CreateShapes();

        long startTime = System.currentTimeMillis();
        sortShapes(sortType, compareType, shapes);
        long endTime = System.currentTimeMillis();

        printShapes(shapes, compareType);
        System.out.println("run time was: " + (endTime - startTime) + " milliseconds");
    }

    private static String[] parseArguments(String[] args) {
        String fileName = null;
        String compareType = null;
        String sortType = null;

        for (String arg : args) {
            if (arg.startsWith(FILE_PREFIX)) {
                fileName = arg.substring(FILE_PREFIX.length());
            } else if (arg.startsWith(COMPARE_PREFIX)) {
                compareType = arg.substring(COMPARE_PREFIX.length()).toLowerCase();
            } else if (arg.startsWith(SORT_PREFIX)) {
                sortType = arg.substring(SORT_PREFIX.length()).toLowerCase();
            }
        }
        return new String[]{fileName, compareType, sortType};
    }

    private static void sortShapes(String sortType, String compareType, Shape[] shapes) {
        switch (sortType) {
            case "m" -> {
                System.out.println("Sorting by Merge Sort algorithm");
                MergeSorter.sort(compareType, shapes);
            }
            case "b" -> {
                System.out.println("Sorting by Bubble Sort algorithm");
                BubbleSorter.sort(shapes);
            }
            case "s" -> {
                System.out.println("Sorting by Selection Sort algorithm");
                SelectionSorter.Sort(shapes, compareType);
            }
            case "i" -> {
                System.out.println("Sorting by Insertion Sort algorithm");
                InsertionSorter.sort(shapes);
            }
            case "q" -> {
                System.out.println("Sorting by Quick Sort algorithm");
                QuickSorter.sort(compareType, shapes);
            }
            default -> throw new IllegalArgumentException("Invalid sort type: " + sortType);
        }
    }

    private static void printShapes(Shape[] shapes, String compareType) {
        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            if (i == 0) {
                System.out.println("First Element is: " + shape.toString(compareType));
            } else if (i == shapes.length - 2) {
                System.out.println("Second Last element is: " + shape.toString(compareType));
            } else if (i == shapes.length - 1) {
                System.out.println("Last element is: " + shape.toString(compareType));
            } else if (i % INTERVAL == 0) {
                System.out.println(i + "-th element is: " + shape.toString(compareType));
            }
        }
    }
}