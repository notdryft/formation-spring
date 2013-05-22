package com.formation.spring.business.dao;

import com.formation.spring.business.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 15/05/13
 * Time: 16:30
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public User save(User user) {
        Integer id = (Integer) hibernateTemplate.save(user);

        return findById(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return (List<User>) hibernateTemplate.find("from User");
    }

    @Override
    public User findById(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public User findByName(String name) {
        return (User) DataAccessUtils.singleResult(hibernateTemplate.find("from User where name = ?", name));
    }

    @Override
    public User update(User user) {
        hibernateTemplate.update(user);

        return findById(user.getId());
    }

    @Override
    public boolean delete(User user) {
        hibernateTemplate.delete(user);

        return true;
    }

    @Override
    public int count() {
        return DataAccessUtils.intResult(hibernateTemplate.find("select count(*) from User"));
    }
}
