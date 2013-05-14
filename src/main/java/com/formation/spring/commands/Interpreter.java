package com.formation.spring.commands;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/13/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Interpreter {

    private Map<String, Command> commands;

    private int lastParsedInt;

    public Interpreter(Map<String, Command> commands) {
        this.commands = commands;
    }

    private boolean isInteger(String str) {
        try {
            lastParsedInt = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public Command parse(String name) {
        if (isInteger(name)) {
            ChoiceCommand command = (ChoiceCommand) commands.get("int");
            command.setChoice(lastParsedInt);

            return command;
        }

        if (!commands.containsKey(name) || name.equals("int")) {
            return commands.get("*");
        }

        return commands.get(name);
    }
}
