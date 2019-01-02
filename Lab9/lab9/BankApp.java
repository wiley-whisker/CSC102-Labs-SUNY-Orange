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
 * Class that acts as a hub for the application. primarily handles log into and creation of accounts.
 * @author wiley
 */
public class BankApp
{
    private String user; // user whose logged into the application
    
    private Storage users; // data file manager
    private Storage passes; // data file manager
    
    private ArrayList<String> userList;
    private ArrayList<String> passList;
    
    public BankApp()
    {
        // init arrays
        userList = new ArrayList();
        passList = new ArrayList();
        
        // fill arrays
        users = new Storage("users.txt");
        users.placeContentsIn(userList);
        passes = new Storage("passes.txt");
        passes.placeContentsIn(passList);
    }
    
    /**
     * Handles UI and logic of making a new account
     */
    public void newAccount()
    {
        while(true)
        {
            String username = JOptionPane.showInputDialog(null, "Please enter your new username (enter 'stop' to exit)");
            if(username.equals("stop")) { return; }
            String password = JOptionPane.showInputDialog(null, "Please enter your new password (enter 'stop' to exit)");
            if(password.equals("stop")) { return; }
            
            // make sure username doesn't already exist and that there are no invalid chars in either username or password.
            Searcher searcher = new Searcher();
            if((searcher.search(username, userList) == -1)
                    && !username.contains(" ")
                    && !password.contains(" "))
            {
                userList.add(username);
                passList.add(password);
                return;
            }
            else // Username already exists or there are invalid chars
            {
                JOptionPane.showMessageDialog(null, "Either your username or password is invalid, please try a new one. (no spaces!)");
            }
        }
    }
    
    /**
     * Handles users logging in on program startup.
     * @return Whether or not log in was successful.
     */
    public boolean login()
    {   
        while(true)
        {
            String username = JOptionPane.showInputDialog(null, "Please enter your username (enter 'stop' to exit)");
            if(username.equals("stop")) { break; }
            String password = JOptionPane.showInputDialog(null, "Please enter your password (enter 'stop' to exit)");
            if(password.equals("stop")) { break; }
            
            if(authenticate(username, password))
            {
                user = username;
                return true; // login authenic
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username or password incorrect.");
            }
        }
        return false; // user no longer trying to login.
    }
    
    /**
     * Determine if the user has an account, and if so, if their password is correct.
     * @param username username
     * @param password password
     * @return whether or not the user and password are authentic
     */
    private boolean authenticate(String username, String password)
    {
        Searcher searcher = new Searcher();
        int usrIndex = searcher.search(username, userList);
        
        if((usrIndex != -1) && passList.get(usrIndex).equals(password))
        {
            return true;
        }
        else return false;
    }
    
    /**
     * Once log in is successful, this method will display the teller UI and account management.
     */
    public void openTeller()
    {
        TellerWindow tw = new TellerWindow(user);
        tw.show();
    }
    
    /**
     * Save new accounts before program shutdown.
     */
    public void save()
    {
       users.save(userList);
       passes.save(passList);
    }
    
    public static void main(String[] args)
    {
        BankApp app = new BankApp();
        
        while(true)
        {
            String[] options = {"Create New Account", "Log in", "Exit"};
            // Present option pane to user to eithe rmake an accound or login.
            int logOrNew = JOptionPane.showOptionDialog(null, "Welcome to SUNY ORANGE BANK AND TRUST. What would you like to do?",
                "Welcome",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if(logOrNew == 2) // exit program
            {
                break;
            }
            if(logOrNew == 0) // make new account
            {
               app.newAccount();
            }
            if(app.login())// No else so once the user has made a new account so they are prompted to login.
            {
                app.openTeller();
            }
        }
        app.save(); // Save changes made.
        JOptionPane.showMessageDialog(null, "Exiting program");
    }
    
}
