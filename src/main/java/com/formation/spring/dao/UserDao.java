package com.formation.spring.dao;

import com.formation.spring.beans.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 17:13
 */
public interface UserDao {

    User save(User user);

    List<User> findAll();

    User findById(int id);

    User findByName(String name);

    User update(User user);

    boolean delete(User user);

    int size();
}
