package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        // Given
        Book book1 = new Book("Author 1", "Title 1", 2007, "a1t120071");
        Book book2 = new Book("Author 2", "Title 2", 2019, "a2t220192");
        Book book3 = new Book("Author 3", "Title 3", 2001, "a3t320073");
        Book book4 = new Book("Author 4", "Title 4", 2001, "a4t420014");
        Book book5 = new Book("Author 5", "Title 5", 2016, "a5t520165");

        Set<Book> bookSet = new HashSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        MedianAdapter medianAdapter = new MedianAdapter();

        // When
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);

        // Then
        System.out.println(publicationYearMedian);
        assertEquals(publicationYearMedian, 2007);
    }
}
