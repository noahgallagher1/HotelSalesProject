/**
 * This class creates an instance of a Sale for the hotel class
 * Sale includes name, service, amount & date
 *
 * Use: Place Sale class in the same project folder as hotel class.
 *
 * @author Noah Gallagher, Jojo Paris, Tom Lee
 * Due Date: October 21, 2020
 */

public class Sale {
    private String name;
    private String service;
    private double amount; //double
    private String date;

    /**
     Constructs a Sale.
     @param name client name
     @param service service category
     @param amount cost of service
     @param date date of service
     */
    public Sale(String name, String service, double amount, String date)
    {
        this.name = name;
        this.service = service;
        this.amount = amount;
        this.date = date;
    }

    /**
     Retrieve client name.
     @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     Retrieve service category.
     @return service category
     */
    public String getServiceCategory()
    {
        return service;
    }

    /**
     Retrieve amount.
     @return cost of service
     */
    public double getAmount()
    {
        return amount;
    }

    /**
     Retrieve date.
     @return date of service
     */
    public String getDate()
    {
        return date;
    }

    /**
     * toString method to return the Sale as a string
     * @return String
     */
    public String toString()
    {
        return name+";"+service+";"+amount+";"+date;
    }
}
