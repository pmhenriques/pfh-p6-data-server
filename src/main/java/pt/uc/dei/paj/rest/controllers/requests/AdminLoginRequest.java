package pt.uc.dei.paj.rest.controllers.requests;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the request: do login.
 * This class is the data transfer object.
 * Login request to be sent as Json object.
 */
@XmlRootElement
public class AdminLoginRequest {

    /**
     * username
     */
    @NotBlank
    private String username;

    /**
     * password
     */
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
