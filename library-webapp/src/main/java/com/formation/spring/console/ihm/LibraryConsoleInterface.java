package com.formation.spring.console.ihm;

import com.formation.spring.business.exceptions.ParseException;
import com.formation.spring.console.commands.Command;
import com.formation.spring.console.commands.Interpreter;
import com.formation.spring.console.commands.Receiver;
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

    @Autowired
    private Interpreter interpreter;

    @Autowired
    private Receiver receiver;

    private BufferedReader in;

    public LibraryConsoleInterface() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void start() {
        receiver.showMenu();

        try {
            while (true) {
                System.out.print("> ");

                String line = in.readLine();

                try {
                    Command command = interpreter.parse(line);
                    command.execute();
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
