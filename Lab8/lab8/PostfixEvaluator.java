/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */
package lab8;

import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * Evaluates expressions in postfix notation.
 * @author wiley
 */
public class PostfixEvaluator
{
    Stack<Double> stack;
    
    public PostfixEvaluator()
    {
        stack = new Stack();
    }
    
    /**
     * Evaluates a string in postfix notation.
     * @param expression to be evaluated
     * @return the numerical value of the expression
     */
    public double evaluate(String expression)
    {
        Tokenizer tokenizer = new Tokenizer(expression);
        
        boolean solving = true;
        while(tokenizer.hasNext())
        {
            String next = tokenizer.next();
            
            try // See if next is a number.
            {
                stack.push(Double.parseDouble(next));
            }
            catch(NumberFormatException e) // next is NaN
            {   
               if(next.equals("+")) // perform addition
               {
                   double operand2 = stack.pop();
                   double operand = stack.pop();
                   operand += operand2;
                   stack.push(operand);
               }
               else if(next.equals("-")) // perform subtraction
               {
                   double operand2 = stack.pop();
                   double operand = stack.pop();
                   operand -= operand2;
                   stack.push(operand);
               }
               else if(next.equals("*")) // perform multiplicaion
               {
                   double operand2 = stack.pop();
                   double operand = stack.pop();
                   operand *= operand2;
                   stack.push(operand);
               }
               else if(next.equals("/")) // perform division
               {
                   double operand2 = stack.pop();
                   double operand = stack.pop();
                   operand /= operand2;
                   stack.push(operand);
                   
               }
               else if(next.equals("~")) // Unary negation
               {
                   double operand = stack.pop();
                   operand *= -1;
                   stack.push(operand);
               }
               else // Invalid operand encountered, throw exception.
               {
                   throw new ArithmeticException(); 
               }
            }
        }
        return stack.pop();
    }
    
    /**
     * Tokenizes the input expression
     */
    private class Tokenizer
    {
        String[] expression;
        int index = 0;

        public Tokenizer(String input)
        {
            expression = input.split(" ");
        }

        /**
         * @return next token in expression
         */
        public String next()
        {
            index++;
            return expression[index-1];
        }

        /**
         * @return whether or not there is a next token.
         */
        public boolean hasNext()
        {
            return (index < (expression.length));
        }
    }
    
    public static void main(String[] args)
    {
        boolean running = true;
        while(running)
        {            
            try
            {
                String ex = JOptionPane.showInputDialog(null, "Please enter an expression in postfix format: ex 2 5 + (enter 'stop' to end the program.)");
                if(ex.equals("stop")) // check for sentinel
                {
                    running = false;
                    JOptionPane.showMessageDialog(null, "Exiting program");
                }
                PostfixEvaluator eval = new PostfixEvaluator();
                JOptionPane.showMessageDialog(null, "The expression you entered evaluates to: " + eval.evaluate(ex)); // show evaluation result
            }
            catch(ArithmeticException e) // user entered somthing that wasn't proper postfix
            {
                JOptionPane.showMessageDialog(null, "Bad input");
            }
        }
    }
}
