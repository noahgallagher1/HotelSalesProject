import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This Category class is used to read a file and create separate files for each service
 * Satisfies Part 2 of the Project
 *
 * Use: Place the text file that you wish to read from in the same folder as this class
 *
 * @author Noah Gallagher, Jojo Paris, Tom Lee
 * Due Date: October 21, 2020
 */
public class category extends hotel {

    /**
     * This main method is used to run Part 2 of the project.
     * THis method will read the file newsales.txt and output instances of different services in their own file.
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException,
            UnknownTransactionException{

        //creating ArrayLists for each category
        ArrayList<Sale> Dinner = new ArrayList<Sale>();
        ArrayList<Sale> Conference = new ArrayList<Sale>();
        ArrayList<Sale> Lodging = new ArrayList<Sale>();

        //creating separate files for each category
        PrintWriter din = new PrintWriter("Dinner.txt");
        PrintWriter con = new PrintWriter("Conference.txt");
        PrintWriter lod = new PrintWriter("Lodging.txt");


        //setting the filename to the argument in the command line
        String filename = args[0];

        //printing file name
        System.out.println(filename);

        //scanning the input file for instances of each category
        try {
            //creating an array of Sale's from the file
            ArrayList<Sale> sales = new ArrayList<Sale>(readSalesFile(filename));
            //for each loop to iterate through each Sale in file
            for (Sale s : sales){
                //executes if the sale is a Dinner
                if (s.getServiceCategory().equals("Dinner")) {
                    //add to array list containing only Dinners
                    Dinner.add(s);
                }
                //executes if the sale is a Conference
                else if (s.getServiceCategory().equals("Conference")){
                    //add to array list containing only conferences
                    Conference.add(s);
                }
                //executes if the sale is a Lodging
                else if (s.getServiceCategory().equals("Lodging")){
                    //add to array list containing only Lodging
                    Lodging.add(s);
                }
                //executes if the sale is none of the above, "unknown service type"
                else {
                    System.out.println("This is not a valid service type.");
                    throws new UnknownTransactionException("Unknown Transaction");
                }
            }

            //Writing the sales to their own category, from each array list
            writeSale(din, Dinner);
            writeSale(con, Conference);
            writeSale(lod, Lodging);

            System.out.println("Compilation complete.");

    }
        //catches the error is the file is not found or does not exist
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }
        //catches the error if the file is not in the correct format
        catch (NoSuchElementException e)
        {
            System.out.println("File format not valid.");
        }
        //prints a stack trace for an exception
        catch (Exception e) {
            e.printStackTrace();
        }


    }

}
