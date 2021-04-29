package pt.uc.dei.paj.rest.controllers.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the request: register a new Admin.
 * This class is the data transfer object.
 * Request to be sent as Json object.
 */
@XmlRootElement
public class AdminRegisterRequest {

    /**
     * Admin username.
     */
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.-]{3,}$")
    private String username;

    /**
     * Admin password
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
