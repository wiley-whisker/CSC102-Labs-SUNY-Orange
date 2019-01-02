package lab4;

/**
 *
 * @author Wiley
 */
public class BubbleSort
{
    int[] arr;
    
    int numOfComps = 0;
    
    int numOfSwaps = 0;
    
    public BubbleSort(int[] arrIn)
    {
        arr = arrIn;
    }
    
    /**
     * Sort the array using optimized bubble sort.
     */
    public void sort()
    {
        boolean madeSwap = false;
        for(int i = 0; i < (arr.length - 1); i++)
        {
            for(int j = 0; j < (arr.length - i - 1); j++)
            {
                // If element above current is of lesser value than current, swap.
                if(arr[j] > arr[j + 1])
                {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    madeSwap = true;
                    numOfSwaps++;
                }
                numOfComps++;
            }
            if(!madeSwap)
            {
                i = (arr.length); // Exit for loop if no swaps were made.
            }
            else
            {
                madeSwap = false; // Array is not sorted.
            }
        }
    }
}
