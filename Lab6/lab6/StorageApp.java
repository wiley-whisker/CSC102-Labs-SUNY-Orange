package lab6;

import java.util.ArrayList;


/**
 * Handles the logic of the application.
 * @author Wiley
 */
public class StorageApp
{
    private ArrayList<String> list;
    
    private BinarySearcher biSearch;

    private AlphaFinder finder;
    
    private Storage storage;
    
    public StorageApp()
    {
        list = new ArrayList<>();
        biSearch = new BinarySearcher();
        finder = new AlphaFinder();
        storage = new Storage("storage.txt");
        
        storage.placeContentsIn(list);
    }
    
    /**
     * A method to add a new, non-empty, string to the storage.
     * @param newEntry The new string to be added to the storage.
     */
    public void add(String newEntry)
    {
        if(newEntry.isEmpty()) { return; } // Reject blank input.
        
        // If list is empty OR new element is greater than last (all) elements, place new entry at end.
        char firstChar = Character.toLowerCase(newEntry.charAt(0));
        if(list.isEmpty() || firstChar > Character.toLowerCase(list.get(list.size()-1).charAt(0)))
        {
            list.add(newEntry);
        }
        else // Else, there are elements in the string.
        {
            // Place in alphabetical order (To the first letter).
            for(int i=0; i < list.size(); i++)
            {
                if(finder.comesFirst(newEntry, list.get(i)))
                {
                    list.add(i, newEntry);
                    i = list.size();
                } 
            }
        }
    }
    
    /**
     * A method to search the storage for a particular string.
     * @param searchItem
     * @return The index of the item, will return -1 if the item is not in the list.
     */
    public int searchFor(String searchItem)
    {
        return biSearch.search(searchItem, list);
    }
    
    
    /**
     * A method to remove an exiting string from storage.
     * @param strToRmv String to have instance of removed.
     */
    public void remove(String strToRmv)
    {
        int rmvIndex = searchFor(strToRmv);
        if(rmvIndex > -1)
        {
            list.remove(rmvIndex);
        }
    }
    /**
     * Saves the current list to hard storage.
     */
    public void saveState()
    {
        storage.save(list);
    }
    
    /**
     * Returns the current state of the list as a string.
     * @return The storage as a string(with line breaks).
     */
    public String asString()
    {
        String asStr = "";
        for(int i=0; i<list.size(); i++)
        {
            asStr = asStr + list.get(i) + "\n";
        }
        return asStr;
    }
    /**
     * Entry point for the application.
     * @param args Command line arguments.
     */ 
    public static void main(String[] args)
    {
        UserInterface ui = new UserInterface();
        ui.show();
    }
}
