package lab6;

/**
 *
 * @author Wiley
 */
public class AlphaFinder
{
    /**
     * A method to determine if the first argument comes before the second argument alphabetically.
     * @param fstStr The string that is questioned to be lower.
     * @param sndStr The string that is questioned to be higher.
     * @return true if the first argument comes before the second alphabetically.
     */
    public boolean comesFirst(String fstStr, String sndStr)
    {
        // Make sure both strings are all lowercase for ascii comparison.
        fstStr = fstStr.toLowerCase();
        sndStr = sndStr.toLowerCase();
        
        // Create char arrays for ascii comparison.
        char[] first = fstStr.toCharArray();
        char[] second = sndStr.toCharArray();
        int shortestLen;
        boolean firstIsShorter = false;
        
        // Determine which word is shorter to avoid out of bounds and to know which to default to.
        if(first.length < second.length)
        {
            shortestLen = first.length;
            firstIsShorter = true;
        }
        else
        {
            shortestLen = second.length;
        }
        
        // Compare each respective character in the array.
        for(int i = 0; i < shortestLen; i++)
        {
            if(first[i] < second[i]) { return true; }
            if(first[i] > second[i]) { return false; }
        }
        
        // Both stings have the same characters up to the length of the shortest string, return whichever is shorter.
        return firstIsShorter;
    }
}
