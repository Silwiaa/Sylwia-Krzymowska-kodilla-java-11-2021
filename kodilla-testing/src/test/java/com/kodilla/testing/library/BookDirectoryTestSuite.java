package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();

        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }

        return resultList;
    }

    @Test
    void testListBooksWithConditionReturnList() {

        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);                   // [5]
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);    // [6]
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);    // [7]
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    void testListBooksWithConditionMoreThan20() {

        //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book>resultListWith0books = new ArrayList<>();
        List<Book>resultListWith15books = generateListOfNBooks(15);
        List<Book>resultListWith40books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListWith15books);
        when(libraryDatabaseMock.listBooksWithCondition("Zero Books")). thenReturn(resultListWith0books);
        when(libraryDatabaseMock.listBooksWithCondition("Forty Books")).thenReturn(resultListWith40books);

        //When
        List<Book> listOf0books = bookLibrary.listBooksWithCondition("Zero Books");
        List<Book> listOf25books = bookLibrary.listBooksWithCondition("Any title");
        List<Book> listOf40books = bookLibrary.listBooksWithCondition("Forty Books");

        //Then
        assertEquals(0, listOf0books.size());
        assertEquals(15, listOf25books.size());
        assertEquals(40, listOf40books.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {

        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }
}
