package com.formation.spring.services;

import com.formation.spring.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/14/13
 * Time: 9:09 PM
 */
@Service
@Transactional
public class SimpleUserService implements com.formation.spring.services.UserService {

    @Autowired
    private com.formation.spring.dao.UserService dao;

    public SimpleUserService() {
        // Do nothing
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    public int count() {
        return dao.count();
    }
}
