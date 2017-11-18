package com.Madryoch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Madryoch
 * a.k.a. George Athanasopoulos
 */
public class Person implements FileManipulator {
    
    private String firstName;
    private String lastName;
    private String fathersName;
    private String dateOfBirth;
    public static final String PATH="C:\\temp\\temp1\\";
    
       
    public Person(String fName,String lName, String fthName, String dateOB)
    {
        this.firstName=fName;
        this.lastName=lName;
        this.fathersName=fthName;
        this.dateOfBirth=dateOB;
        
    }
    
    public String getString(int id)
    {
        switch(id)
        {
            case 0:
                return this.firstName;
            case 1:
                return this.lastName;
            case 2:
                return this.fathersName;
            case 3:
                return this.dateOfBirth;
            default:
                return "";
        }
    }
    
    public void setString(String s,int id)
    {
        switch(id)
        {
            case 0:
                this.firstName=s;
                break;
            case 1:
                this.lastName=s;
                break;
            case 2:
                this.fathersName=s;
                break;
            case 3:
                this.dateOfBirth=s;
                break;
            default:
                System.out.println("\nInvalid Identifier");
        }
    }
    
    
    public String getFName()
    {
        return this.firstName;
    }
    
    public void setFName(String name)
    {
        this.firstName=name;
    }
    
    public String getLName()
    {
        return this.lastName;
    }
    
    public void setLName(String name)
    {
        this.lastName=name;
    }
    
    public String getFthName()
    {
        return this.fathersName;
    }
    
    public void setFthName(String name)
    {
        this.fathersName=name;
    }
    
    public String getDateOfBirth()
    {
        return this.dateOfBirth;
    }
    
    public void setDateOfBirth(String date)
    {
        this.dateOfBirth=date;
    }
    
    
    /* Η μέθοδος writeString γράφει στο αρχείο filename διαφορετικά πράγματα ανάλογα
    ** με την τιμή της παραμέτρου line. Επίσης υπολογίζει την ηλικία του προσώπου που
    ** αντιπροσωπεύει το αντικείμενο το οποίο την καλεί και για τιμή line=3 την γράφει
    ** στο αρχείο. Αν το αρχείο δεν υπάρχει, το αρχείο θα δημιουργηθεί.*/
    public void writeString(int line,String filename) throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        
        
        String s;
        switch(line)
            {
                case 1:
                    
                    s="Line "+line+": "+this.firstName+", "+this.lastName+", "+this.fathersName;
                    FileManipulator.writeString(s, filename, false, PATH);
                    FileManipulator.writeString(s, filename, false);
                    break;
                case 2:
                    
                    s="Line "+line+": "+this.dateOfBirth;
                    FileManipulator.writeString(s, filename, true, PATH);
                    FileManipulator.writeString(s, filename, true);
                    break;
                case 3:
                    String s2[]=this.dateOfBirth.split("/");
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String date = sdf.format(new Date());
                    String s3[]=date.split("/");
                    
                    
                    int days=(Integer.parseInt(s3[1])*31+Integer.parseInt(s3[0]))-(Integer.parseInt(s2[1])*31+Integer.parseInt(s2[0]));
                    int age=Integer.parseInt(s3[2])-Integer.parseInt(s2[2]);
                    
                    if (days<0)
                    {
                        age--;
                    }
                    
                    s="Line "+line+": "+"Your age is: "+age +"\n";
                    FileManipulator.writeString(s, filename, true, PATH);
                    FileManipulator.writeString(s, filename, true);
                    break;
                default:
                    System.out.println("This should not be printed ever. This line exists purely for validation purposes.");
                    
            }
        
    }
    
}




