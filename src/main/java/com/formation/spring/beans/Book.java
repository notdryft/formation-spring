package com.formation.spring.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 14:43
 */
@Component
@Scope("prototype")
public class Book implements Comparable<Book> {

    private int id;

    private String name;

    public Book() {
        // Do nothing.
    }

    public Book(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object instanceof Book) {
            Book book = (Book) object;

            return id == book.id && name.equals(book.name);
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();

        return result;
    }

    @Override
    public int compareTo(Book book) {
        int diffId = id - book.id;
        if (diffId != 0) {
            return diffId;
        }

        return name.compareTo(book.name);
    }
}
