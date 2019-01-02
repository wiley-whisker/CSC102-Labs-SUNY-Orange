package extraclasses;

import java.util.Formatter;

/**
 *
 * @author Wiley
 */
public class FileTest
{
    private Formatter x;
    
    public void openFile()
    {
        try {x = new Formatter("myText.txt");}
        catch(Exception e) {System.out.println("Error");}    
    }
    
    public void addRecords()
    {
        x.format("%s %s", "Wiley", "Matthews");
    }
    
    public void closeFile()
    {
        x.close();
    }
}
