package com.formation.spring.services;

import com.formation.spring.beans.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@ContextConfiguration(locations = { "classpath:test-config.xml", "classpath:hibernate-test-config.xml" })
public class LibraryServiceTest {

    @Autowired
    private LibraryService libraryService;

    @Test
    @DirtiesContext
    public void testCreate() {
        assertEquals(0, libraryService.count());

        Book book = new Book("Canti");
        libraryService.save(book);

        assertEquals(1, libraryService.count());
    }

    @Test
    @DirtiesContext
    public void testRead() {
        Book book = new Book("Canti");
        book = libraryService.save(book);

        assertEquals(book, libraryService.findByName("Canti"));
    }

    @Test
    @DirtiesContext
    public void testUpdate() {
        Book book = new Book("Cantiz");
        Book canti = libraryService.save(book);

        assertEquals(canti.getName(), "Cantiz");

        canti.setName("Canti");
        Book canti2 = libraryService.update(canti);

        assertEquals(canti.getId(), canti2.getId());
        assertEquals(canti2.getName(), "Canti");
    }

    @Test
    @DirtiesContext
    public void testDelete() {
        assertEquals(0, libraryService.count());

        Book book = new Book("Giacomo");
        book = libraryService.save(book);

        assertEquals(1, libraryService.count());

        libraryService.delete(book);

        assertEquals(0, libraryService.count());
    }
}
