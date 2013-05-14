package com.formation.spring.dao;

import com.formation.spring.beans.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 17:15
 */
@Repository
public class MapBasedUserDao implements UserDao {

    private static int counter = 0;

    private Map<Integer, User> repository;

    public MapBasedUserDao() {
        repository = new HashMap<Integer, User>();
    }

    @Override
    public User save(User user) {
        if (findByName(user.getName()) != null) {
            return null;
        }

        User u = new User(user.getName());
        u.setId(++counter);

        repository.put(u.getId(), u);

        return u;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(repository.values());
    }

    @Override
    public User findById(int id) {
        return repository.get(id);
    }

    @Override
    public User findByName(String name) {
        for (User user : repository.values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User update(User user) {
        User u = findById(user.getId());

        if (u != null) {
            u.setName(user.getName());
        }

        return u;
    }

    @Override
    public boolean delete(User user) {
        User u = repository.remove(user.getId());

        return u != null;
    }

    @Override
    public int count() {
        return repository.size();
    }
}
