package com.Madryoch;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


/**
 *
 * @author Madryoch
 * a.k.a. George Athanasopoulos
 * 
 * V1.0  Simple one class program that writes keyboard input in a file
 * V2.0  Addition of class Person that now holds the info in object variables
 * V3.0  Creation of FileManipulator class that contains only a static method
 *       that deals with writing arguments passed into the file or appending 
 *       to it.
 * V3.1  Enhancement of FileManipulator class. Added readFile function that 
 *       can read from a file passed as argument all the lines. Also enhanced 
 *       People class with an extra setter and getter that can set or get any
 *       object variable depending on an int modifier also passed.
 * V3.11 Added extra functionality to FileManipulator. Overloaded readFile so
 *       now if passed a start line and a finish line it only prints the lines
 *       from start till finish.Added extra test lines in main() to demonstrate
 *       the new features.
 * V4.0  Overloaded writeString() function in FileManipulator class so allows 
 *       us to make a series of new folders to an extra argument path and then 
 *       create the file there.The path is specified in a People class static
 *       constant field named PATH and can be altered accordingly
 * V4.1  Added the function populatePersonObjectFromFile() in FileManipulator
 *       class that returns a Person object reference when called with initialized
 *       fields as specified by the format of the file saved through writeString()
 *       of Person class. Currently only works for the specific format. 
 *       Needs to be improved so it can work on different formats if possible
 * v4.11 Modified function populatePersonObjectFromFile() in FileManipulator
 *       so it simplifies the manipulation of the read content to extract the 
 *       data.
 *      
 * v4.2  Changed the abstract class FilemManipulator into an interface of static
 *       methods that other classes like Person implement. Making adjustments to
 *       the Github repository to hold the older version as well to have as backup
 */
public class WTFClass{

    public static void main(String[] args) throws IOException 
    {
        //Είσοδος από το πληκτρολόγιο των απαραίτητων στοιχείων στο κατάλληλο
        //format όπου χρειάζεται (Δεν δέχεται ελληνικούς χαρακτήρες)
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter your first name: ");
        String fName=br.readLine();
        
        System.out.print("Please enter your last name: ");
        String lName=br.readLine();
        
        System.out.print("Please enter your Father's name: ");
        String fthName=br.readLine();
        
        System.out.print("Enter your date of birth in dd/mm/yyyy format: ");
        String date=br.readLine();
        
        Person person=new Person(fName,lName,fthName,date);
        String filename=person.getLName()+"."+person.getFName()+".txt";
        
        
                
                
                
                
                
                
        //Κλήση της μεθοδου της  κλάσης Person, writeString() η οποία είναι 
        //διαφορετική από την μέθοδο με το ίδιο όνομα της κλάσης FileManipulator
        for(int i=1;i<=3;++i)
        {
            person.writeString(i, filename);
                       
        }
        
        //Test των μεθόδων της κλάσης Person, setString και getString
        person.setString("Georgios", 0);
        person.setString("Pasparakis", 1);
        person.setString("Unknown", 2);
        person.setString("01/01/2018", 3);
        person.setString("15/8/1984", 4);
        
        System.out.println();
        for(int j=0;j<4;++j)
        {
            System.out.println(person.getString(j));
        }
        
        
        //Ανάγνωση από αρχείο με χρήση της overloaded μεθόδου readFile
        //της κλάσης FileManipulator
        System.out.print("\nReading file "+filename+" in its entirety...\n");
        FileManipulator.readFile(filename);
        
        System.out.print("\nReading file myText.txt from line 2 to 5\n");
        FileManipulator.readFile("myText.txt",2,5);
        
        //Δημιουργία νέου αντικειμένου Person newPerson με την βοήθεια της
        //FileManipulator.populatePersonObjectFromFile() και εκτύπωση των 
        //πεδίων του.
        Person newPerson=FileManipulator.populatePerson(Person.PATH,filename);
        System.out.println();
        System.out.println(newPerson.getFName());
        System.out.println(newPerson.getLName());
        System.out.println(newPerson.getFthName());
        System.out.println(newPerson.getDateOfBirth());
        
    }
    
}
