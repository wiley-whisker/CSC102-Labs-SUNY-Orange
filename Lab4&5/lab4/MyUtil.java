package lab4;

import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Wiley
 */
public class MyUtil
{
    
    
    Random rand;
    
    public MyUtil()
    {
        rand = new Random();
    }

    /**
     * A method to check input from the user, this method only accepts and
     * returns ints.
     *
     * @param prompt A string prompt to be displayed to the user.
     * @return An integer the user entered.
     */
    public int getInput(String prompt)
    {
        boolean foundInput = false;
        int newNum = 0;
        while (!foundInput)
        {
            String rawEntry = JOptionPane.showInputDialog(null, prompt);
            try/* Attempt to parse int from input */
            {
                newNum = Integer.parseInt(rawEntry);
                foundInput = true;
            }
            catch (NumberFormatException e)/* User didn't enter an integer */
            {
                JOptionPane.showMessageDialog(null, "*** ERROR ***\nThis method only accepts integers.");
            }
        }
        return newNum;
    }
    
    /**
     * A method to display a simple message not expecting user input.
     * @param message The message to be displayed.
     */
    public void display(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    
    public int getChoice(String prompt, String winTitle, String... options)
    {
        return (JOptionPane.showOptionDialog(null, prompt, winTitle,
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            null, options, options[0]));
    }
    
    public void arrFill(int[] arr, String fillType)
    {
        if(fillType.equals("random"))
        {
           for(int i = 0; i < arr.length; i++)
            {
                arr[i] = rand.nextInt(1000);
            } 
        }
        else if(fillType.equals("sorted"))
        {
            for(int i = 0; i < arr.length; i++)
            {
                arr[i] = i;
            }
        }
        else if(fillType.equals("reverse"))
        {
            for(int i = 0; i < arr.length; i++)
            {
                arr[i] = arr.length - i - 1;
            }
        }
        
    }
    
    public void arrChop(int[] baseArr, int[] fillArr, int start, int end)
    {
        if(baseArr.length == fillArr.length)
        {
            for(int i = start; i <= end; i++)
            {
                fillArr[i] = baseArr[i];
                System.out.println(baseArr[i]);
            }
        }
    }
    
    public void arrSwap(int[] arr, int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public String arrAsString(int[] arr)
    {
        String asString = "[";
        
        for(int i = 0; i < arr.length; i++)
        {
            if(i == arr.length - 1)
            {
                asString = asString + arr[i] + "]";
            }
            else
            {
                asString = asString + arr[i] + ", ";
            }
        }
        
        if(asString.length() > 50)
        {
            asString = asString.substring(0,50) + "...";
        }
        return asString;
    }
}
