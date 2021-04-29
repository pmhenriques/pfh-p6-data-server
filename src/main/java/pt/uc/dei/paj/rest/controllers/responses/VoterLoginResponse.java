package pt.uc.dei.paj.rest.controllers.responses;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the server response to voter login requests.
 * This class is the data transfer object.
 * Login response to be returned as Json object.
 */

@XmlRootElement
public class VoterLoginResponse {

    private final String token;

    public VoterLoginResponse(String token) {
        this.token = token;
    }


}
