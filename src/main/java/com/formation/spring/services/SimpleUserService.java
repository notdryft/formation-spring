package com.formation.spring.services;

import com.formation.spring.beans.Book;
import com.formation.spring.beans.User;
import com.formation.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/14/13
 * Time: 9:09 PM
 */
@Service
public class SimpleUserService implements UserService {

    @Autowired
    private UserDao dao;

    public SimpleUserService() {
        // Do nothing
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public User findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    public boolean delete(User user) {
        return dao.delete(user);
    }

    @Override
    public int count() {
        return dao.count();
    }
}
