package com.formation.spring.commands;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 09:47
 */
public class SelectCommand implements Command {

    private Receiver receiver;

    private int bookChoice;

    @Autowired
    public SelectCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public int getMaxParameters() {
        return 1;
    }

    @Override
    public boolean setParameters(String[] args) {
        if (args.length != getMaxParameters()) {
            return false;
        }

        try {
            bookChoice = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @Override
    public void execute() {
        receiver.showBook(bookChoice);
    }
}
