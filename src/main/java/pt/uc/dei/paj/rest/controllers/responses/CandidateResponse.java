package pt.uc.dei.paj.rest.controllers.responses;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the request: create candidate
 * This class is the data transfer object.
 * Login request to be sent as Json object.
 */
@XmlRootElement
public class CandidateResponse {
    /**
     * Candidate name
     */
    @NotBlank
    private String name;
    /**
     * Candidate icon filepath
     */
    @NotBlank
    private String iconFilepath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconFilepath() {
        return iconFilepath;
    }

    public void setIconFilepath(String iconFilepath) {
        this.iconFilepath = iconFilepath;
    }
}
