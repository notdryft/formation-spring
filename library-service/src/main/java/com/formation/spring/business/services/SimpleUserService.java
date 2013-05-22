package com.formation.spring.business.services;

import com.formation.spring.business.beans.User;
import com.formation.spring.business.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/14/13
 * Time: 9:09 PM
 */
@Service
@WebService(endpointInterface = "com.formation.spring.business.services.UserService")
public class SimpleUserService implements UserService {

    @Autowired
    private UserDao dao;

    public SimpleUserService() {
        // Do nothing
    }

    @Override
    @Transactional
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
    @Transactional
    public User update(User user) {
        return dao.update(user);
    }

    @Override
    @Transactional
    public boolean delete(User user) {
        return dao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public int count() {
        return dao.count();
    }
}
