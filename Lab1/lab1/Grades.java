package lab1;

import java.util.ArrayList;

import javax.swing.*;

/**
 *
 * @author Wiley Matthews CSC102 Lab1
 */
public class Grades {
    
    /*
        The main method of this program prompts the user for 10 test grades,
        each entered one at a time. It then computes the average test grade,
        highest score, and lowest score. Those three pieces of information are
        then printed to the user using a dialog box.
    */
    
    public static void main(String args[]) {

        int listLength = 10;
        ArrayList<Double> grades = new ArrayList<Double>();

        double average = 0;
        
        // Gather input 
        for(int i=0;i<listLength;i++) {
            String rawInput = JOptionPane.showInputDialog(null, 
                "Enter grade " + (i + 1) + " of " + listLength + ".");
            double input = Double.parseDouble(rawInput);
            grades.add(input);
        }

        //compute average.
        for(int i=0;i<grades.size();i++) {
            average += (double)grades.get(i);
        }
        average /= grades.size();

        //compute largest and lowest.
        double largest = (double)grades.get(0);
        double smallest = (double)grades.get(0);
        for(int i=0;i<grades.size();i++) {
            if((double)grades.get(i) > largest) {
                largest = (double)grades.get(i);
            }

            if((double)grades.get(i) < smallest) {
                smallest = (double)grades.get(i);
            }
        }

        JOptionPane.showMessageDialog(null, "The average grade is: " + average + 
            "\nThe highest is: " + largest + "\nThe lowest is: " + smallest);
    }
    
}
