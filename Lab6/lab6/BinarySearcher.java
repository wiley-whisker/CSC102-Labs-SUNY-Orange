package lab6;

import java.util.ArrayList;

/**
 *
 * @author Wiley
 */
public class BinarySearcher
{
    private AlphaFinder finder;

    public BinarySearcher()
    {
        finder = new AlphaFinder();
    }

    /**
     * 
     * @param searchTerm
     * @param list
     * @return 
     */
    public int search(String searchTerm, ArrayList<String> list)
    {
        return search(searchTerm, list, 0, list.size()-1);
    }
    
    /**
     * 
     * @param searchTerm
     * @param list
     * @param lower
     * @param higher
     * @return 
     */
    public int search(String searchTerm, ArrayList<String> list, int lower, int higher)
    {
        searchTerm = searchTerm.toLowerCase();
        
        // BASE CASE.
        if(higher == lower)// Search area is a single index.
        {
            if(searchTerm.equals(list.get(lower).toLowerCase()))
            {
                return lower;// can return higher or lower since they are equal.
            }
            else { return -1; }// String is not in list.
            }
        // RECURSIVE CASE.
        else
        {
            int searchIndex = (higher-lower)/2 + lower; // Middle index between higher and lower.
            String inList = list.get(searchIndex).toLowerCase();
            
            // The middle term is the searchterm.
            if(searchTerm.equals(inList))
            {
                return searchIndex;// Return its location.
            }
            else// The middle term is not the searchterm.
            {
                if(finder.comesFirst(searchTerm, inList))// The searchterm might be lower than middle.
                {
                    return search(searchTerm, list, lower, searchIndex-1);// return the search result of the first half of the list.
                }
                else// the searchterm might be higher than the middle
                {
                    return search(searchTerm, list, searchIndex+1, higher);// return the search result of the second half of the list.
                }
            }
        }
    }    
}
