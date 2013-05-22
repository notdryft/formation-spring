package com.formation.spring;

import com.formation.spring.console.ihm.LibraryConsoleInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 13/05/13
 * Time: 15:02
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(
                "library-config.xml",
                "commands-config.xml",
                "aspects-config.xml",
                "hibernate-config.xml"
        );

        app.getBean("libraryConsoleInterface", LibraryConsoleInterface.class).start();
    }
}
