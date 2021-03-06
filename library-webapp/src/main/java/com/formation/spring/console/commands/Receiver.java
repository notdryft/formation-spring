package com.formation.spring.console.commands;

import com.formation.spring.business.beans.Book;
import com.formation.spring.business.exceptions.LibrarySecurityException;
import com.formation.spring.business.services.LibraryService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/13/13
 * Time: 11:23 PM
 */
@Component
public class Receiver {

    private static String lineSeparator = System.getProperty("line.separator");

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private LibraryService libraryService;

    public Receiver() {
        // Do nothing.
    }

    public void showMenu() {
        StringBuilder sb = new StringBuilder();

        sb.append("Book store, make your choice!").append(lineSeparator);
        sb.append("-----------------------------").append(lineSeparator);
        sb.append("- books: list all books").append(lineSeparator);
        sb.append("- quit: exit the application").append(lineSeparator);

        System.out.print(sb.toString());
    }

    @Transactional(readOnly = true)
    public void showBooks() {
        StringBuilder sb = new StringBuilder();

        sb.append("Book list, make your choice!").append(lineSeparator);
        sb.append("----------------------------").append(lineSeparator);
        for (Book book : libraryService.findAll()) {
            sb.append(book.getId()).append(" : ").append(book.getName());

            if (book.isBorrowed()) {
                sb.append(" (borrowed)");
            }

            sb.append(lineSeparator);
        }

        System.out.print(sb.toString());
    }

    @Transactional(readOnly = true)
    public void showBook(int id) {
        StringBuilder sb = new StringBuilder();

        sb.append("You choose ").append(libraryService.findById(id)).append(lineSeparator);

        System.out.println(sb.toString());
    }

    @Transactional(rollbackFor = LibrarySecurityException.class)
    public void borrowBook(int id) throws LibrarySecurityException {
        StringBuilder sb = new StringBuilder();

        Book book = libraryService.findById(id);
        book.setBorrowed(true);

        libraryService.update(book);

        sb.append("Borrowing book ").append(book.toString());

        System.out.println(sb.toString());
    }

    @Transactional
    public void lendBook(int id) {
        StringBuilder sb = new StringBuilder();

        Book book = libraryService.findById(id);
        book.setBorrowed(false);

        libraryService.update(book);

        sb.append("Lending book ").append(book.toString());

        System.out.println(sb.toString());
    }

    @Transactional
    public void deleteBook(int id) {
        StringBuilder sb = new StringBuilder();

        Book book = libraryService.findById(id);
        sb.append("Deleting book ").append(book);

        libraryService.delete(book);

        System.out.println(sb.toString());
    }

    public void exit() {
        System.out.println("! Exiting...");
        sessionFactory.close();

        System.exit(0);
    }
}
