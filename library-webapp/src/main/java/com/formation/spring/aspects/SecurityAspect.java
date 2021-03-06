package com.formation.spring.aspects;

import com.formation.spring.business.beans.User;
import com.formation.spring.business.exceptions.LibrarySecurityException;
import com.formation.spring.business.services.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/14/13
 * Time: 10:17 PM
 */
@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private UserService userService;

    private boolean loggedIn = false;

    @Around("execution(void com.formation.spring.console.commands.Receiver.borrowBook(int))")
    public Object beforeBorrowing(ProceedingJoinPoint jp) throws Throwable {
        if (!loggedIn) {
            System.out.println("! You are not logged in");
            System.out.print("Type in your user name: ");

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String line;
            try {
                line = in.readLine();
            } catch (IOException e) {
                System.out.println("! That was not a right input...");

                return null;
            }

            User user = userService.findByName(line);
            if (user == null) {
                throw new LibrarySecurityException("! Invalid user name");
            }

            loggedIn = true;
        }

        return jp.proceed();
    }
}
