package pt.uc.dei.paj.exceptions;

import javax.ejb.ApplicationException;

/**
 * Exception thrown when authentication fails username does not match with password (when user logs in and logs out).
 * Response status code 401 (unauthorized).
 */
@ApplicationException
public class AuthenticationException extends RuntimeException {

    private static final long serialVersionUID = 7644621553199034294L;

    public AuthenticationException() {
    }
}
