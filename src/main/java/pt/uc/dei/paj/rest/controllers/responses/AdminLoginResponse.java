package pt.uc.dei.paj.rest.controllers.responses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the server response to Login requests.
 * This class is the data transfer object.
 * Login response to be returned as Json object.
 */

@XmlRootElement
public class AdminLoginResponse {

    /**
     * Token is generated in the login.
     */
    private final String token;

    public AdminLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }


}
