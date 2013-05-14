package com.formation.spring.services;

import com.formation.spring.beans.Book;
import com.formation.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 15:02
 */
@Service
public class SimpleLibraryService implements LibraryService {

    @Autowired
    private BookDao dao;

    public SimpleLibraryService() {
        // Do nothing.
    }

    @Override
    public Book save(Book book) {
        return dao.save(book);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<Book>(dao.findAll());
    }

    @Override
    public Book findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Book findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public Book update(Book book) {
        return dao.update(book);
    }

    @Override
    public boolean delete(Book book) {
        return dao.delete(book);
    }

    @Override
    public int count() {
        return dao.size();
    }
}
