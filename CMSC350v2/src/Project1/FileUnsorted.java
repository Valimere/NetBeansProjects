/**
 * CMSC350
 * Project 1
 * Stephen Drollinger
 * Valimere@gmail.com
 * DATE 2 November 2013
 * NetBeans IDE 7.3
 */

package Project1;

import java.io.IOException;

public class FileUnsorted extends IOException {
    private static final long serialVersionUID = -897856973823710492L;

    /**
     * Constructs a <code>FileNotFoundException</code> with
     * <code>null</code> as its error detail message.
     */
    public FileUnsorted() {
        super();
        System.out.println("File is unsorted. Please fix, and re-run the program");
    }

}
