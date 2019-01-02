/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */
package lab9;

/**
 * An interface which represents methods common across all bank accounts
 * @author wiley
 */
public interface BankAccount
{
    public void deposit(double amount);
    
    public void withdrawal(double amount); 
    
    public double checkBalance();
}
