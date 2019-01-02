/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */
package lab7;

import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

/**
 *
 * @author wiley
 */
public class ListDemo
{
    public static void main(String[] args)
    {
        //**********************************************************************
        // START FUNCTIONALITY DEMONSTRATION
        
        System.out.println("Start functionality demonstration.");
        MyLinkedList list = new MyLinkedList();
        
        System.out.println(list.getFirst());
        
        list.addFirst("E");
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        
        System.out.println(list.getFirst() + "\n");
        
        list.newIterator();
        while(list.itr.hasNext())
        {
            Object obj = list.itr.next();
            System.out.println(obj); 
            obj = (String) obj;
            if(obj.equals("B"))
            {
                list.itr.set("Q");
                list.itr.add("R");
                list.removeFirst();
            }
            
        }
        
        System.out.println("\n");
        
        list.newIterator();
        while(list.itr.hasNext())
        {
            Object obj = list.itr.next();
            obj = (String) obj;
            if(obj.equals("D"))
            {
                list.itr.remove();
            }
            else
            {
                System.out.println(obj); 
            }     
        }
        
        // Will print out  A ABCDE QRCE
        
        try // Will throw an exception since iterator is at end of list
        {
            System.out.println(list.itr.next()); // Will throw a NoSuchElementException, itr is at end of list.
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Exception handled");
        }
        
        try // Will throw an exception since will try to remove two items in a row.
        {
            list.itr.remove(); // Ok, one element removed.
            list.itr.remove(); // Will throw an IllegalStateException.
        }
        catch(IllegalStateException e)
        {
            System.out.println("Exception handled");
        }
        
        System.out.println("Functionality demonstration ran succesfully");
        
        // END FUNCTIONALITY DEMONSTRATION
        //**********************************************************************
        // START APPLICATION DEMONSTRATION
        
        System.out.println("Start application demonstration.");
        
        MyLinkedList list2 = new MyLinkedList();
        list2.newIterator();
        
        System.out.println("Requesting user input...");
        int i = 0;
        while(i < 10)
        {
            try
            {    
                String input = JOptionPane.showInputDialog(null, "Enter a number or sentinel value 'stop'");
                
                if(input.equals("stop"))
                {
                    i = 10; // Sentinel encountered, stop adding.
                }
                else
                {
                    Double num = Double.parseDouble(input);
                    list2.itr.add(num);
                    i++;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "INVALID INPUT: Not number or sentinel word 'stop'");
            }    
        }
        
        System.out.println("Processing user input...");
        double sum = 0;
        list2.newIterator();
        while(list2.itr.hasNext())
        {
            sum += (Double)list2.itr.next();
        }
        
        System.out.println("The sum is: " + sum);
        
        // END APPLICATION DEMONSTRATION
        //**********************************************************************
    }
}
