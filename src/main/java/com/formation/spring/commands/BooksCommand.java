package com.formation.spring.commands;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 09:44
 */
public class BooksCommand implements Command {

    private Receiver receiver;

    @Autowired
    public BooksCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.showBooks();
    }
}
