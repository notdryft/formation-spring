package com.formation.spring.dao;

import com.formation.spring.beans.Book;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 15:01
 */
@Repository
public class SetBasedBookDao implements BookDao {

    private static int counter = 0;

    private Set<Book> repository;

    public SetBasedBookDao() {
        repository = new TreeSet<Book>();
    }

    @Override
    public Book save(Book book) {
        if (findByName(book.getName()) != null) {
            return null;
        }

        Book b = new Book(book.getName());
        b.setId(++counter);

        repository.add(b);

        return b;
    }

    @Override
    public Set<Book> findAll() {
        return Collections.unmodifiableSet(repository);
    }

    @Override
    public Book findById(int id) {
        for (Book book : repository) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    @Override
    public Book findByName(String name) {
        for (Book book : repository) {
            if (book.getName().equals(name)) {
                return book;
            }
        }

        return null;
    }

    @Override
    public Book update(Book book) {
        Book b = findById(book.getId());

        if (b != null) {
            b.setName(book.getName());
        }

        return b;
    }

    @Override
    public boolean delete(Book book) {
        return repository.remove(book);
    }

    @Override
    public int size() {
        return repository.size();
    }
}
