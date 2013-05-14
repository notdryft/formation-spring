package com.formation.spring.commands;

import com.formation.spring.exceptions.ParseException;
import com.formation.spring.tools.StringTools;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/13/13
 * Time: 9:34 PM
 */
public class Interpreter {

    private Map<String, Command> commands;

    public Interpreter(Map<String, Command> commands) {
        this.commands = commands;
    }

    public Command parse(String line) throws ParseException {
        if (line == null || line.equals("")) {
            return commands.get("*");
        }

        String[] splitted = line.split(" ");

        String key = splitted[0];
        if (!commands.containsKey(key)) {
            return commands.get("*");
        }

        Command command = commands.get(key);
        if (splitted.length != command.getMaxParameters() + 1) {
            throw new ParseException("Nombre de paramètres invalides");
        }

        if (splitted.length > 1) {
            // TODO catch exception from set then rethrow as nested
            boolean valid = command.setParameters(StringTools.getArgs(splitted));
            if (!valid) {
                throw new ParseException("Paramètres invalides");
            }
        }

        return command;
    }
}
