package com.formation.spring.main;

import com.formation.spring.beans.Book;
import com.formation.spring.ihm.LibraryConsoleInterface;
import com.formation.spring.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private LibraryConsoleInterface libraryConsoleInterface;

    public Launcher() {
        // Do nothing.
    }

    public void init() {
        libraryService.save(new Book("Canti"));
        libraryService.save(new Book("Schimatrice+"));
        libraryService.save(new Book("Seconde fondation"));
        libraryService.save(new Book("Heart of Darkness"));
        libraryService.save(new Book("Lettres à un jeune poète"));
    }

    public void start() {
        libraryConsoleInterface.start();
    }
}
