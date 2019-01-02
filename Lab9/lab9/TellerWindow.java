/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */

package lab9;

import javax.swing.JOptionPane;

import java.util.ArrayList;

/**
 *
 * @author Wiley
 */
public class TellerWindow
{
    Storage userAccount;
    
    ArrayList<String> userBalances; // [checking ballance, savings balance]
    
    /**
     * Class that encapsulates how a user manages and accesses everything within their account
     * @param user user id
     */
    public TellerWindow(String user)
    {
        userAccount = new Storage(user + ".txt");// find or make account for user.
        
        userBalances = new ArrayList();
        userAccount.placeContentsIn(userBalances);
        
        if(userBalances.isEmpty()) // if the account is new, initial balances are $0.00
        {
            userBalances.add("0.00");
            userBalances.add("0.00");
        }
    }
    
    /**
     * Handles UI and logic of user choosing between accounts to manage.
     */
    public void show()
    {
        while(true)
        {
            String[] options = {"Checking", "Savings", "Log out"};
            // Present option pane to user to eithe rmake an accound or login.
            int logOrNew = JOptionPane.showOptionDialog(null, "Select which of your accounts to manage or log out.",
                "Accounts",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(logOrNew == 2) // exit to main menu
            {
                break;
            }
            else if(logOrNew == 0) // manage checking
            {
               manage("Checking");
            }
            else // manage savings
            {
                manage("Savings");
            }   
        }
        userAccount.save(userBalances); // Save changes made.
    }
    
    /**
     * Handles UI and logic of a user managing a savings or checking account including deposits and withdrawals
     * @param accType 
     */
    private void manage(String accType)
    {
        int arrIndex;
        BankAccount acc;
        if(accType.equals("Checking"))
        {
            acc = new CheckingAccount(Double.parseDouble(userBalances.get(0)));
            arrIndex = 0;
        }
        else // savings
        {
            acc = new SavingsAccount(Double.parseDouble(userBalances.get(1)));
            arrIndex = 1;
        }
        
        while(true)
        {
            String[] options = {"Deposit", "Withdrawal", "Back to accounts"};
            // Present option pane to user to either make an account or login.
            int logOrNew = JOptionPane.showOptionDialog(null, "Select an action to take. Your current balance is: $" + acc.checkBalance(),
                accType,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(logOrNew == 2) // back to accounts
            {
                break;
            }
            else if(logOrNew == 0) // deposit
            {
               while(true)
               {
                    try
                    {
                       String input = JOptionPane.showInputDialog(null,"Enter an amount to deposit.");
                       double dep = Double.parseDouble(input);
                       acc.deposit(dep);
                       userBalances.set(arrIndex, acc.checkBalance() + ""); // update local array balance.
                       break;
                    }
                    catch(NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "That's not a valid deposit.");
                    }
               }
            }
            else // withdrawal
            {
                while(true)
               {
                    try
                    {
                       String input = JOptionPane.showInputDialog(null,"Enter an amount to withdrawl.");
                       double wit = Double.parseDouble(input);
                       acc.withdrawal(wit);
                       userBalances.set(arrIndex, acc.checkBalance() + ""); // update local array balance.
                       break;
                    }
                    catch(NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(null, "That's not a valid withdrawl amount.");
                    }
               }
            }
            
        }
    }
}
