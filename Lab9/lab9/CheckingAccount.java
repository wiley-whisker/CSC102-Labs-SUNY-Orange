/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */
package lab9;

/**
 * A checking account with the bank
 * @author wiley
 */
public class CheckingAccount implements BankAccount
{
    private double balance;
    
    public CheckingAccount(double bal)
    {
        balance = bal;
    }
    
    /**
     * Deposit a dollar amount into the account
     * @param amount amount in dollars
     */
    public void deposit(double amount)
    {
        balance += amount;
    }
    
    /**
     * Withdrawal a dollar amount into the account
     * @param amount amount in dollars
     */
    public void withdrawal(double amount)
    {
        balance -= amount;
    }
    
    /**
     * Find out the dollar amount in the accounts
     * @return Account balance in dollars
     */
    public double checkBalance()
    {
        return balance;
    }
}
