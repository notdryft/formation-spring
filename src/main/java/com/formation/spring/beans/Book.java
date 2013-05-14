package com.formation.spring.beans;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 14:43
 */
public class Book implements Comparable<Book> {

    private int id;

    private String name;

    private boolean borrowed;

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

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", borrowed=").append(borrowed);
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

            return id == book.id && name.equals(book.name) && borrowed == book.borrowed;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (borrowed ? 1 : 0);

        return result;
    }

    @Override
    public int compareTo(Book book) {
        int idDiff = id - book.id;
        if (idDiff != 0) {
            return idDiff;
        }

        int nameDiff = name.compareTo(book.name);
        if (nameDiff != 0) {
            return nameDiff;
        }

        return borrowed == book.borrowed ? 0 : (borrowed ? 1 : -1);
    }
}
