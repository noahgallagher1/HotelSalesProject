import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *This Hotel will simulate data entry for a hotel salesperson.
 *This class will prompt the user to enter Sales into the console.
 *The program will then write the input to a separate txt document called newsales.txt
 *
 * Use: Place hotel class in the same project folder as Sale
 *
 * @authors Noah Gallagher, Jojo Paris, Tom Lee
 * Due Date: October 21, 2020
 */

public class hotel {
    ArrayList<Sale> sales;

    /**
     * Default Constructor, which constructs
     * connection to database
     */
    public hotel() {
        sales = new ArrayList<Sale>();
    }

    /**
     * Prompts and reads input from user and adds each entry to an ArrayList
     *
     * @param in Scanner from which to read entry
     * @return ArrayList<Sale>
     */
    public static ArrayList<Sale> processName(Scanner in) {
        ArrayList<Sale> sales = new ArrayList<Sale>();
        boolean Continue = false;

        while (!Continue) {

            /**
             * User enter name (first & last)
             */
            //User enters Guest's first name
            System.out.println("Enter First name: ");

            //validating first name
            while(!in.hasNext("[A-Za-z]+")) {
                System.out.println("\nThats Not A Formal First Name. Try Again. ");
                in.next();
            }
            //saving first name
            String first_name = in.next();

            //User enters Guest's Last name
            System.out.println("Enter Last name: ");
            //String last_name = in.next();

            //validating last name
            while(!in.hasNext("[A-Za-z]+")) {
                System.out.println("\nThats Not A Formal Last Name. Try Again. ");
                in.next();
            }
            //saving last name
            String last_name = in.next();

            //saves the first and last name as a single string
            String name = first_name + " " + last_name;

            /**
             * User enters a Service
             */
            //User enters Service
            System.out.println("Service Options: Dinner, Conference, Lodging");
            System.out.println("Enter service: ");
            //saving entered service, awaiting validation
            String check_service = in.next();
            //validating service
            while(!check_service.equalsIgnoreCase("dinner") && !check_service.equalsIgnoreCase("conference") && !check_service.equalsIgnoreCase("lodging")) {
                System.out.println("\nThats Not A Formal Type of Service Here. Try Again. ");
                check_service = in.next();
            }
            String service = check_service;

            /**
             * User enters amount
             */
            //User enters service amount
            System.out.println("Enter amount: ");
            double amount = 0;
            boolean valid = false;
            //loop to validate that the user enters a double for amount
            while (!valid) {
                if (in.hasNextDouble()) {
                    amount = in.nextDouble();
                    valid = true;
                } else {
                    System.out.println("Invalid Input.");
                    in.next(); //clears invalid string
                }
            }
            /**
             * User enters date
             */
            //User enters month
            System.out.println("Please Enter A Month with Two Numbers or Less");
            String checkMonth = in.next();
            //validating month
            while(!(checkMonth.length() <= 2)) {
                System.out.println("\nThats Not A Formal Month with Two or Less Numbers ");
                checkMonth = in.next();
            }
            String month = checkMonth;
            //User enters day
            System.out.println("Please Enter A Day with Two Numbers or Less");
            String checkDay = in.next();
            //validating day
            while(!(checkDay.length() <= 2)) {
                System.out.println("\nThats Not A Formal Day with Two or Less Numbers ");
                checkDay = in.next();
            }
            String day = checkDay;
            //User enters Year
            System.out.println("Please Enter A Year with Four Numbers: ");
            String checkYear = in.next();
            //validating year
            while(!(checkYear.length() == 4)) {
                System.out.println("\nThats Not A Formal Year with Four Numbers ");
                checkYear = in.next();
            }
            String year = checkYear;
            //Creating date with day, month & year
            String date = month + "/" + day + "/" + year;

            //Creates a new instance of the Sale
            Sale inst = new Sale(name, service, amount, date);

            //Adds the instance of the Sale to ArrayList sales
            sales.add(inst);

            //Asks the user if they wish to enter more Sales
            System.out.println("Done? yes/no");
            //checks the input
            String input = in.next();
            //Exits the loop if they answer yes
            if (input.equalsIgnoreCase("yes")) {
                System.out.println("File successfully created.");
                Continue = true;
            }
        }
        //returns arraylist containing all sales
        return sales;
    }
    
    /**
     * Writes sale to writer; writing in a new file.
     *
     * @param out   PrintWriter to which sale is written
     * @param sales ArrayList of sale information
     */
    public static void writeSale(PrintWriter out, ArrayList<Sale> sales) {
        for (Sale sale : sales) {
            out.print(sale.getName());
            out.print(";");
            out.print(sale.getServiceCategory());
            out.print(";");
            out.print(sale.getAmount());
            out.print(";");
            out.print(sale.getDate());
            out.println();
        }
        out.close();
    }

    /**
     * Main Method used to create a new file from the user input (PART 1)
     * File Created: newsales.txt
     *
     * @param args
     */
    public static void main(String[] args){

        try (Scanner in = new Scanner(System.in);
             PrintWriter newsales = new PrintWriter("newsales.txt")) {

            //writes the sales to the file
            writeSale(newsales, processName(in));

        }
        //catches File not Found
        catch(FileNotFoundException e) {
            System.out.println("File was not found. Try Again: ");
        }
        //catches if there is an I/O exception
        catch (IOException e) {
            System.out.println("File input error");
            e.printStackTrace();
        }
        //Catches if the file format is not valid
        catch (NoSuchElementException e) {
            System.out.println("File format not valid.");
        }

    }
}



