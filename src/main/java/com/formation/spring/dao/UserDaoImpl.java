package com.formation.spring.dao;

import com.formation.spring.beans.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
public class UserDaoImpl implements UserService {

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
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("name", name));

        return (User) DataAccessUtils.singleResult(hibernateTemplate.findByCriteria(criteria));
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
