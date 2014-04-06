/*
 * Stephen Drollinger
 * Course CMSC335
 * Date: 3/29/2014
 * Project: Project 1
 * File: BookInterface.java
 * Development Enironment Windows 7 Netbeans IDE 7.4 java 1.7.0_45
 */
package Project1;

public interface BookInterface {

    // Getters
    public String getAuthor();

    public String getTitle();

    public String getCopies();

    public int getIntCopies();

    // Setters
    public void setAuthor(String s);

    public void setTitle(String s);

    // Book checkout methods
    public boolean borrowBook();

    public boolean returnBook();
}
