package com.formation.spring.commands;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/13/13
 * Time: 9:04 PM
 */
public interface Command {

    int getMaxParameters();

    /**
     * Should fail if args.length > getMaxParameters()
     *
     * @param args
     * @return the validity of the arguments as a boolean
     */
    boolean setParameters(String[] args);

    void execute();
}
