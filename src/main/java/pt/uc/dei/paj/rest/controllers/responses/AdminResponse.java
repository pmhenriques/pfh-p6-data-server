package pt.uc.dei.paj.rest.controllers.responses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the server response to requests: list information about a specific Admin.
 * This class is the data transfer object.
 * Admin response to be returned as a Json object.
 */
@XmlRootElement
public class AdminResponse {
    /**
     * Admin username
     */
    private String username;

    /**
     * Admin password
     */
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
