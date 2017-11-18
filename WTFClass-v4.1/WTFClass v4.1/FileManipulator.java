package com.Madryoch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Madryoch
 * a.k.a. George Athanasopoulos
 */

public class FileManipulator {
    
        
    /* Γράφει το String s στο αρχείο με όνομα filename
    ** στην αρχή του αρχείου αν b=false και το προσαρτίζει
    ** στο τέλος αν έχει την τιμή true
    */
    public static void writeString(String s,String filename,boolean b)  
    {
        try {
            PrintWriter pw=new PrintWriter(new FileOutputStream(    new File(filename),    b ));
            pw.append(s);
            pw.println();
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManipulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Overloaded writeString που δέχεται ένα String επιπλέον και δημιουργεί το Directory
    //που ορίζει αυτό το String αν δεν υπάρχει, ενώ αποθηκεύει το αρχείο που δημιουργεί 
    //στο συγκεκριμένο Directory . Βλέπε Person class την σταθερά PATH για αλλαγή του.
    public static void writeString(String s,String filename,boolean b,String folder)  
    {
        try 
        {
            
                
                File f=new File(folder);
                
                if(f.mkdirs())
                {
                    System.out.println("Created");
                    
                }
            
                boolean check=f.isDirectory();
                if(check)
                {
                    PrintWriter pw=new PrintWriter(new FileOutputStream(    new File(folder+filename),    b ));
                    pw.append(s);
                    pw.println();
                    pw.close();
                }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManipulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    // Διαβάζει κάθε γραμμή του αρχείου κειμένου filename και την τυπώνει.
    // Δεν κάνει parse τους χαρακτήρες για μεγαλύτερη ταχύτητα.
    public static void readFile(String filename)
    {
        String s;
        
        {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(filename));
                while((s=br.readLine())!=null)
                {
                    System.out.println(s);
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManipulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
    /* Διαβάζει κάθε μια από τις γραμμές του αρχείου filename και τυπώνει
    ** τις γραμμές από start έως finish, την οποία μόλις διαβάσει, σταματάει.
    ** Δεν κάνει parse τους χαρακτήρες για μεγαλύτερη ταχύτητα.
    */
    public static void readFile(String filename,int start,int finish)
    {
        String s;
        
        {
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(filename));
                int count=0;
                while(((s=br.readLine())!=null)&&count<=finish)
                {
                    
                    if(count>=start)
                        System.out.println(s);
                    ++count;                   
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManipulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
    public static Person populatePersonObjectFromFile(String folder,String file)
    {
        String s="";
        
        
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(folder+file));
                
                s=br.readLine()+br.readLine();
                br.close();
                } catch (IOException ex) {
                Logger.getLogger(FileManipulator.class.getName()).log(Level.SEVERE, null, ex);
                }
                             
                if(s!=null)
                {
                    String s1[]=s.split("L");
                    s=s1[1]+","+s1[2];
                    String s2[]=s.split(":");
                    s=s2[1]+","+s2[2];
                    String s3[]=s.split(",");
                    s=s3[0]+s3[1]+s3[2]+s3[4];
                    String s4[]=s.split(" ");
                    return new Person(s4[1],s4[2],s4[3],s4[4]);
                }
                return null;
    }          
    
}
