package pt.uc.dei.paj.exceptions;

import javax.ejb.ApplicationException;

/**
 * Exception thrown when a user with a given username (unique) already exists.
 */
@ApplicationException
public class DuplicatedEntityException extends RuntimeException {

    private static final long serialVersionUID = 6523910700857172269L;

    public DuplicatedEntityException(String message) {
        super(message);
    }

    public DuplicatedEntityException() {
        super();
    }

}
