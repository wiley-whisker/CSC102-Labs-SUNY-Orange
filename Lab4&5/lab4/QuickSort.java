package lab4;

/**
 *
 * @author Wiley
 */
public class QuickSort
{
    int[] arr;
    
    int numOfComps = 0;
    
    int numOfSwaps = 0;
    
    int numOfParts = 0;
    
    MyUtil util; // For arrSwap()
    
    public QuickSort(int[] arrIn)
    {
        arr = arrIn;
        util = new MyUtil();
    }
    
    /**
     * Sort the entire array
     */
    public void sort()
    {
       sort(arr, 0, arr.length - 1);
    }
    
    /**
     * Sort a particular partition of the array.
     * @param arrSeg Array to be sorted
     * @param from Lowest index in partition that needs sorting
     * @param to Highest index in partition that needs sorting (inclusive)
     */
    public void sort(int[] arrSeg, int from, int to)
    {
        if(from < to) // Recursive contidion.
        {
            int p = partition(arrSeg, from, to); // Find where to partition.
            numOfParts++; // FOR STATS
            
            // Sort each array partition.
            sort(arrSeg, from, p);
            sort(arrSeg, p + 1, to);
        }
    }
    
    /**
     * Partition the array such that no element in the higher partition is lower than
     * any element in the lower partition.
     * @param arrSeg Array to be partitioned.
     * @param from Lowest index to be considered for partitioning.
     * @param to Highest index to be considered for partitioning (inclusive).
     * @return 
     */
    private int partition(int[] arrSeg, int from, int to)
    {
        int pivot = arrSeg[from];
        int i = from - 1;
        int j = to + 1;
        
        while(i < j)
        {
            i++;
            while(arrSeg[i] < pivot)
            {
                i++;
                numOfComps++;
            }
            j--;
            while(arrSeg[j] > pivot)
            {
                j--;
                numOfComps++;
            }
            if(i < j)
            {
                util.arrSwap(arrSeg, i, j);
                numOfSwaps++;
            }
        }
        return(j);
    }
}
