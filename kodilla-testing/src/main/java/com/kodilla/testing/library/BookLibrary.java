package com.kodilla.testing.library;

import java.util.*;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();

        if (titleFragment.length() < 3) {
            return bookList;
        }

        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);

        if (titleFragment.length() > 20) {
            return bookList;
        }

        bookList = resultList;
        return resultList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> booksInHandsOf = new ArrayList<>();

        Book book = new Book("Title 1", "Author 1", 2000);
        Book book2 = new Book("Title 2", "Author 2", 2011);
        Book book3 = new Book("Author 3", "Title 3", 1997);
        booksInHandsOf.add(book);
        booksInHandsOf.add(book2);
        booksInHandsOf.add(book3);

        return booksInHandsOf;
    }
}
