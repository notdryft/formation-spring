package com.formation.spring.console.commands.books;

import com.formation.spring.business.exceptions.LibrarySecurityException;
import com.formation.spring.console.commands.Command;
import com.formation.spring.console.commands.Receiver;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 16:36
 */
public class BorrowCommand implements Command {

    private Receiver receiver;

    private int bookChoice;

    @Autowired
    public BorrowCommand(Receiver receiver) {
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
        try {
            receiver.borrowBook(bookChoice);
        } catch (LibrarySecurityException e) {
            System.out.println(e.getMessage());
        }
    }
}
