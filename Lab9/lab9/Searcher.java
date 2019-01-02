/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */
package lab9;

import java.util.ArrayList;

/**
 * Uses linear search since the array of usernames isn't sorted 
 * @author wiley
 */
public class Searcher
{
    /**
     * Performs a linear search on a list of usernames (unsorted or sorted) 
     * @param value Search term
     * @param list ArrayList being searched
     * @return index of item, or -1 if not in list.
     */
    public int search(String value, ArrayList<String> list)
    {
        if(list.isEmpty())
        {
            return -1; // nothing in list
        }
        else
        {
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).equals(value))
                {
                    return i;// found value at i.
                }
            }
            return -1;//value not in list
        }
    }
}
