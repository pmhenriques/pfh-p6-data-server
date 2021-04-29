package pt.uc.dei.paj.exceptions;

import javax.ejb.ApplicationException;

/**
 * Exception thrown when token does not match with username, token is not valid.
 * Response status code 403 (forbidden).
 */
@ApplicationException
public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = -8753054148901507921L;

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException() {
        super();
    }
}
