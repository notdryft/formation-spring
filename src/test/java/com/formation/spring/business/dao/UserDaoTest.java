package com.formation.spring.business.dao;

import com.formation.spring.business.beans.User;
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
@ContextConfiguration(locations = { "classpath:library-test-config.xml", "classpath:hibernate-test-config.xml" })
public class UserDaoTest {

    @Autowired
    private UserService userDao;

    @Test
    @DirtiesContext
    public void testCreate() {
        assertEquals(0, userDao.count());

        User user = new User("Canti");
        userDao.save(user);

        assertEquals(1, userDao.count());
    }

    @Test
    @DirtiesContext
    public void testRead() {
        User user = new User("Canti");
        user = userDao.save(user);

        assertEquals(user, userDao.findByName("Canti"));
    }

    @Test
    @DirtiesContext
    public void testUpdate() {
        User user = new User("Cantiz");
        User canti = userDao.save(user);

        assertEquals(canti.getName(), "Cantiz");

        canti.setName("Canti");
        User canti2 = userDao.update(canti);

        assertEquals(canti.getId(), canti2.getId());
        assertEquals(canti2.getName(), "Canti");
    }

    @Test
    @DirtiesContext
    public void testDelete() {
        assertEquals(0, userDao.count());

        User user = new User("Giacomo");
        user = userDao.save(user);

        assertEquals(1, userDao.count());

        userDao.delete(user);

        assertEquals(0, userDao.count());
    }
}
