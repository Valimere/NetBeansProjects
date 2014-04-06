/*
 * Stephen Drollinger
 * Course CMSC335
 * Date: 3/29/2014
 * Project: Project 1
 * File: LibraryInterface.java
 * Development Enironment Windows 7 Netbeans IDE 7.4 java 1.7.0_45
 */
package Project1;

public interface LibraryInterface<T> {
    // Formal Generic Type: T

    // Methods to use the Library
    public void add(T o);

    public void delete(T o);

    // Methods checking items in and out
    public void checkIn(T o);

    public void checkOut(T o);

    // Methods to retrieve items
    public Object[] toArray();

    public int size();

    public Object getAtIndex(int i);

    public void delteAtIndex(int i);
}
