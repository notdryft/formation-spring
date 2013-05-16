package com.formation.spring.console.commands.books;

import com.formation.spring.console.commands.Command;
import com.formation.spring.console.commands.Receiver;
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
    public int getMaxParameters() {
        return 0;
    }

    @Override
    public boolean setParameters(String[] args) {
        return false;
    }

    @Override
    public void execute() {
        receiver.showBooks();
    }
}
