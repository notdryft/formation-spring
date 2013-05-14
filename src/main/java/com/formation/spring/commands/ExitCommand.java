package com.formation.spring.commands;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/13/13
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExitCommand implements Command {

    private Receiver receiver;

    @Autowired
    public ExitCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
