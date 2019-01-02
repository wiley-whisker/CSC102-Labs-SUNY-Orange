package lab6;

import java.util.ArrayList;

/**
 * A class that will can sort an ArrayList.
 * @author wiley
 */
public class QuickSorter
{
    AlphaFinder finder;
    
    public QuickSorter()
    {
        finder = new AlphaFinder();
    }
    
    /**
     * Sort an entire ArrayList of strings to alphabetical order.
     * @param list The ArrayList of strings to be sorted.
     */
    public void sort(ArrayList<String> list)
    {
        sort(list, 0, list.size()-1);
    }
    
    /**
     * Sort a particular section of an ArrayList of strings to alphabetical order. 
     * @param list The ArrayList of strings to be sorted.
     * @param from Lowest index to be sorted (inclusive).
     * @param to Highest index to be sorted (inclusive).
     */
    public void sort(ArrayList<String> list, int from, int to)
    {
        if(from < to) // Recursive case.
        {
            // Determine where to partition the list.
            int p = partition(list, from, to);
            
            // Sort each list partition.
            sort(list, from, p);
            sort(list, p+1, to);
        }
    }
    
    /**
     * A method to determine where to partition a list of strings.
     * @param list ArrayList to be used.
     * @param from Lowest part of this partition.
     * @param to Highest part of this partition.
     * @return 
     */
    private int partition(ArrayList<String> list, int from, int to)
    {
        String pivot = list.get(from); // Lowest index will be pivot.
        int i = from -1;
        int j = to + 1;
        
        while(i < j)
        {
            i++;
            while(finder.comesFirst(list.get(i), pivot))
            {
              i++;  
            }
            
            j--;
            while(finder.comesFirst(pivot, list.get(j)))
            {
                j--;
            }
            
            if(i < j)
            {
                // Swap arraylist elements.
                String temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }        
        return j; 
    }
    
//    public static void main(String[] args)
//    {
//        ArrayList<String> list = new ArrayList();
//        
//        
//        list.add("Bananna");
//        list.add("Soup");
//        list.add("Moap");
//        list.add("Zoo");
//        list.add("Sad");
//        list.add("Seek");
//        list.add("Animal");
//        
//        
//        QuickSorter q = new QuickSorter();
//        
//        q.sort(list);
//        
//        for(String str : list)
//        {
//           System.out.println(str);
//        }
//    }
}
