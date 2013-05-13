package com.formation.spring.services;

import com.formation.spring.beans.Book;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 14:44
 */
public interface LibraryService {

    Book save(Book book);

    Set<Book> findAll();

    Book findById(int id);

    Book findByName(String name);

    Book update(Book book);

    boolean delete(Book book);

    int count();
}
