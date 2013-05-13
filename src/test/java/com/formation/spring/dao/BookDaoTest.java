package com.formation.spring.dao;

import com.formation.spring.beans.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 15:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:library-config.xml")
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    @DirtiesContext
    public void testCreate() {
        assertEquals(0, bookDao.size());

        Book book = new Book("Canti");
        bookDao.save(book);

        assertEquals(1, bookDao.size());
    }

    @Test
    @DirtiesContext
    public void testRead() {
        Book book = new Book("Canti");
        book = bookDao.save(book);

        assertEquals(book, bookDao.findByName("Canti"));
    }

    @Test
    @DirtiesContext
    public void testUpdate() {
        Book book = new Book("Cantiz");
        Book canti = bookDao.save(book);

        assertEquals(canti.getName(), "Cantiz");

        canti.setName("Canti");
        Book canti2 = bookDao.update(canti);

        assertEquals(canti.getId(), canti2.getId());
        assertEquals(canti2.getName(), "Canti");
    }

    @Test
    @DirtiesContext
    public void testDelete() {
        assertEquals(0, bookDao.size());

        Book book = new Book("Giacomo");
        book = bookDao.save(book);

        assertEquals(1, bookDao.size());

        bookDao.delete(book);

        assertEquals(0, bookDao.size());
    }
}
