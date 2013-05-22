package com.formation.spring.init;

import com.formation.spring.business.beans.Book;
import com.formation.spring.business.beans.User;
import com.formation.spring.business.services.LibraryService;
import com.formation.spring.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 17:40
 */
@Component
public class Launcher {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private UserService userService;

    public Launcher() {
        // Do nothing.
    }

    @PostConstruct
    public void init() {
        Book canti = new Book("Canti");
        Book schimatrice = new Book("Schimatrice+");
        Book fondation = new Book("Seconde fondation");
        Book heart = new Book("Heart of Darkness");
        Book lettres = new Book("Lettres à un jeune poète");

        User guillaume = userService.save(new User("Guillaume"));
        canti.setUser(guillaume);
        canti.setBorrowed(true);
        heart.setUser(guillaume);
        heart.setBorrowed(true);

        User glenn = userService.save(new User("Glenn"));
        lettres.setUser(glenn);
        lettres.setBorrowed(true);

        User evgeny = userService.save(new User("Evgeny"));
        fondation.setUser(evgeny);
        fondation.setBorrowed(true);

        libraryService.save(canti);
        libraryService.save(schimatrice);
        libraryService.save(fondation);
        libraryService.save(heart);
        libraryService.save(lettres);
    }
}
