/*
 * This project was created by Wiley Matthews for use in
 * CSC102 at SUNY Orange. No authorization has been given
 * to any of my fellow classmates to directly imitate or
 * re-use this code.
 */
package lab7;

/**
 *
 * @author wiley
 */
public interface MyIterator
{
    public Object next();
    
    public boolean hasNext();
    
    public void set(Object obj);
    
    public void add(Object obj);
    
    public void remove();
}
