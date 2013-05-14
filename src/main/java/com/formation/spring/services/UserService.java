package com.formation.spring.services;

import com.formation.spring.beans.Book;
import com.formation.spring.beans.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/14/13
 * Time: 9:07 PM
 */
public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(int id);

    User findByName(String name);

    User update(User user);

    boolean delete(User user);

    int count();
}
