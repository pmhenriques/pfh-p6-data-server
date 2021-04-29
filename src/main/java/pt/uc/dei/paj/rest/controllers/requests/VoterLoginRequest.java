package pt.uc.dei.paj.rest.controllers.requests;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the request: do voterlogin.
 * This class is the data transfer object.
 * Login request to be sent as Json object.
 */
@XmlRootElement
public class VoterLoginRequest {

    /**
     * civil id number
     */
    @NotBlank
    private String civilIdNumber;

    public String getCivilIdNumber() {
        return civilIdNumber;
    }

    public void setCivilIdNumber(String civilIdNumber) {
        this.civilIdNumber = civilIdNumber;
    }
}
