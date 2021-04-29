package pt.uc.dei.paj.exceptions;

import javax.ejb.ApplicationException;

/**
 * Exception thrown when the request item was not found.
 * Response status code 404 (not found).
 */
@ApplicationException
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 7427285890433886381L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
        super();
    }
}
