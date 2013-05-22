package com.formation.spring.business.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: notdryft
 * Date: 5/14/13
 * Time: 10:11 PM
 */
public class LibrarySecurityException extends Exception {

    public LibrarySecurityException() {
        super();
    }

    public LibrarySecurityException(String message) {
        super(message);
    }

    public LibrarySecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibrarySecurityException(Throwable cause) {
        super(cause);
    }
}
