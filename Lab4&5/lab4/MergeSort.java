package lab4;

/**
 *
 * @author Wiley
 */
public class MergeSort
{
    int[] arr;
    
    int numOfComps = 0;
    
    int numOfNewArrays = 0; 
    
    public MergeSort(int[] arrIn)
    {
        arr = arrIn;
    }
    
    /**
     * A method to sort the entire array.
     */
    public void sort()
    {
        sort(arr);
    }
    
    /**
     * A method to sort a specific segment of the array
     * @param arrSeg array to be sorted.
     */
    public void sort(int[] arrSeg)
    {
        if(arrSeg.length > 1)
        {
            // Create two new partitions.
            int[] arrSeg1 = new int[arrSeg.length / 2];
            int[] arrSeg2 = new int[arrSeg.length - arrSeg1.length];
            
            numOfNewArrays += 2; // tally partitions FOR STATS.
            
            // Fill first segment
            for(int i = 0; i < arrSeg1.length; i++)
            {
                arrSeg1[i] = arrSeg[i];
            }
            
            // Fill second segment.
            for(int i = 0; i < arrSeg2.length; i++)
            {
                arrSeg2[i] = arrSeg[i + arrSeg1.length];
            }
            
            // Sort each new segment.
            sort(arrSeg1);
            sort(arrSeg2);
            
            // Merge sorted segments.
            merge(arrSeg, arrSeg1, arrSeg2);
        }
    }
    
    /**
     * Merge two sorted arrays into a new sorted array.
     * @param arrBase Array being filled
     * @param arrSeg1 First sorted array segment.
     * @param arrSeg2 Second sorted array segment.
     */
    private void merge(int[] arrBase, int[] arrSeg1, int[] arrSeg2)
    {
        int i = 0; // next open position in sorted array.
        int i1 = 0; // Next insertion option in first arrayseg.
        int i2 = 0; // Next insertion option in second arrayseg.
        
        // While both arrays have potential elements, fill new array with lowest element from either.
        while((i1 < arrSeg1.length) && (i2 < arrSeg2.length))
        {
            // Arrseg1 is lower
            if(arrSeg1[i1] < arrSeg2[i2])
            {
                arrBase[i] = arrSeg1[i1];
                i1++;
                numOfComps++;
            }
            else // Arrseg2 is lower
            {
                arrBase[i] = arrSeg2[i2];
                i2++;
            }
            i++;
        }
        
        // Arrseg 2 is empty, fill rest of new array with arrseg1.
        while(i1 < arrSeg1.length)
        {
            arrBase[i] = arrSeg1[i1];
            i1++;
            i++;
            numOfComps++;
        }
        
        // Arrseg 1 is empty, fill rest of new array with arrseg2.
        while(i2 < arrSeg2.length)
        {
            arrBase[i] = arrSeg2[i2];
            i2++;
            i++;
            numOfComps++;
        }
    }
}
