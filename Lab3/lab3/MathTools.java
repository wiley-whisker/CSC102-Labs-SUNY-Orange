package lab3;

import javax.swing.*;

/**
 *
 * @author Wiley Matthews, CSC 102
 */
public class MathTools {
    
    /**
     * A recursive method that finds the factorial of an integer
     * using the recursive framework n! = n * (n-1)!
     * @param n A number to have its factorial calculated (n!)
     * @return The factorial of the number.
     */
    private static int factorial(int n){
        if(n>1) /* Recursive case for positive numbers */ {
            return n * factorial(n-1);
        }
        else if(n == 1) /* Base case for positive numbers */ {
            return 1;
        }
        else if(n < (-1)) /* Recursive case for negative numbers */ {
            return n * factorial(n+1);
        }
        else if(n == (-1)) /* Base case for negative numbers */ {
            return -1;
        }
        else /* Catch-all for bad inputs */ {
            return 0;
        }
    }
    
    /**
     * A recursive method that returns the summation of an integer using
     * the recursive framework summation(n) = n + summation(n-1).
     * @param n a number for summation (n + (n-1) + ...)
     * @return The summation of the number.
     */
    private static int summation(int n) {
        if(n>1)/* Recursive case for positive numbers */ {
            return n + summation(n-1);
        }
        else if(n == 1) /* Base case for positive number */{
            return 1;
        }
        else if(n<(-1)) /* Recursive case for negative numbers */ {
            return n + summation(n+1);
        }
        else if(n == (-1)) /* Base case for negative numbers */ {
            return -1;
        }
        else /* Catch all for bad inputs */ {
            return 0;
        }
    }
    
    /**
     * A recursive method that returns the value of a supplied base
     * to a supplied power using the recursive framework
     * base^n = base * (base^(n-1).
     * @param base The base of the exponential expression.
     * @param n The exponent of the exponential expression.
     * @return The value of the exponential expression base^n.
     */
    private static int myPow(int base, int n) {
        if(n>0) /* Recursive case */ {
            return(base * myPow(base, n-1));
        }
        else if(n == 0) /* Base case */ {
            return 1;
        }
        else /* Catch-all for bad inputs */ {
            return 0;
        }
    }
    
    /**
     * A recursive method that uses Euclid's algorithm to find the gcd of
     * a rational number.
     * @param n The numerator of a rational number.
     * @param d The denominator of a rational number.
     * @return The gcd of the rational number.
     */
    private static int gcd(int n, int d) {
        int r = d % n;
        if(r != 0) /* Recursive case, there is a remainder */ {
            return gcd(r, n);
        }
        else /* Base case, remainder of 0. */ {
            return n;
        }
        
    }
    
    /**
     * A method to check inout from the user, this method only accepts and
     * returns ints.
     * @param n A string prompt to be displayed to the user. 
     * @return An integer the user entered.
     */
    private static int getInput(String prompt) {
        
        boolean foundInput = false;
        int newNum = 0;
        while(!foundInput) {
            String rawEntry = JOptionPane.showInputDialog(null, prompt);
            try /* Attempt to parse int from input */ {
                newNum = Integer.parseInt(rawEntry);
                foundInput = true;
            }
            catch(NumberFormatException e) /* User didn't enter an integer */ {
                JOptionPane.showMessageDialog(null, "*** ERROR ***\nThis method only accepts integers.");
            }
        }
        return newNum;
    }

    /**
     * The main method of this program prompts the user to enter test values to
     * demo each method. Once finished, it prompts the user to demo again or stop.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean running = true;
        int runAgain = 0;
        int arg = 0;
        int arg2 = 0;
        String[] options = {"No", "Yes"};
        
        while(running) /* Main Loop */ {
            JOptionPane.showMessageDialog(null, "Welcome to MathTools.java!" +
                    "\nThis program will demo the following methods:" + 
                    "\n1. factorial()" +
                    "\n2. myPow()" +
                    "\n3. summation()" +
                    "\n4. gcd()" + 
                    "\nPlease enter integer values when requested.");
            
            // factorial method.
            arg = getInput("Please enter a number for the factorial() method.");
            JOptionPane.showMessageDialog(null, "The factorial of " + arg + " is " + factorial(arg));
            
            // myPow method.
            arg = getInput("Please enter the (positive) base for the myPow method (base^exponent).");
            arg2 = getInput("Please enter the (positive) exponent for the myPow method (base^exponent).");
            JOptionPane.showMessageDialog(null, "The value of " + arg + "^" + arg2 + " is " + myPow(arg, arg2));
            
            // summation method.
            arg = getInput("Please enter an integer for the summation method.");
            JOptionPane.showMessageDialog(null, "The summation of " + arg + " is " + summation(arg));

            // gcd method.
            arg = getInput("Please enter the numerator for the gcd method (n/d).");
            arg2 = getInput("Please enter the denominator for the gcd method (n/d)");
            JOptionPane.showMessageDialog(null, "The gcd of " + arg + "/" + arg2 + " is " + gcd(arg, arg2));

            // Prompt to run again.
            runAgain = JOptionPane.showOptionDialog(null, "Would you like to go though the methods again?",
                "Demo Finished",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            if(runAgain == 0) {
                running = false;
            }
        }
    }    
}