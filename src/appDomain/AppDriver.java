package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppDriver
{

	public static void main( String[] args )
	{
             try{
                 
                 String type = " ";

                //creating the file class to be read
                File txt = new File("");
                //creatng the scanner to read the file
                Scanner scanner = new Scanner(txt);
                
                switch(type){
                    //for each shape type have the constructors, simmilar to the appliance assignment. 
                    case "Cone"

                            :
                    case "Cylinder":
                        
                        
                    case "Pyramid":  
                        
                        
                     case "OctogonalPrism": 
                         
                         
                    case "SquarePrism":
                        
                        
                    case "TriangularPrism":   
                        
                        
                    case "PentagonalPrism":                       
                  
                }
                        

             }
                catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();           
           
	}

}
