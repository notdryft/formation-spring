package com.formation.spring.ihm;

import com.formation.spring.beans.Book;
import com.formation.spring.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 15:00
 */
@Component
public class LibraryConsoleInterface {

    private static String lineSeparator = System.getProperty("line.separator");

    @Autowired
    private LibraryService libraryService;

    private BufferedReader in;

    public LibraryConsoleInterface() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private void showMenu() {
        StringBuilder sb = new StringBuilder();

        sb.append("Book list, make your choice !").append(lineSeparator);
        sb.append("-----------------------------").append(lineSeparator);
        for (Book book : libraryService.findAll()) {
            sb.append(book.getId()).append(" : ").append(book.getName()).append(lineSeparator);
        }

        System.out.println(sb.toString());
    }

    public void start() {
        showMenu();

        try {
            String line = in.readLine();
            System.out.println("line = " + line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
