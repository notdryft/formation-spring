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

    private void initBooks() {
        libraryService.save(new Book("Canti"));
        libraryService.save(new Book("Schimatrice+"));
        libraryService.save(new Book("Seconde fondation"));
        libraryService.save(new Book("Heart of Darkness"));
        libraryService.save(new Book("Lettres à un jeune poète"));
    }

    private void initUsers() {
        userService.save(new User("Guillaume"));
        userService.save(new User("Glenn"));
        userService.save(new User("Evgeny"));
    }

    @PostConstruct
    public void init() {
        initBooks();
        initUsers();
    }
}
