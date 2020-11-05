A hotel salesperson enters sales in a text file. Each line contains the following, separated by semicolons:
    The name of the client,
    the service sold (such as Dinner, Conference, Lodging, and so on),
    the amount of the sale,
    and the date of that event.

Prompt the user for data to write the file

This program reads the text file as described above, and writes a separate file for each service category, containing the entries for that category. 
    The output files are named: Dinner.txt, Conference.txt, and so on.
    The name of the output file from Part One is read as a command line argument.


Sample:

    Contents of sales.txt (file created in part one)
        John Public;Dinner;29.95;6/7/2014
        Jane Public;Conference;499.00;8/9/2014
        Abby Lawrence;Dinner;23.45;10/10/2014
        
  Contents of Dinner.txt (file created in part two)
        John Public;Dinner;29.95;6/7/2014
        Abby Lawrence;Dinner;23.45;10/10/2014
        
  Contents of Conference.txt (file created in part two)
        Jane Public;Conference;499.0;8/9/2014
   
   
