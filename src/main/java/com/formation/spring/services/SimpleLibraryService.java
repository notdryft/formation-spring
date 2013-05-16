package com.formation.spring.services;

import com.formation.spring.beans.Book;
import com.formation.spring.dao.BookDao;
import com.formation.spring.exceptions.LibrarySecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
    @Transactional
    public Book save(Book book) {
        return dao.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return new ArrayList<Book>(dao.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Book findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return dao.update(book);
    }

    @Override
    @Transactional
    public boolean delete(Book book) {
        return dao.delete(book);
    }

    @Override
    @Transactional(readOnly = true)
    public int count() {
        return dao.count();
    }
}
