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

            //User enters Guest's First & Last name
            System.out.println("Enter First name: ");
            String first_name = in.next();
            System.out.println("Enter Last name: ");
            String last_name = in.next();
            //saves the first and last name as a single string
            String name = first_name + " " + last_name;

            //User enters Service
            System.out.println("Enter service: ");
            String service = in.next();

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

            //User enters date of Guest's stay
            System.out.println("Enter date as DD/MM/YYYY: ");
            String date = in.next(); //start

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
     * Read a sales entry from input Scanner.
     *
     * @param in Scanner from which to read entry
     * @return Sale instance
     */
    private static Sale readSaleEntry(Scanner in) {
        //scanning the file
        String inputLine = in.nextLine();
        Scanner lineScan = new Scanner(inputLine);
        lineScan.useDelimiter(";");
        String name = lineScan.next();
        String service = lineScan.next();
        double amount = lineScan.nextDouble(); //double
        String date = lineScan.next();
        return new Sale(name, service, amount, date);
    }

    /**
     * Reads sales data from the specified file.
     *
     * @param filename name of sales data file
     */
    public static ArrayList<Sale> readSalesFile(String filename)
            throws FileNotFoundException {

        ArrayList<Sale> sales = new ArrayList<Sale>();

        if (filename != null) {
            try (Scanner infile = new Scanner(new File(filename))) {
                while (infile.hasNext()) {
                    sales.add(readSaleEntry(infile));
                }
            }
        }
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
    public static void main(String[] args) throws FileNotFoundException, UnknownTransactionException {

        try (Scanner in = new Scanner(System.in);
             PrintWriter newsales = new PrintWriter("newsales.txt")) {

            //writes the sales to the file
            writeSale(newsales, processName(in));

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



