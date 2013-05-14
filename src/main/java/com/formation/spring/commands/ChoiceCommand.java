package com.formation.spring.commands;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 09:47
 */
public class ChoiceCommand implements Command {

    private Receiver receiver;

    private int choice;

    @Autowired
    public ChoiceCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    @Override
    public void execute() {
        receiver.showBook(choice);
    }
}
