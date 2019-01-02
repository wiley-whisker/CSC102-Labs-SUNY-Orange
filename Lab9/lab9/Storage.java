/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */

package lab9;

import java.util.ArrayList;

import java.util.Scanner;

import java.io.File;

import java.io.PrintWriter;


/**
 *
 * @author Wiley
 */
public class Storage
{
    final private File file;
    
    private PrintWriter fileOut;
    
    private Scanner fileIn;
    
    public Storage(String storageName)
    {    
        file = new File(storageName);
        
        if(!file.exists())
        {
            try {file.createNewFile();}
            catch (Exception e) {System.out.println("File Can't Exist");} 
        }
        try {fileIn = new Scanner(file);}
        catch (Exception e) {System.out.println("File Still Doesn't Exist");}  
    }
    
    /**
     * A method to place all contents from storage file into ArrayList. contents are guaranteed to be sorted.
     * @param arrlst ArrayList for file contents to be placed.
     */
    public void placeContentsIn(ArrayList arrlst)
    {
        while(fileIn.hasNext())
        {
            arrlst.add(fileIn.next()); // Copy all contents from file into ArrayList.
        }
        fileIn.close();
        //sorter.sort(arrlst);// Ensure contents from file are sorted.
    }
    
    /**
     * A method to save the contents of an ArrayList into the storage file.
     * @param arrlst ArrayList whose contents to save.
     */
    public void save(ArrayList arrlst)
    {
        try {fileOut = new PrintWriter(file);}
        catch (Exception e) {System.out.println("Error3");}
        
        for(int i =0; i < arrlst.size(); i++)
        {
            fileOut.println(arrlst.get(i));
        }
        
        fileOut.close();
    }
}
