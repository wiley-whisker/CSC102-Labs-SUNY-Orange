package lab4;

import javax.swing.JOptionPane;

/**
 *
 * @author Wiley
 */
public class SortDemo
{
    Lab lab4;
    MyUtil util;
    
    public SortDemo()
    {
        lab4= new Lab("4 and 5", "Sorting", "The code for labs 4 and 5, which implement\nBubble\nMerge\nand Quick Sorts.", "10/05/2018");
        util = new MyUtil();
    }
    
    public static void main(String[] args)
    {
        // Create Demo object.
        SortDemo s = new SortDemo();
        
        //Print banner.
        JOptionPane.showMessageDialog(null, s.lab4.banner.asString());
        
        //Main Loop.
        boolean running = true;
        while(running)
        {
            // Ask user the size of array to be sorted.
            int arrInput;
            while(true)
            {
                arrInput = s.util.getInput("Please enter the size of the array to be sorted.");
                if(arrInput < 1)
                {
                   s.util.display("Invalid size: must be at least one element long."); 
                }
                else { break; }
            }

            final int SIZE = arrInput;

            // Create each array.
            int[] arrRandom = new int[SIZE];
            int[] arrSorted = new int[SIZE];
            int[] arrReverse = new int[SIZE];

            // Appropriately fill each array.
            s.util.arrFill(arrRandom, "random");
            s.util.arrFill(arrSorted, "sorted");
            s.util.arrFill(arrReverse, "reverse");

            // Remember original array state.
            String strRandom = s.util.arrAsString(arrRandom);
            String strSorted = s.util.arrAsString(arrSorted);
            String strReverse = s.util.arrAsString(arrReverse);

            // Show user unsorted arrays.
            s.util.display("Random: " + strRandom + "\n" +
                            "Sorted: " + strSorted + "\n" +
                            "Reverse: " + strReverse + 
                            "\nPress ok to sort.");

            // Ask user which algorithm to test.
            int choice = s.util.getChoice("Please select a sorting algorithm to test.",
                                        s.lab4.title,
                                        "Bubble sort",
                                        "Merge Sort",
                                        "Quick Sort");      
            switch(choice)
            {
                case 0:
                    // Bubblesort each array..
                    BubbleSort bubbleRand = new BubbleSort(arrRandom);
                    bubbleRand.sort();
                    strRandom = s.util.arrAsString(arrRandom);
                    
                    BubbleSort bubbleSorted = new BubbleSort(arrSorted);
                    bubbleSorted.sort();
                    strSorted = s.util.arrAsString(arrSorted);
                    
                    BubbleSort bubbleReverse = new BubbleSort(arrReverse);
                    bubbleReverse.sort();
                    strReverse = s.util.arrAsString(arrReverse);
                    
                    s.util.display("Random: " + strRandom + "\nNumber of comparisons: " +
                            bubbleRand.numOfComps + "\nNumber of Swaps: " + bubbleRand.numOfSwaps +
                            "\nSorted: " + strSorted + "\nNumber of comparisons: " +
                            bubbleSorted.numOfComps + "\nNumber of Swaps: " + bubbleSorted.numOfSwaps +
                            "\nReverse: " + strReverse + "\nNumber of comparisons: " +
                            bubbleReverse.numOfComps + "\nNumber of Swaps: " + bubbleReverse.numOfSwaps +
                            "\nPress ok to continue.");
                break;

                case 1:
                    // Merge Sort.
                    MergeSort mergeRand = new MergeSort(arrRandom);
                    mergeRand.sort();
                    strRandom = s.util.arrAsString(arrRandom);
                    
                    MergeSort mergeSorted = new MergeSort(arrSorted);
                    mergeSorted.sort();
                    strSorted = s.util.arrAsString(arrSorted);
                    
                    MergeSort mergeReverse = new MergeSort(arrReverse);
                    mergeReverse.sort();
                    strReverse = s.util.arrAsString(arrReverse);
                    
                    s.util.display("Random: " +strRandom + "\nNumber of comparisons: " + mergeRand.numOfComps +
                                    "\nNumber of new arrays created" + mergeRand.numOfNewArrays +
                                    "\nSorted: " + strSorted + "\nNumber of comparisons: " + mergeSorted.numOfComps +
                                    "\nNumber of new arrays created" + mergeSorted.numOfNewArrays +
                                    "\nReverse: " + strReverse + "\nNumber of comparisons: " + mergeReverse.numOfComps +
                                    "\nNumber of arrays created: " + mergeReverse.numOfNewArrays);
                break;
                
                case 2:
                    // Quick Sort.
                    QuickSort quickRand = new QuickSort(arrRandom);
                    quickRand.sort();
                    strRandom = s.util.arrAsString(arrRandom);
                    
                    QuickSort quickSorted = new QuickSort(arrSorted);
                    quickSorted.sort();
                    strSorted = s.util.arrAsString(arrSorted);
                    
                    QuickSort quickReverse = new QuickSort(arrReverse);
                    quickReverse.sort();
                    strReverse = s.util.arrAsString(arrReverse);
                    
                    s.util.display("Random: " + strRandom + "\nNumber of comparisons: " + quickRand.numOfComps +
                                    "\nNumber of new partitions created: " + quickRand.numOfParts +
                                    "\nNumber of swaps: " + quickRand.numOfSwaps +
                                    "\nSorted: " + strSorted + "\nNumber of comparisons: " + quickSorted.numOfComps +
                                    "\nNumber of new partitions created: " + quickSorted.numOfParts +
                                    "\nNumber of swaps: " + quickSorted.numOfSwaps +
                                    "\nReverse: " + strReverse + "\nNumber of comparisons: " + quickReverse.numOfComps +
                                    "\nNumber of new partitions created: " + quickReverse.numOfParts +
                                    "\nNumber of swaps: " + quickReverse.numOfSwaps);
            }
            // Ask if user would like to sort another set of arrays.
            int exit = s.util.getChoice("Please select a sorting algorithm to test.",
                                            s.lab4.title,
                                            "Sort another set of arrays",
                                            "Exit Program");
            switch(exit)
            {
                case 0:
                    // Run again.
                    break;
                case 1:
                    // Exit Program.
                    running = false;
                    break;       
            }            
        }
    }
    
}
