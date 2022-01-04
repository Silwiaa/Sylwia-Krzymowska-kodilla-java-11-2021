package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Board;
import com.kodilla.patterns.prototype.Task;
import com.kodilla.patterns.prototype.TasksList;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library>{
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            clonedLibrary.getBooks().add(book);
        }
        return clonedLibrary;
    }

    @Override
    public String toString() {
        String s = "Library [" + name + "]\n";
        for (Book book : books) {
            s = s + books.toString() + "\n";
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Library library = (Library) o;

        if (getName() != null ? !getName().equals(library.getName()) : library.getName() != null) return false;
        return getBooks() != null ? getBooks().equals(library.getBooks()) : library.getBooks() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getBooks() != null ? getBooks().hashCode() : 0);
        return result;
    }
}
