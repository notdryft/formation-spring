package com.formation.spring.tools;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 15:43
 */
public class StringTools {

    public static String[] getArgs(String[] splitted) {
        if (splitted.length > 1) {
            String[] args = new String[splitted.length - 1];
            System.arraycopy(splitted, 1, args, 0, args.length);

            return args;
        }

        return null;
    }
}
