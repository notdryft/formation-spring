package com.formation.spring.business.dao;

import com.formation.spring.business.beans.Book;
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
public class BookDaoImpl implements BookDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Book save(Book book) {
        Integer id = (Integer) hibernateTemplate.save(book);

        return findById(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        return (List<Book>) hibernateTemplate.find("from Book");
    }

    @Override
    public Book findById(int id) {
        return hibernateTemplate.get(Book.class, id);
    }

    @Override
    public Book findByName(String name) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
        criteria.add(Restrictions.eq("name", name));

        return (Book) DataAccessUtils.requiredSingleResult(hibernateTemplate.findByCriteria(criteria));
    }

    @Override
    public Book update(Book book) {
        hibernateTemplate.update(book);

        return findById(book.getId());
    }

    @Override
    public boolean delete(Book book) {
        hibernateTemplate.delete(book);

        return true;
    }

    @Override
    public int count() {
        return DataAccessUtils.intResult(hibernateTemplate.find("select count(*) from Book"));
    }
}
