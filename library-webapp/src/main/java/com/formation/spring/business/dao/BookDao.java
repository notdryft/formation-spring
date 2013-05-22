package com.formation.spring.business.dao;

import com.formation.spring.business.beans.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 14:44
 */
public interface BookDao {

    Book save(Book book);

    List<Book> findAll();

    Book findById(int id);

    Book findByName(String name);

    Book update(Book book);

    boolean delete(Book book);

    int count();
}
