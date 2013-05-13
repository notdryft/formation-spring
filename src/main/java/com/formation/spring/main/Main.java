package com.formation.spring.main;

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

        Launcher launcher = app.getBean("launcher", Launcher.class);
        launcher.init();
        launcher.start();
    }
}
