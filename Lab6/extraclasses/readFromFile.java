package extraclasses;

import java.util.Scanner;
import java.io.File;

/**
 *
 * @author Wiley
 */
public class readFromFile
{
    private Scanner x;
    
    public void openFile()
    {
        try {x = new Scanner(new File("myText.txt"));}    
        catch(Exception e){System.out.println("Can't find file");}
    }
    
    public void readFile()
    {
        while(x.hasNext())
        {
            System.out.println(x.next());
        }
    }
    
    public void closeFile()
    {
        x.close();
    }
    
}
