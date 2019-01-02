package lab2;

import java.util.ArrayList;

import javax.swing.*;


/**
 * Lab 2
 * @author Wiley Matthews, CSC102
 */
public class NumList {
    
    /**
     * A method to represent an ArrayList as a string.
     * @param arrList
     * @return list
     */
    private static String numsAsString(ArrayList arrList)
    {
        String list = "";
        if(!arrList.isEmpty())
        {
            for(int i=0;i<arrList.size();i++)
            {
                if(i == arrList.size()-1)
                {
                    list = list + arrList.get(i);
                }
                else
                {
                    list = list + arrList.get(i) + ", ";
                }
            }
        }
        else
        {
            list = "Empty";
        }
        return(list);
    }
    
    /**
     * A method to add a new number to an ArrayList in order. (only for doubles)
     * 
     * @param arrList
     * @param newNum
     * @return 
     */
    private static void addInOrder(ArrayList arrList, double newNum)
    {
        if(arrList.isEmpty()) //Arraylist has no existing entries
        {
           arrList.add(newNum);
        }
        else // Arraylist has existing entries.
        {
            boolean inserted = false;
            for(int i=0;i<arrList.size();i++) //check that elements are less than newNum
            {
                if(newNum < (double)arrList.get(i))
                {
                    arrList.add(i, newNum);
                    inserted = true;
                    i = arrList.size();
                }
            }
            if(!inserted)
            {
                arrList.add(newNum);
            }
        }   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Double> nums = new ArrayList<>();
        boolean running = true;
        
        //Main Loop
        while(running)
        {
            boolean error = false;
            double newNum = 0;
            String sentinal = "stop";
            
            String numsList = numsAsString(nums);
            String rawEntry = JOptionPane.showInputDialog(null, "*** Enter \"" + sentinal + "\" to end the list. ***" +
                    "\nYour list of nums: "  + numsList + "\nEnter a new number:");
            
            if(!rawEntry.equals(sentinal)) // No sentinal detected
            {
                try // Attempt to parse double from input.
                {
                    newNum = Double.parseDouble(rawEntry);
                }
                catch(NumberFormatException e) // User didn't enter a number.
                {
                    error = true;
                    JOptionPane.showMessageDialog(null, "*** ERROR ***\nThis list only accepts numbers.");
                }
                if(!error)
                {
                    addInOrder(nums, newNum);
                    //nums.add(newNum);
                }
            }
            else // Sentinal detected.
            {
                running = false;
                JOptionPane.showMessageDialog(null, "Your final list is: " + numsList);
            }
        }               
    }
    
}
