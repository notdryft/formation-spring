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

    public Interpreter(Map<String, Command> commands) {
        this.commands = commands;
    }

    public Command parse(String name) {
        if (!commands.containsKey(name)) {
            return commands.get("*");
        }

        return commands.get(name);
    }
}
