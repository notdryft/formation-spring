package com.formation.spring.main;

import com.formation.spring.ihm.LibraryConsoleInterface;
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
        ApplicationContext app = new ClassPathXmlApplicationContext("library-config.xml");
        app.getBean("console", LibraryConsoleInterface.class).start();
    }
}
