/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

/**
 *
 * @author wiley
 */
public class TokenizerTest
{
    String[] expression;
    int index = 0;

    public TokenizerTest(String input)
    {
        expression = input.split(" ");
    }

    public String next()
    {
        index++;
        return expression[index-1];
    }
    
    public boolean hasNext()
    {
        return (index < (expression.length));
    }
    
//    public static void main(String[] args)
//    {
//        String input = "2 3 +";
//        TokenizerTest tester = new TokenizerTest(input);
//        while(tester.hasNext())
//        { 
//            System.out.println(tester.next());
//        }
//    }
}
