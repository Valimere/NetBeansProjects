/*
 * Stephen Drollinger
 * Course CMSC335
 * Date: 3/29/2014
 * Project: Project 1
 * File: Book.java
 * Development Enironment Windows 7 Netbeans IDE 7.4 java 1.7.0_45
 */
package Project1;

public class Book implements BookInterface {

    //Book Object
    private String author, title;
    private int copies;

    // Constructors
    public Book(String a, String t, int c) {
        this.author = a;
        this.title = t;
        this.copies = c;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getCopies() {
        return String.valueOf(this.copies);
    }

    @Override
    public int getIntCopies() {
        return this.copies;
    }

    // Sets author to string setAutor
    @Override
    public void setAuthor(String setAuthor) {
        this.author = setAuthor;
    }

    // Sets title to string setTitle
    @Override
    public void setTitle(String setTitle) {
        this.title = setTitle;
    }

    // If  there are copies to lend out reduce number of copies by 1
    // Boolean value tells methods if they are successful
    @Override
    public boolean borrowBook() {
        if (this.copies > 0) {
            this.copies--;
            return true;
        } else {
            return false;
        }
    }

    // Copies incremented for returned book.
    @Override
    public boolean returnBook() {
        this.copies++;
        return true;
    }

}
