package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Board;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("My library 1");
        library.getBooks().add(new Book("Title 1", "Author 1", LocalDate.of(2011, 3, 20)));
        library.getBooks().add(new Book("Title 2", "Author 2", LocalDate.of(2012, 6, 26)));
        library.getBooks().add(new Book("Title 3", "Author 3", LocalDate.of(2000, 2, 10)));

        //making a shallow copy of object board
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("My library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("My library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        deepClonedLibrary.getBooks().add(new Book("Title 4", "Author 4", LocalDate.of(2012, 1, 23)));
        //When
        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        assertEquals(3, library.getBooks().size());
        assertEquals(3, clonedLibrary.getBooks().size());
        assertEquals(4, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}
