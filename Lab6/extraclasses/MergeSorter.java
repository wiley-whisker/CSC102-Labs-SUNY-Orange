package extraclasses;

import java.util.ArrayList;
import lab6.AlphaFinder;

/**
 *
 * @author Wiley
 */
public class MergeSorter
{
    private AlphaFinder finder;

    public MergeSorter()
    {
        finder = new AlphaFinder();
    }
    
    public void sort(ArrayList<String> list)
    {
        if(list.size() > 1)
        {
            int middle = list.size()/2;
            ArrayList<String> seg1;
            ArrayList<String> seg2;
            
            seg1 = (ArrayList<String>)list.subList(0, middle);
            seg2 = (ArrayList<String>)list.subList(middle+1, list.size());
            
            sort(seg1);
            sort(seg2);
            
            merge(list, seg1, seg2);
        }
    }
    
    private void merge(ArrayList<String> list ,ArrayList<String> seg1 ,ArrayList<String> seg2)
    {
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        
        //While both arrays have potential elements
        while(i1 < seg1.size() && i2 < seg2.size())
        {
            if(finder.comesFirst(seg1.get(i1), seg2.get(i2)))
            {
                list.set(i,seg1.get(i1));
                i++;
                i1++;
            }
            else// element in segment 2 is less than or equal to element in segment 2.
            {
               list.set(i,seg2.get(i2)); 
               i++;
               i2++;
            }
        }
        
        while(i1 < seg1.size())
        {
            list.set(i,seg1.get(i1));
            i++;
            i1++;
        }
        
        while(i2 < seg2.size())
        {
            list.set(i,seg2.get(i2));
            i++;
            i2++;
        }
    }
}
