/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */
package lab7;

import java.util.NoSuchElementException;

/**
 * A class that stores a linked list of objects.
 * @author wiley
 */
public class MyLinkedList
{
    private Node firstNode;
    
    public MyIterator itr;
    
    /**
     * Represents a single node in the linked list.
     */
    private class Node
    {
        public Object data;
        public Node nextNode;
    }
    
    /**
     * A method to add a new element to the beginning of the LinkedList.
     * @param obj 
     */
    public void addFirst(Object obj)
    {
        Node newNode = new Node(); // Create new node
        newNode.data = obj; // Place new data into new node.
        try
        {
            // There is already a firstNode, place newnode at head of list.
            newNode.nextNode = firstNode; // Both newNode and linkedlist point to firstnode.
            firstNode = newNode; // linkedlist now sees newNode as fistnode.
        }
        catch(NullPointerException e)
        {
            // No firstNode yet exists, newNode can immidiatelly become firstNode.
            firstNode = newNode;
        }
    }
    
    /**
     * A method to access the first element in the list.
     * @return The first element in the list.
     */
    public Object getFirst()
    {
        try
        {
            // firstNode exists.
            return firstNode.data;
        }
        catch(NullPointerException e)
        {
            // No firsNode exists.
            return new NoSuchElementException("There is no first element to access.");
        }
    }
    
    /**
     * A method to remove the first element in the list.
     */
    public void removeFirst()
    {
        try
        {
            // Second node exists to be pointed to.
            firstNode = firstNode.nextNode; // firstNode now points to next node in line.
        }
        catch(NullPointerException e)
        {
            // No second node exists. point to nothing.
            firstNode = null;
        }
    }
    
    /**
     * Make a new iterator located at the first node of the list.
     */
    public void newIterator()
    {
        itr = new ListIterator(); // New iterator is sucsesfully created.
    }
    
    /**
     * An iterator for the linked list.
     */
    class ListIterator implements MyIterator
    {
        private Node currentNode;
        
        private Node prevNode = null;
        
        /**
         * Moves iterator to next element and returns that element.
         * @return The next element in the list.
         */
        public Object next()
        {
                if(currentNode == null) // Iterator is at begining of list.
                { 
                    currentNode = firstNode;
                    return currentNode.data;
                }
                else if(currentNode.nextNode != null) // Iterator has no next node to look at.
                {
                    prevNode = currentNode;
                    currentNode = currentNode.nextNode; // Move iterator to next node.
                    return currentNode.data;
                }
                else
                {
                    throw new NoSuchElementException();
                }
        }
        
        /**
         * Checks if there is a next element in the list.
         * @return True if next element exists, false if not.
         */
        public boolean hasNext()
        {
            if(currentNode != null) // Iterator even has a node.
            {
                if(currentNode.nextNode != null) // There is a next node.
                {
                    return true;
                }
            }
            else // Iterator is at begining of list.
            {
                if(firstNode != null)
                {
                    return true;
                }
            }
            return false; // No next node exists.
        }

        /**
         * Set the current element to a specific value.
         * @param obj The new value of the element.
         */
        public void set(Object obj)
        {
            try { currentNode.data = obj; }
            catch(NullPointerException e) { throw new NoSuchElementException(); } // No node exists.
            // TODO: Perhaps just have it add a new element. 
        }
        
        /**
         * Add a new element to the list and move the iterator to it.
         * @param obj Value of new element.
         */
        public void add(Object obj)
        {
            Node newNode = new Node(); // Make new node
            newNode.data = obj; // Put new data into new node.
            
            // Adding in first position of the list.
            if(currentNode == null) { firstNode = newNode; } // Skip to last instruction.
            
            // Adding to end of the list.
            else if(currentNode.nextNode == null)
            { 
                prevNode = currentNode;
                currentNode.nextNode = newNode;
            }
            
            // Adding in middle of list.
            else
            {
                newNode.nextNode = currentNode.nextNode;
                prevNode = currentNode;
                currentNode.nextNode = newNode;
            }
            currentNode = newNode; // Move iterator to created node.
        }
        
        /**
         * Removes the current element from the list.
         */
        public void remove()
        {
            if(prevNode == null) { throw new IllegalStateException(); }
            
            // No element exists to be removed.
            if(currentNode == null) { throw new NoSuchElementException(); }
            
            // Removing from end of the list.
            else if(currentNode.nextNode == null && prevNode != null)
            {
                currentNode = prevNode;
                currentNode.nextNode = null;
                prevNode = null;
            }
            
            // Removing from middle of list.
            else
            {
                prevNode.nextNode = currentNode.nextNode;
                currentNode = prevNode;
                prevNode = null;
            }
        }
    }
}
