package com.formation.spring.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Guillaume Corré
 * Date: 14/05/13
 * Time: 15:46
 */
public class ParseException extends Exception {

    public ParseException() {
        super();
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseException(Throwable cause) {
        super(cause);
    }
}
